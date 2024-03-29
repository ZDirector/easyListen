package com.example.homepage.service

import com.example.common.bean.login.LoginData
import com.example.common.bean.login.LogoutData
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginService {

    @GET("login/cellphone")
    suspend fun login(
        @Query("phone") phone: String,
        @Query("md5_password") password: String,
    ): LoginData

    @GET("logout")
    suspend fun logout(): LogoutData

}