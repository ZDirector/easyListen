package com.example.common.bean

data class SearchSuggestBean(
    val code: Int,
    val result: SearchSuggestResult
)

data class SearchSuggestResult(
    val allMatch: List<AllMatch>?
)

data class AllMatch(
    val alg: String,
    val feature: String,
    val keyword: String,
    val lastKeyword: String,
    val type: Int
)