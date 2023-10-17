package com.example.common.bean

import com.example.common.utils.showToast

data class BaseBean<T>(
    val `data`: T,
    val code: Int,
    val msg: String
) {
    fun isSuccess() = code == 200
}

inline fun <reified T> BaseBean<T>?.doSuccess(success: (T) -> Unit) {
    if (this != null && this.isSuccess() && this.data != null) {
        success.invoke(this.data)
    }
}

inline fun <reified T> BaseBean<T>?.doFailure(failure: (code: Int, msg: String) -> Unit) {
    if (this == null || !this.isSuccess() || this.data == null) {
        showToast(this?.msg ?: "")
        failure.invoke(this?.code ?: -1, this?.msg ?: "")
    }
}