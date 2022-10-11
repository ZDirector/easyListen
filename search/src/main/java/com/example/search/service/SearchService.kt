package com.example.search.service

import com.example.common.bean.SearchSuggestBean
import com.example.common.bean.SearchSuggestResult
import com.example.common.network.RetrofitResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("/search/suggest")
    suspend fun getSearchSuggest(
        @Query("keywords") keyWords : String,
        @Query("type") type : String = "mobile") : RetrofitResponseBody<SearchSuggestResult>
}