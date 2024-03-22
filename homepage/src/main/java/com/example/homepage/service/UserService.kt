package com.example.homepage.service

import com.example.common.bean.login.UserAccountData
import com.example.common.bean.login.UserDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("user/account")
    suspend fun getUserAccount(): UserAccountData

    @GET("user/detail")
    suspend fun getUserDetail(
        @Query("uid") userId: Long,
    ): UserDetail
}