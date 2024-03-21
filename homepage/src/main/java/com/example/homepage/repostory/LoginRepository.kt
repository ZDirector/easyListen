package com.example.homepage.repostory

import com.example.common.network.RetrofitClient
import com.example.homepage.service.LoginService

object LoginRepository {

    private val loginService: LoginService =
        RetrofitClient.retrofit.create(LoginService::class.java)

    suspend fun login(phone: String, password: String) = loginService.login(phone, password)

}