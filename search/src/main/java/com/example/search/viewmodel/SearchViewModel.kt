package com.example.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.baseui.BaseViewModel
import com.example.common.network.collectNetwork
import com.example.search.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class SearchViewModel : BaseViewModel() {

    private val _searchSuggestList : MutableLiveData<List<String>> = MutableLiveData()
    val mSearchSuggestList : LiveData<List<String>> get() = _searchSuggestList

    private val _hotSearchList : MutableLiveData<List<String>> = MutableLiveData()
    val mHotSearchList : LiveData<List<String>> get() = _hotSearchList

    private val _recommendSearchList : MutableLiveData<List<String>> = MutableLiveData()
    val mRecommendSearchList : LiveData<List<String>> get() = _recommendSearchList

    private val _searchHistoryList : MutableLiveData<List<String>> = MutableLiveData()
    val mSearchHistoryList : LiveData<List<String>> get() = _searchHistoryList

    val initMission = MutableLiveData<HashMap<String,Boolean>>(HashMap())
    var keyWords : MutableLiveData<String> = MutableLiveData()
    val isSearchResultFinishLoading = MutableLiveData<Boolean>()
    var viewMode = MutableLiveData(1)

    fun getSearchSuggest(ketWords : String){
        viewModelScope.launch{
            flow {
                emit(SearchRepository.getSearchSuggest(ketWords))
            }.collectNetwork {
                success { response ->
                    if (response.code == 200){
                        val searchSuggestList = mutableListOf<String>()
                        if (response.result.allMatch != null){
                            response.result.allMatch!!.forEach{
                                searchSuggestList.add(it.keyword)
                            }
                        }else searchSuggestList.add(ketWords)
                        _searchSuggestList.postValue(searchSuggestList)
                    }else _searchSuggestList.postValue(null)
                }
                failure {
                    _searchSuggestList.postValue(null)
                }
                toastError()
            }
        }
    }

    fun getHotSearchList(){
        viewModelScope.launch{
            flow {
                emit(SearchRepository.getHotSearchList())
            }.collectNetwork {
                success { response ->
                    val hotSearchList = mutableListOf<String>()
                    response.data.forEach{
                        hotSearchList.add(it.searchWord)
                    }
                    _hotSearchList.postValue(hotSearchList)
                    initMission.value!!["getHotSearchList"] = true
                    initMission.postValue(initMission.value)
                }
                failure {
                    _hotSearchList.postValue(null)
                }
                toastError()
            }
        }
    }

    fun getRecommendSearchList(){
        viewModelScope.launch{
            flow {
                emit(SearchRepository.getRecommendSearchList())
            }.collectNetwork {
                success { response ->
                    val recommendSearchList = mutableListOf<String>()
                    response.result.hots.forEach{
                        recommendSearchList.add(it.first)
                    }
                    _recommendSearchList.postValue(recommendSearchList)
                    initMission.value!!["getRecommendSearchList"] = true
                    initMission.postValue(initMission.value)
                }
                failure {
                    _recommendSearchList.postValue(null)
                }
                toastError()
            }
        }
    }

    fun getSearchHistory(){
        viewModelScope.launch(Dispatchers.IO) {
            SearchRepository.getSearchHistoryList().collect{ response ->
                val searchHistoryList = mutableListOf<String>()
                response.forEach{
                    searchHistoryList.add(it.history)
                }
                _searchHistoryList.postValue(searchHistoryList)
                if (!initMission.value!!.containsKey("getRecommendSearchList")){
                    initMission.value!!["getRecommendSearchList"] = true
                    initMission.postValue(initMission.value)
                }
            }
        }
    }

    fun addSearchHistory(keyWords : String){
        viewModelScope.launch(Dispatchers.IO) {
            SearchRepository.addSearchHistory(keyWords)
        }
    }

    fun delAllSearchHistory(){
        viewModelScope.launch(Dispatchers.IO) {
            SearchRepository.delAllSearchHistory()
        }
    }

    fun isSearchResultFinishLoading(isFinish : Boolean){
        isSearchResultFinishLoading.postValue(isFinish)
    }
}