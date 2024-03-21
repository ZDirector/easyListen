package com.example.homepage.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.common.bean.login.UserInfo

class UserViewModel: ViewModel() {

    private val _userInfo: MutableLiveData<UserInfo> = MutableLiveData()
    val userInfo: LiveData<UserInfo> = _userInfo

    fun updateUserInfo(userInfo: UserInfo) {
        _userInfo.postValue(userInfo)
    }

}