package com.example.search.viewmodel.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.baseui.BaseViewModel
import com.example.common.bean.searchbean.Song
import com.example.common.network.collectNetwork
import com.example.common.utils.LogUtil
import com.example.search.repository.SearchRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MusicResultViewModel : BaseViewModel() {

    private val songsList = mutableListOf<Song>()
    private val _searchMusicResultList : MutableLiveData<List<Song>> = MutableLiveData()
    val mSearchMusicResultList : LiveData<List<Song>> get() = _searchMusicResultList

    var offset : Int = 0

    fun getSearchMusicResultList(keyWords : String){
        viewModelScope.launch {
            flow {
                emit(SearchRepository.getSearchMusicResultList(keyWords, offset * 20))
            }.collectNetwork {
                success { response ->
                    LogUtil.d("getSearchMusicResultList","success")
                    if (offset == 0) songsList.clear()
                    songsList.addAll(response.result.songs)
                    _searchMusicResultList.postValue(songsList)
                }
                failure {
                    _searchMusicResultList.postValue(null)
                }
                toastError()
            }
        }
    }

}