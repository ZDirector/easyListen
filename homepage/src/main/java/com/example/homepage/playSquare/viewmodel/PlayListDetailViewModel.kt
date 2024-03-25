package com.example.homepage.playSquare.viewmodel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.example.common.baseui.BaseViewModel
import com.example.common.bean.home.Playlist
import com.example.common.bean.searchBean.Song
import com.example.common.utils.MyApplication
import com.example.homepage.R
import com.example.homepage.playSquare.repository.SquareRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlayListDetailViewModel : BaseViewModel() {
    private val _songsStateFlow = MutableStateFlow<List<Song>>(emptyList())
    var songsStateFlow: StateFlow<List<Song>> = _songsStateFlow

    private val _bitmapStateFlow: MutableStateFlow<Bitmap> = MutableStateFlow(
        BitmapFactory.decodeResource(
            MyApplication.context.resources,
            R.drawable.star
        )
    )
    var bitmapStateFlow: StateFlow<Bitmap> = _bitmapStateFlow

    private val _nameLiveData = MutableLiveData<String>()
    var nameLiveData: MutableLiveData<String> = _nameLiveData

    val urlLiveData = MutableLiveData<String>()

    private val _describeLiveData = MutableLiveData<String>()
    var describeLiveData: MutableLiveData<String> = _describeLiveData

    var listData: Playlist? = null

    fun getSongs(id: Long, limit: Int, offset: Int) {
        viewModelScope.launch {
            SquareRepository.getSongs(id, limit, offset).collect {
                if (it.code == 200) {
                    if (it.songs.isNotEmpty()) _songsStateFlow.value = it.songs
                }
            }
        }
    }

    fun setBitMap() {
        viewModelScope.launch(Dispatchers.IO) {
            listData?.coverImgUrl?.apply {
                val picUrl: String = if (listData!!.picUrl != "") {
                    listData?.picUrl.toString()
                } else listData?.coverImgUrl!!
                _bitmapStateFlow.value =
                    Glide.with(MyApplication.context).asBitmap().load(picUrl).submit().get()
            }
        }
    }

}