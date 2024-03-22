package com.example.homepage.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.bean.login.UserInfo
import com.example.common.utils.LogUtil
import com.example.common.utils.showToast
import com.example.homepage.repostory.UserRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    private val _userInfo: MutableLiveData<UserInfo> = MutableLiveData()
    val userInfo: LiveData<UserInfo> = _userInfo

    fun updateUserInfo(userInfo: UserInfo) {
        LogUtil.d("updateUserInfo","${userInfo}")
        _userInfo.postValue(userInfo)
    }

    fun fetchUserInfo() {
        viewModelScope.launch {
            val userId = async { getUserAccount() }.await()
            if (userId == 0L || userId == 8806488443) {
                return@launch
            }
            getUserDetail(userId)
        }
    }

    private suspend fun getUserAccount(): Long {
        val response = UserRepository.getUserAccount()
        return if (response.code == 200) {
            response.account.userId
        } else {
            showToast(response.msg)
            0
        }
    }

    private suspend fun getUserDetail(userId: Long) {
        val response = UserRepository.getUserDetail(userId)
        if (response.code == 200) {
            updateUserInfo(response.profile)
        } else {
            showToast(response.msg)
        }
    }

}