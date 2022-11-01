package com.example.homepage.playSquare.viewmodel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.example.common.baseui.BaseViewModel
import com.example.common.bean.searchbean.Song
import com.example.common.utils.MyApplication
import com.example.homepage.R
import com.example.homepage.playSquare.bean.Playlist
import com.example.homepage.playSquare.repository.SquareRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlayListDetailViewModel: BaseViewModel() {
    private val _songsStateFlow = MutableStateFlow<List<Song>>(emptyList())
    var songsStateFlow: StateFlow<List<Song>> = _songsStateFlow

    private val _bitmapStateFlow: MutableStateFlow<Bitmap> = MutableStateFlow(
        BitmapFactory.decodeResource(
            MyApplication.context.resources,
        R.drawable.star))
    var bitmapStateFlow: StateFlow<Bitmap> = _bitmapStateFlow

    private val _nameLiveData = MutableLiveData<String>()
    var nameLiveData:MutableLiveData<String> = _nameLiveData

    private val _urlLiveData = MutableLiveData<String>()
    var urlLiveData:MutableLiveData<String> = _urlLiveData

    private val _describeLiveData = MutableLiveData<String>()
    var describeLiveData:MutableLiveData<String> = _describeLiveData


    private val _listLiveData = MutableLiveData<Playlist>()
    var listLiveData:LiveData<Playlist> = _listLiveData

    fun getSongs(id: Long, limit: Int, offset: Int) {
        viewModelScope.launch {
            SquareRepository.getSongs(id, limit, offset).collect {
                Toast.makeText(MyApplication.context,"$offset offset",Toast.LENGTH_SHORT).show()
                if (it.code == 200) {
                    if (it.songs.isNotEmpty()) _songsStateFlow.value = it.songs
                }
            }
        }
    }

    fun setBitMap(){
        viewModelScope.launch(Dispatchers.IO) {
            listLiveData.value?.coverImgUrl?.apply {
                _bitmapStateFlow.value =
                    Glide.with(MyApplication.context).asBitmap().load(listLiveData.value?.coverImgUrl).submit().get()
            }
        }
    }

    fun setList(playlist: Playlist){
        _listLiveData.postValue(playlist)
    }


}