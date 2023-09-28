package com.example.homepage.playSquare.repository

import com.example.homepage.network.MyNetWork
import com.example.homepage.playSquare.bean.HighQualityResponse
import com.example.homepage.playSquare.bean.PlaylistSongsResponse
import com.example.homepage.playSquare.bean.Sub
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

object SquareRepository {


    fun getSquareList(offset: Int, limit:Int, cat: String):Flow<HighQualityResponse>{
        return flow {
            emit(MyNetWork.getSquareList(offset, limit, cat))
        }.flowOn(Dispatchers.IO)
    }


    fun getTabs():Flow<List<Sub>> {
        return flow {
            emit(MyNetWork.getTags().sub)
        }.flowOn(Dispatchers.IO)
    }

    fun getSongs(id:Long,limit: Int,offset: Int):Flow<PlaylistSongsResponse>{
        return flow {
            emit(MyNetWork.getSongs(id, limit, offset))
        }.flowOn(Dispatchers.IO)
    }
}