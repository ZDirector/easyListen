package com.example.search.viewmodel.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.baseui.BaseViewModel
import com.example.common.bean.searchBean.Playlists
import com.example.common.network.collectNetwork
import com.example.search.repository.SearchRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MusicSheetViewModel : BaseViewModel() {

    private val musicSheetList = mutableListOf<Playlists>()
    private val _searchMusicSheetResultList : MutableLiveData<List<Playlists>> = MutableLiveData()
    val mSearchMusicSheetResultList : LiveData<List<Playlists>> get() = _searchMusicSheetResultList

    var offset : Int = 0

    fun getSearchMusicSheetResultList(keyWords : String){
        viewModelScope.launch {
            flow {
                emit(SearchRepository.getSearchMusicSheetResultList(keyWords, offset * 20))
            }.collectNetwork {
                success { response ->
                    if (offset == 0) musicSheetList.clear()
                    if (response.code == 200 && response.result.playlists != null){
                        musicSheetList.addAll(response.result.playlists!!)
                        _searchMusicSheetResultList.postValue(musicSheetList)
                    }else _searchMusicSheetResultList.postValue(null)
                }
                failure {
                    _searchMusicSheetResultList.postValue(null)
                }
                toastError()
            }
        }
    }

}