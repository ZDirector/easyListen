package com.example.common.network.interceptor

import com.example.common.utils.LogUtil
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class LogInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        LogUtil.v(tag = "network", msg = "=========== network request start ===========")
        logInfo(request)
        logHeaders(request)
        logBody(request)
        LogUtil.v(tag = "network", msg = "=========== network request end ===========")
        return chain.proceed(request)
    }

    private fun logHeaders(request: Request){
        LogUtil.v(tag = "network", msg = "=========== headers ===========")
        request.headers.forEach{
            LogUtil.v(tag = "network", msg = "${it.first}: ${it.second}")
        }
        LogUtil.v(tag = "network", msg = "===============================")
    }

    private fun logBody(request: Request){
        LogUtil.v(tag = "network", msg = "body: ${request.body}")
    }

    private fun logInfo(request: Request){
        LogUtil.v(tag = "network", msg = "url: ${request.url}")
        LogUtil.v(tag = "network", msg = "method: ${request.method}")
    }
}