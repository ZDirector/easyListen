package com.example.common.network.interceptor

import com.example.common.constants.HttpConstants
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer ${HttpConstants.TOKEN}")
            .build()

        return chain.proceed(newRequest)
    }
}