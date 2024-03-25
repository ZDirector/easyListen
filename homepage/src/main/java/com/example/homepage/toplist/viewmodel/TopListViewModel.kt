package com.example.homepage.toplist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homepage.toplist.bean.TopDetail
import com.example.homepage.toplist.bean.TopListTab
import com.example.homepage.toplist.repostory.TopListRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TopListViewModel : ViewModel() {
    private val _topDetailsStateFlow = MutableStateFlow(emptyMap<TopListTab, List<TopDetail>>())
    val topDetailsStateFlow: StateFlow<Map<TopListTab, List<TopDetail>>> = _topDetailsStateFlow


    fun loadTopListData() {
        viewModelScope.launch {
            TopListRepository.getTopDetail().collect {
                _topDetailsStateFlow.value = TopListRepository.collectTopListMap(it)
            }
        }
    }

}