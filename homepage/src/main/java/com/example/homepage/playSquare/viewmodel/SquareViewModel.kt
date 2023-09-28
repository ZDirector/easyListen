package com.example.homepage.playSquare.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.common.baseui.BaseViewModel
import com.example.common.bean.home.Playlist
import com.example.homepage.playSquare.bean.HighQualityResponse
import com.example.homepage.playSquare.bean.Sub
import com.example.homepage.playSquare.repository.SquareRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SquareViewModel : BaseViewModel() {
    private val _highListStateFlow = MutableStateFlow<PagingData<Playlist>>(PagingData.empty())
    val highListStateFlow: StateFlow<PagingData<Playlist>> = _highListStateFlow

    private val _tagsStateFlow = MutableStateFlow<List<Sub>>(emptyList())
    val tagsStateFlow: StateFlow<List<Sub>> = _tagsStateFlow

    private val _squareListStateFlow = MutableStateFlow(HighQualityResponse())
    val squareListStateFlow: StateFlow<HighQualityResponse> = _squareListStateFlow




    fun getSquareList(offset: Int, limit: Int, cat: String) {
        viewModelScope.launch {
            SquareRepository.getSquareList(offset, limit, cat).collect {
                _squareListStateFlow.value = it
            }
        }
    }

    fun getTags() {
        viewModelScope.launch {
            SquareRepository.getTabs().collect {
                _tagsStateFlow.value = it
            }
        }
    }




}