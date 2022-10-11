package com.example.search.repository

import com.example.common.network.ApiCallHandler
import com.example.common.utils.LogUtil
import com.example.common.utils.showToast
import com.example.search.network.SearchNetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

object SearchRepository {

    private const val TAG = "SearchRepository"

    fun getSearchSuggest(keyWords : String) = flow {
        val searchSuggestResponse = ApiCallHandler.apiCall { SearchNetWork.getSearchSuggest(keyWords) }
        if (searchSuggestResponse.data != null){
            val searchSuggestList = mutableListOf<String>()
            searchSuggestResponse.data!!.result.allMatch.forEach {
                searchSuggestList.add(it.keyword)
            }
            emit(searchSuggestList)
        }else{
            showToast(searchSuggestResponse.status.toString() + ": " + searchSuggestResponse.message)
            LogUtil.d(TAG,searchSuggestResponse.status.toString() + ": " + searchSuggestResponse.message)
        }
    }.flowOn(Dispatchers.IO).catch{it.printStackTrace()}

}