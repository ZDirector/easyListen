package com.example.common.network.interceptor

import com.example.common.constants.HttpConstants
import com.example.common.utils.encodeUTF8
import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // 获取原始的请求
        val originalRequest = chain.request()
        // 获取原始的URL
        val originalHttpUrl = originalRequest.url

        // 添加公共请求参数
        val urlWithParams = originalHttpUrl.newBuilder()
            .addQueryParameter("cookie", HttpConstants.COOKIE.encodeUTF8())
            .addQueryParameter("timestamp", System.currentTimeMillis().toString())
            .build()

        // 构造新的请求
        val newRequest = originalRequest.newBuilder()
            .url(urlWithParams)
            .build()

        // 继续处理请求
        return chain.proceed(newRequest)
    }
}
