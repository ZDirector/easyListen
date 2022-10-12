package com.example.common.network

@Deprecated(
    message = "Deprecated. See the notes to get more information.",
    level = DeprecationLevel.WARNING
)
/**
 * Please use [collectNetwork] instead of this.
 * */
data class RetrofitResponseBody<T>(
    val status: Int,
    val message: String,
    val data: T?
)
