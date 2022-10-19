package com.example.common.bean

data class HotSearchBean(
    val code: Int,
    val data: List<HotSearchData>,
    val message: String
)

data class HotSearchData(
    val alg: String,
    val content: String,
    val iconType: Int,
    val iconUrl: String,
    val score: Int,
    val searchWord: String,
    val source: Int,
    val url: String
)