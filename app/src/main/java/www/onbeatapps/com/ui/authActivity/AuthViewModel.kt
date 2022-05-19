package www.onbeatapps.com.ui.authActivity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.Credentials
import www.onbeatapps.com.data.local.prefs.AppPreferences
import www.onbeatapps.com.data.remote.ApiInterface
import www.onbeatapps.com.data.remote.coroutine.NetworkResponse
import www.onbeatapps.com.ui.base.BaseViewModel
import javax.inject.Inject


/**
 * Created by PKB on 01-06-2021.
 * PKB@gmail.com
 */
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val api: ApiInterface,
    private val appPreferences: AppPreferences
) : BaseViewModel() {

    init {


    }

    fun setLowBance(type:String){
        appPreferences.setLowBalance(type)
    }

    var success = MutableLiveData<Boolean>();
    fun otpSendAgain() {
        sendOtp(appPreferences.getPhone())

    }

    fun setFirToken(token: String) {
        appPreferences.setFireToken(token)
    }

    fun setTouchId() {
        appPreferences.setTouchId(true)
        appPreferences.setTouchIdSetUp(true)
    }

    fun setTouchIdSetUP() {
        appPreferences.setTouchId(false)
    }

    fun getTouchID(): Boolean {
        return appPreferences.getTouchId()
    }


    fun getLogin(): Boolean {
        val status = appPreferences.isLogin()
        if (!status) {
            appPreferences.setWristBalance("0.0")
            appPreferences.setBalance("0.0")
            appPreferences.setSpendingLimit("0.0")
            appPreferences.setTotalSpent("0.0")
            appPreferences.setCurrency("£")
            appPreferences.setCardStatus(false)
            appPreferences.setBand("")
            appPreferences.setTouchId(false)
            appPreferences.setTouchIdSetUp(false)
        }
        return status
    }

    fun setLoginType(type: Int) {
        appPreferences.setLoginType(type)
    }

    fun getLoginType(): Int {
        return appPreferences.getLoginType()
    }

    private val _eventIDStatus = MutableLiveData<Boolean>()
    val eventIDStatus: MutableLiveData<Boolean>
        get() = _eventIDStatus

    fun getEvent() {
        viewModelScope.launch {
            appPreferences.apply {
                when (val response = api.getEventID()) {
                    is NetworkResponse.Success -> {
                        if (response.body.isSuccess()) {
                            setEventId(response.body.eventId)
                            setEventName(response.body.eventName)
                            setCurrency(response.body.currency)
                            _eventIDStatus.value = true
                        } else showToast(response.body?.message)
                    }
                    is NetworkResponse.Error -> {
                        showToast(response.body?.message)
                        setExceptionUtil(response)
                    }
                }
            }
        }

    }

    private val _otpStatus = MutableLiveData<Boolean>()
    val otpStatus: MutableLiveData<Boolean>
        get() = _otpStatus
    var otp:Int? = null
    fun sendOtp(phone: String) {
        val paramObject = JsonObject()
        paramObject.addProperty("phone", phone)
        launchApiCall {
            appPreferences.apply {
                when (val response = api.setOtp(getEventId(), paramObject)) {
                    is NetworkResponse.Success -> {
                        if (response.body.isSuccess()) {
                            setPhone(phone)
                            setLoginType(1)
                            otp = response.body.otp
                            _otpStatus.value = true
                        } else {
                            showToast(response.body?.message)
                        }
                    }
                    is NetworkResponse.Error -> {
                        showToast(response.body?.message)
                        setExceptionUtil(response)
                    }
                }
            }
        }
    }

    private val _otpStatus1 = MutableLiveData<Boolean>()
    val otpStatus1: MutableLiveData<Boolean>
        get() = _otpStatus1

    fun getphone(): String {
        return appPreferences.getPhone()
    }
    fun setPhoneNumber(phone:String){
        appPreferences.setPhone(phone)
    }

    fun otpCheck(otp: String) {
        val paramObject = JsonObject()
        paramObject.addProperty("phone", appPreferences.getPhone())
        paramObject.addProperty("otp", otp)
        launchApiCall {
            appPreferences.apply {
                when (val response = api.checkOtp(getEventId(), paramObject)) {
                    is NetworkResponse.Success -> {
                        if (response.body.isSuccess()) {
                            _otpStatus1.value = true
                        } else {
                            showToast(response.body.message)
                        }
//                        _otpStatus.value = true

                    }
                    is NetworkResponse.Error -> {
                        showToast(response.body?.message)
                        setExceptionUtil(response)
                    }
                }
            }
        }
    }


    private val _loginStatus = MutableLiveData<Boolean>()
    val loginStatus: MutableLiveData<Boolean>
        get() = _loginStatus
    var socialtoken = ""
    fun getUser(pin: String) {

        launchApiCall {
            appPreferences.apply {
                val paramObject = JsonObject()
                if (getLoginType() == 1)
                    paramObject.addProperty("phone", getPhone())
                else {
                    paramObject.addProperty("media_token", socialtoken)
//                    if (SocPhone!="")
//                        paramObject.addProperty("phone", SocPhone)
//                    if (SocName!="")
//                        paramObject.addProperty("first_name", SocName)
//                    if (SocSName!="")
//                        paramObject.addProperty("last_name", SocSName)
//                    if (SocEmail!="")
//                        paramObject.addProperty("email", SocEmail)
                }
                paramObject.addProperty("pin", pin)
                paramObject.addProperty("push_token", fireToken())
                paramObject.addProperty("device_type", "android")
                paramObject.addProperty("code", appPreferences.getTicket())
                when (val response = api.getUser(getEventId(), paramObject)) {
                    is NetworkResponse.Success -> {
                        if (response.body.isSuccess()) {
                            setPinNumber(pin)
                            setLogin(true)
                            setUuId(response.body.uuid)
                            userId(response.body.id)
                            tokenSet(pin)
                        } else showToast(response.body?.message)

                    }
                    is NetworkResponse.Error -> {
                        showToast(response.body?.message)
                        setExceptionUtil(response)
                    }
                }
            }
        }
    }

    fun getLoginTypeStatus(): Int {
        return appPreferences.getLoginType()
    }


    private val _userCheckStatus = MutableLiveData<String>()
    val userCheckStatus: MutableLiveData<String>
        get() = _userCheckStatus

    private val _pinStatus = MutableLiveData<String>()
    val pinStatus: MutableLiveData<String>
        get() = _pinStatus



    fun forgotPass(details: JsonObject) {

        launchApiCall {
            appPreferences.apply {
                when (val response = api.forgotPassword(getEventId(),getUuId(), details)) {
                    is NetworkResponse.Success -> {
                        if (response.body.isSuccess()) {
                            if (details.toString().contains("phone"))
                            otp = response.body.otp?:0
                            showToast(response.body.message)
                            _pinStatus.value = "forgot"
                        } else {
                            if (response.body.message == "Data mismatch")
                            showToast(response.body.message)
                            else {
                                _pinStatus.value = "login"
                                showToast(response.body.message)
                            }
                        }
                    }
                    is NetworkResponse.Error -> {
                        showToast(response.body?.message)
//                        _pinStatus.value = "login"
                        if (response.body?.message != "Customer not registered with us! Try again.")
                        setExceptionUtil(response)
                    }
                }
            }
        }
    }
    var SocName = ""
    var SocSName = ""
    var SocEmail = ""
    var SocPhone = ""
    fun UserCheck(phone: String) {

        launchApiCall {
            appPreferences.apply {
                val paramObject = JsonObject()
                if (getLoginType() == 1)
                    paramObject.addProperty("phone", phone)
                else {
                    paramObject.addProperty("media_token", phone)
                    if (SocPhone!="")
                    paramObject.addProperty("phone", SocPhone)
                    if (SocName!="")
                    paramObject.addProperty("first_name", SocName)
                    if (SocSName!="")
                    paramObject.addProperty("last_name", SocSName)
                    if (SocName!="")
                    paramObject.addProperty("email", SocEmail)
                }
                paramObject.addProperty("device_type", "android")
                paramObject.addProperty("code", appPreferences.getTicket())
                when (val response = api.getUser(getEventId(), paramObject)) {
                    is NetworkResponse.Success -> {
                        if (response.body.isSuccess()) {
                            if (response.body.message == "Phone verification failed") {
                                _userCheckStatus.value = "register"
                            }
                        } else {
                            when (response.body.message) {
                                "Already registered!!!!" -> {
                                    setUuId(response.body.uuid)
                                    userId(response.body.id)
                                    _userCheckStatus.value = "popup"
                                }
                                "Already used ticket" -> {
                                    setUuId(response.body.uuid)
                                    userId(response.body.id)
                                    _userCheckStatus.value = "popup"
                                }
                                "Phone number and ticket mismatch" -> {
                                    showToast(response.body.message)
                                }
                                else -> {
                                    _userCheckStatus.value = "register"
                                }
                            }
                        }
                    }
                    is NetworkResponse.Error -> {
                        if (response.body?.message == "Couldn't register. Please try again!!") {
                            _userCheckStatus.value = "register"
                        } else {
                            showToast(response.body?.message)
                            setExceptionUtil(response)
                        }

                    }
                }
            }
        }
    }

    fun touchLogin() {
        loginUser(appPreferences.getPinNumber())
    }

    fun tokenSet(pin: String) {

        var basic = Credentials.basic(appPreferences.getUuId(), pin)
        viewModelScope.launch {
            setLoading(true)
            appPreferences.apply {
                when (val response = api.auth(basic)) {
                    is NetworkResponse.Success -> {
//                        if (response.body.isSuccess()){
                        setToken("Bearer ${response.body.token}")
                        setPinNumber(pin)
                        setLogin(true)
                        showToast("Passcode set.")
                        _loginStatus.value = true
                        setLoading(false)
                    }
                    is NetworkResponse.Error -> {
                        setLoading(false)
                        if (response.code == 401) {
                            showToast("Invalid Passcode")
                        } else {
                            showToast(response.body?.message)
                            setExceptionUtil(response)
                        }
                    }
                }
            }
        }
    }
     val _loginstatus = MutableLiveData<Boolean>()
    val loginstatus: MutableLiveData<Boolean>
        get() = _loginstatus
    fun loginUser(pin: String) {

        var basic = Credentials.basic(appPreferences.getUuId(), pin)
        viewModelScope.launch {
            setLoading(true)
            appPreferences.apply {
                when (val response = api.auth(basic)) {
                    is NetworkResponse.Success -> {
                        setToken("Bearer ${response.body.token}")
                        setPinNumber(pin)
                        setLogin(true)
                        updateFireToken()
                    }
                    is NetworkResponse.Error -> {
                        setLoading(false)
                        if (response.code == 401) {
                            showToast("Passcode entered is incorrect! Try again.")
                            _loginstatus.value = true
                        } else {
                            showToast(response.body?.message)
                            setExceptionUtil(response)
                        }
                    }
                }
            }
        }
    }

    fun updateFireToken() {
        viewModelScope.launch {
            setLoading(true)
            appPreferences.apply {
                val paramObject = JsonObject()
                paramObject.addProperty("push_token", fireToken())
                paramObject.addProperty("gender", "")
                when (val response =
                    api.fireTokenUpdate(getEventId(), userId(), getToken(), paramObject)) {
                    is NetworkResponse.Success -> {
                        if (response.body.isSuccess()) {
                            _loginStatus.value = true
                        } else showToast(response.body.message)

                        setLoading(false)
                    }
                    is NetworkResponse.Error -> {
                        showToast(response.body?.message)
                        setExceptionUtil(response)
                        setLoading(false)
                    }
                }
            }
        }
    }

    fun setToknCheck(status: Boolean) {
        appPreferences.setTokeCheck(status)

    }
    fun getPhone(): String {
        return appPreferences.getPhone()

    }


}