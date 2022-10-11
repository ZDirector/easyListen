package com.example.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.baseui.BaseViewModel
import com.example.search.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel : BaseViewModel() {

    private val _searchSuggestList : MutableLiveData<List<String>> = MutableLiveData()
    val mSearchSuggestList : LiveData<List<String>> get() = _searchSuggestList

    fun getSearchSuggest(ketWords : String){
        viewModelScope.launch (Dispatchers.Main){
            SearchRepository.getSearchSuggest(ketWords).collect{
                _searchSuggestList.postValue(it)
            }
        }
    }

}