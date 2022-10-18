package com.example.homepage.music.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.common.bean.MusicSheet
import com.example.homepage.music.bean.Banner
import com.example.homepage.music.bean.Rank
import com.example.homepage.music.repostory.MusicRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.withContext

class MusicViewModel :ViewModel() {
    private val mBannerFlow = MusicRepository.getBanner()
    private val mRecoListFlow = MusicRepository.getRecoList()
        .debounce(1000)
        .catch {
            emit(listOf())
            it.printStackTrace()
        }
    private val mRankListFlow = MusicRepository.getRankList()
        .debounce(1000)
        .catch {
            emit(listOf())
            it.printStackTrace()
        }

    private val _mBanners: MutableLiveData<List<Banner>> = MutableLiveData(listOf())
    private val _mRecoLists: MutableLiveData<List<MusicSheet>> = MutableLiveData(listOf())
    private val  _mRankList: MutableLiveData<List<Rank>> = MutableLiveData(listOf())

    val mRecoLists :LiveData<List<MusicSheet>> = _mRecoLists
    val mBanners: LiveData<List<Banner>> = _mBanners
    val mRankList: LiveData<List<Rank>> = _mRankList

    suspend fun getBanners(){
        withContext(Dispatchers.Main){
            mBannerFlow.collect {
                _mBanners.value = it
            }
        }
    }


    suspend fun getRecoLists(){
        withContext(Dispatchers.Main){
            mRecoListFlow.collect{
                _mRecoLists.value = it
            }

        }
    }

    suspend fun getRanks(){
        withContext(Dispatchers.Main ){

            mRankListFlow.collect{ it ->

                _mRankList.value = it.filter {
                    it.tracks.size>2
                }
            }
        }
    }

}