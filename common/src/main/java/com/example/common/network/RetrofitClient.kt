package com.example.common.network

import com.example.common.constants.HttpConstants
import com.example.common.network.interceptor.LogInterceptor
import com.example.common.network.interceptor.RetryInterceptor
import com.example.common.network.interceptor.TokenInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = HttpConstants.BASE_URL

    private val retryInterceptor = RetryInterceptor.Builder()
        .retryInterval(3000)
        .executionCount(3)
        .build()

    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(LogInterceptor())
            .addInterceptor(retryInterceptor)
            .addInterceptor(TokenInterceptor(HttpConstants.TOKEN))
            .build()
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}