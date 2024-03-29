package com.example.homepage.music.repostory

import com.example.common.bean.home.Playlist
import com.example.homepage.music.bean.Banner
import com.example.homepage.music.bean.Rank
import com.example.homepage.network.MyNetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

object MusicRepository {
    fun getBanner() : Flow<List<Banner>> {
        return flow {
            emit(MyNetWork.getBanner().banners)
        }.flowOn(Dispatchers.IO)
    }

    fun getRecoList():Flow<List<Playlist>>{
        return flow {
            emit(MyNetWork.getRecommendedList().result)
        }.flowOn(Dispatchers.IO)
    }

    fun getRankList(): Flow<List<Rank>> {
        return flow{
            val result = MyNetWork.getRankResponse()
            if (result.code == 200){
                emit(result.list)
            }
        }.flowOn(Dispatchers.IO)
    }
}