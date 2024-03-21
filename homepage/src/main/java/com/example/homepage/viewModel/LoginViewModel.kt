package com.example.homepage.viewModel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.bean.login.LoginData
import com.example.common.utils.showToast
import com.example.common.utils.toMd5
import com.example.homepage.repostory.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val phone: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()
    val loginEnable: MediatorLiveData<Boolean> = MediatorLiveData()
    val loginData: MutableLiveData<LoginData> = MutableLiveData()

    init {
        loginEnable.addSource(phone) {
            loginEnable.value = it.length == 11 && password.value?.isNotEmpty() == true
        }
        loginEnable.addSource(password) {
            loginEnable.value = phone.value?.length == 11 && it.isNotEmpty()
        }
    }

    fun login() {
        viewModelScope.launch {
            val phone = phone.value ?: ""
            val password = password.value ?: ""
            val response = LoginRepository.login(phone, password.toMd5())
            if (response.code == 200) {
                loginData.postValue(response)
            } else {
                showToast(response.msg)
            }
        }
    }

}