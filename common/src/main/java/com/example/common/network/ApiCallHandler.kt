package com.example.common.network

import com.example.common.constants.HttpConstants
import com.example.common.utils.showToast
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import kotlin.coroutines.CoroutineContext

/**
 * 用于执行 [Flow] 的网络请求，用法示例如下
 *
 * ```
 * suspend fun network() {
 *     flow {
 *         emit(0)
 *     }.collectNetwork {
 *         success {
 *             // 你甚至可以连 success 都不写
 *         }
 *         timeout {
 *             // 感觉不需要的话可以直接不写
 *         }
 *         failure {
 *             // 感觉不需要的话可以直接不写
 *         }
 *     }
 * }
 * ```
 *
 * */
suspend fun <T> Flow<T>.collectNetwork(
    context: CoroutineContext = Dispatchers.IO,
    collector: NetworkFlowCollector<T>.() -> Unit
) {
    NetworkFlowCollector<T>().apply(collector).apply {
        return flowOn(context)
            .catch {
                when (it) {
                    is HttpException -> httpHandler?.invoke(it)
                    is SocketTimeoutException -> timeoutHandler?.invoke(it)
                    is IOException -> ioHandler?.invoke(it)
                    else -> failureHandler?.invoke(it)
                }
            }.collect {
                successHandler?.invoke(it)
            }
    }
}

class NetworkFlowCollector<T> {
    internal var successHandler: ((T) -> Unit)? = null
    internal var failureHandler: ((Throwable) -> Unit)? = null
    internal var httpHandler: ((HttpException) -> Unit)? = null
    internal var timeoutHandler: ((SocketTimeoutException) -> Unit)? = null
    internal var ioHandler: ((IOException) -> Unit)? = null

    fun success(block: (T) -> Unit) {
        successHandler = block
    }

    fun failure(block: (Throwable) -> Unit) {
        failureHandler = block
    }

    fun timeout(block: (SocketTimeoutException) -> Unit) {
        timeoutHandler = block
    }

    fun httpException(block: (HttpException) -> Unit) {
        httpHandler = block
    }

    fun ioException(block: (IOException) -> Unit) {
        ioHandler = block
    }
    fun toastError(){
        timeout { showToast("ErrorCode: 408,ErrorMassage: 网络连接超时，请稍后重试!") }
        httpException { showToast("ErrorCode: 400,ErrorMassage: 数据格式出错，请稍后重试!") }
        ioException { showToast("ErrorCode: -1,ErrorMassage: 请求错误!") }
    }
}

// 相当于所有retrofit网络请求的代理，所有的请求都从这里发出，并在这里处理完返回结果
@Deprecated(
    message = "Deprecated. See the notes to get more information.",
    level = DeprecationLevel.WARNING
)
/**
 * Please use [collectNetwork] instead of this.
 * */
object ApiCallHandler {

    @Deprecated(
        message = "Deprecated. See the notes to get more information.",
        level = DeprecationLevel.WARNING
    )
    /**
     * Please use [collectNetwork] instead of this.
     * */
    suspend fun <T> apiCall(networkCall: suspend () -> RetrofitResponseBody<T>): RetrofitResponseBody<T> {
        return withContext(Dispatchers.IO) {
            val res: RetrofitResponseBody<T>
            try {
                res = networkCall()
            } catch (e: Throwable) {
                return@withContext castExceptionToRetrofitResponseBody(e)
            }
            return@withContext res
        }
    }

    @Deprecated(
        message = "Deprecated. See the notes to get more information.",
        level = DeprecationLevel.WARNING
    )
    /**
     * Please use [collectNetwork] instead of this.
     * */
    private fun <T> castExceptionToRetrofitResponseBody(e: Throwable): RetrofitResponseBody<T> {
        return when (e) {
            is HttpException -> {
                val body = Gson().fromJson(
                    e.response()?.errorBody()?.string(),
                    RetrofitResponseBody::class.java
                )
                    ?: return RetrofitResponseBody(
                        status = HttpConstants.NET_ERROR,
                        message = "请求出错(${e.message})",
                        null
                    )
                RetrofitResponseBody(status = body.status, message = body.message, data = null)
            }
            is SocketTimeoutException -> {
                RetrofitResponseBody(
                    status = HttpConstants.CONNECT_TIME_OUT,
                    message = "网络连接超时，请稍后重试",
                    data = null
                )
            }
            is IOException -> {
                RetrofitResponseBody(
                    status = HttpConstants.BAD_REQUEST,
                    message = "数据格式出错，请稍后重试",
                    data = null
                )
            }
            else -> {
                RetrofitResponseBody(
                    status = HttpConstants.NET_ERROR,
                    message = "请求出错(${e.message})",
                    data = null
                )
            }
        }
    }
}