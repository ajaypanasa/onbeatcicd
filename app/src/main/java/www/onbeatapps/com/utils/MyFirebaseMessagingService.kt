package www.onbeatapps.com.utils

import android.app.ActivityManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import org.greenrobot.eventbus.EventBus
import www.onbeatapps.com.R
import www.onbeatapps.com.data.local.prefs.AppPreferences
import www.onbeatapps.com.data.remote.ApiInterface
import www.onbeatapps.com.ui.dashBoardActivity.DashBoardActivity
import www.onbeatapps.com.ui.splash.SplashActivity
import javax.inject.Inject


@AndroidEntryPoint
class MyFirebaseMessagingService : FirebaseMessagingService() {

    @Inject lateinit var preferences: AppPreferences
    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        val json = remoteMessage.data
        Log.e("NotificationRes", json.toString())
        sendNotification(json)
        // Check if message contains a data payload.
        if (remoteMessage.data.isNotEmpty()) {

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use WorkManager.
                scheduleJob()
            } else {
                // Handle message within 10 seconds
//                handleNow()
            }
//            val json = remoteMessage.data
//            sendNotification(json)
//            if (isAppIsInBackground(this)) {
//                //                    BaseActivity.Companion.UpdateCount1();

////                try {
////                    coroutineScope {
////                        val call = async {
////                            userDataStoreRepository.reloadNotification(true)
////                        }
////                        call.await()
////                    }
////                }
//            }
        }

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    //    // [END receive_message]
//
//    // [START on_new_token]
//    /**
//     * Called if the FCM registration token is updated. This may occur if the security of
//     * the previous token had been compromised. Note that this is called when the
//     * FCM registration token is initially generated so this is where you would retrieve the token.
//     */
//
    override fun onNewToken(token: String) {
        sendRegistrationToServer(token)
    }

    //    // [END on_new_token]
//
//    /**
//     * Schedule async work using WorkManager.
//     */
    private fun scheduleJob() {
        // [START dispatch_job]
//        val work = OneTimeWorkRequest.Builder(MyWorker::class.java).build()
//        WorkManager.getInstance().beginWith(work).enqueue()
//         [END dispatch_job]
    }

    private fun sendRegistrationToServer(token: String?) {
        // TODO: Implement this method to send token to your app server.
    }

    //    /**
//     * Create and show a simple notification containing the received FCM message.
//     *
//     * @param messageBody FCM message body received.
//     */
    private fun sendNotification(messageBody: MutableMap<String, String>) {
        lateinit var intent: Intent
        if (isAppIsInBackground(this)) {
            intent = Intent(this, DashBoardActivity::class.java)
            EventBus.getDefault().post(NotificationEvent.Reload)
        } else intent = Intent(this, SplashActivity::class.java)
//         intent = Intent(this, DashBoardActivity::class.java)
        intent.addFlags(
            Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TOP)
        preferences.setLowBalance(messageBody.get("key_value")!!)
        intent.putExtra("pkb", messageBody.get("key_value"))
        val pendingIntent = PendingIntent.getActivity(
            this, 0 /* Request code */, intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val channelId = "Customer"//getString("Customer")
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(messageBody.get("title"))
            .setContentText(messageBody.get("message"))
            .setStyle(NotificationCompat.BigTextStyle())
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Channel human readable title",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
    }

    //
//    companion object {
//
//        private const val TAG = "MyFirebaseMsgService"
//    }
//
    fun isAppIsInBackground(context: Context): Boolean {
        var isInBackground = true
        val am = (context.getSystemService(ACTIVITY_SERVICE) as ActivityManager)
        val runningProcesses = am.runningAppProcesses
        for (processInfo in runningProcesses) {
            if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                for (activeProcess in processInfo.pkgList) {
                    if (activeProcess == context.packageName) {
                        isInBackground = false
                    }
                }
            }
        }
        return !isInBackground
    }
}