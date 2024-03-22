package com.example.homepage.repostory

import com.example.common.network.RetrofitClient
import com.example.homepage.service.LoginService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object LoginRepository {

    private val loginService: LoginService =
        RetrofitClient.retrofit.create(LoginService::class.java)

    suspend fun login(phone: String, password: String) = withContext(Dispatchers.IO) {
        loginService.login(phone, password)
    }

}