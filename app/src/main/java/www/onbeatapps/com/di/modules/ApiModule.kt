package www.onbeatapps.com.di.modules

import com.google.gson.Gson
import www.onbeatapps.com.utils.network.ConnectivityInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import www.onbeatapps.com.BuildConfig
import www.onbeatapps.com.data.local.prefs.AppPreferences
import www.onbeatapps.com.data.remote.ApiInterface
import www.onbeatapps.com.data.remote.coroutine.NetworkResponseAdapterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * Created by PKB on 03-05-2021.
 * pkb@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit): ApiInterface =
            retrofit.create(ApiInterface::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(appPreferences: AppPreferences): Retrofit {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.apply {
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
            addInterceptor(ConnectivityInterceptor(appPreferences))
        }
        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(NetworkResponseAdapterFactory())
                .client(okHttpClientBuilder.build())
                .build()
    }

    @Provides
    @Singleton
    fun provideGson() = Gson()

}