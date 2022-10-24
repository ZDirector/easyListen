package com.example.common.bean.searchbean

data class RecommendSearchBean(
    val code: Int,
    val result: RecommendSearchResult
)

data class RecommendSearchResult(
    val hots: List<Hot>
)

data class Hot(
    val first: String,
    val iconType: Int,
    val second: Int,
    val third: Any
)