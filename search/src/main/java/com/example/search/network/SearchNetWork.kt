package com.example.search.network

import com.example.common.network.RetrofitClient
import com.example.search.service.SearchService

object SearchNetWork {

    private val searchService = RetrofitClient.retrofit.create(SearchService::class.java)

    suspend fun getSearchSuggest(keyWords : String) = searchService.getSearchSuggest(keyWords)

}