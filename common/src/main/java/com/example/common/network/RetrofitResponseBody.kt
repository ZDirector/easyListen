package com.example.common.network

import com.google.gson.annotations.SerializedName

data class RetrofitResponseBody<T>(
    @SerializedName("code")
    val status: Int,
    val message: String,
    @SerializedName("result")
    val data: T?
)