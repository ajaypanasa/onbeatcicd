package www.onbeatapps.com.ui.lineUp

import dagger.hilt.android.lifecycle.HiltViewModel
import www.onbeatapps.com.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class LineUpViewModel @Inject constructor(
    private val api: www.onbeatapps.com.data.remote.ApiInterface,
    private val appPreferences: www.onbeatapps.com.data.local.prefs.AppPreferences
) : BaseViewModel() {

    init {
        launchApiCall {
//           val voucher = appDbHelper.getAllStudent()

        }
    }
}