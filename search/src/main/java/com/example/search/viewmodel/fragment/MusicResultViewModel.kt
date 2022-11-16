package com.example.search.viewmodel.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.baseui.BaseViewModel
import com.example.common.bean.searchBean.Song
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
                    if (offset == 0) songsList.clear()
                    if (response.code == 200 && response.result != null){
                        if (response.result!!.songCount != 0){
                            songsList.addAll(response.result!!.songs)
                            _searchMusicResultList.postValue(songsList)
                        }else _searchMusicResultList.postValue(null)
                    }else _searchMusicResultList.postValue(null)
                }
                failure {
                    _searchMusicResultList.postValue(null)
                }
                toastError()
            }
        }
    }

}