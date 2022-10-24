package com.example.search.viewmodel.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.baseui.BaseViewModel
import com.example.common.bean.searchbean.Mv
import com.example.common.bean.searchbean.Song
import com.example.common.network.collectNetwork
import com.example.search.repository.SearchRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MusicVideoViewModel : BaseViewModel() {

    private val videoList = mutableListOf<Mv>()
    private val _searchMusicVideoList : MutableLiveData<List<Mv>> = MutableLiveData()
    val mSearchMusicVideoList : LiveData<List<Mv>> get() = _searchMusicVideoList

    var offset : Int = 0

    fun getSearchMusicVideoList(keyWords : String){
        viewModelScope.launch {
            flow {
                emit(SearchRepository.getSearchMusicVideoResultList(keyWords, offset * 20))
            }.collectNetwork {
                success { response ->
                    if (offset == 0) videoList.clear()
                    videoList.addAll(response.result.mvs)
                    _searchMusicVideoList.postValue(videoList)
                }
                failure {
                    _searchMusicVideoList.postValue(null)
                }
                toastError()
            }
        }
    }


}