package com.example.common.network.interceptor

import com.example.common.utils.LogUtil
import okhttp3.Interceptor
import okhttp3.Request
import okio.IOException
import okhttp3.Response
import java.io.InterruptedIOException

class RetryInterceptor internal constructor(builder: Builder) : Interceptor {
    var executionCount : Int // 最大重试次数

    /**
     * retry间隔时间
     */
    private val retryInterval : Long // 重试的间隔

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        var response: Response = chain.proceed(request)
        var retryNum = 0
        while (!response.isSuccessful && retryNum <= executionCount) {
            LogUtil.d("RetryInterceptor","startRetry")
            val nextInterval = retryInterval
            try {
                Thread.sleep(nextInterval)
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
                throw InterruptedIOException()
            }
            retryNum++
            response = chain.proceed(request)
        }
        return response
    }

    class Builder {
        var executionCount = 3
        var retryInterval: Long = 1000
        fun executionCount(executionCount: Int): Builder {
            this.executionCount = executionCount
            return this
        }

        fun retryInterval(retryInterval: Long): Builder {
            this.retryInterval = retryInterval
            return this
        }

        fun build(): RetryInterceptor {
            return RetryInterceptor(this)
        }
    }

    init {
        executionCount = builder.executionCount
        retryInterval = builder.retryInterval
    }
}
