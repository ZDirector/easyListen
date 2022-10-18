package com.example.homepage.music.repostory

import com.example.common.bean.MusicSheet
import com.example.homepage.music.bean.Banner
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

    fun getRecoList():Flow<List<MusicSheet>>{
        return flow {
            emit(MyNetWork.getRecommendedList().result)
        }.flowOn(Dispatchers.IO)
    }

}