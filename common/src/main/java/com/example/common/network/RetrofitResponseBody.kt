package com.example.common.network

data class RetrofitResponseBody<T>(
    val status: Int,
    val message: String,
    val data: T?
)