package com.example.homepage.repostory

import com.example.common.network.RetrofitClient
import com.example.homepage.service.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object UserRepository {

    private val userService: UserService =
        RetrofitClient.retrofit.create(UserService::class.java)

    suspend fun getUserAccount() = withContext(Dispatchers.IO) {
        userService.getUserAccount()
    }

    suspend fun getUserDetail(userId: Long) = withContext(Dispatchers.IO) {
        userService.getUserDetail(userId)
    }

}