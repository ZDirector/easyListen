package com.example.homepage.toplist.repostory

import com.example.homepage.network.MyNetWork
import com.example.homepage.toplist.bean.*
import com.example.homepage.toplist.bean.topListIdMap
import com.example.homepage.toplist.network.TopNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

object TopListRepository {
    fun getTopDetail(): Flow<List<TopDetail>>{
        return flow {
            val response = TopNetwork.getTopDetails()

            if (response.code == 200){
                if (response.list.isNotEmpty())
                    response.list.forEach {
                        it.songs = TopNetwork.getTracks(it.id,3).songs
                    }

                    emit(response.list)

            }
        }.flowOn(Dispatchers.IO)
    }


    suspend fun collectTopListMap(list:List<TopDetail>):Map<TopListTab,List<TopDetail>>{
        val result =  mutableMapOf<TopListTab,List<TopDetail>>()
        var cacheList :List<TopDetail>

        TopListTab.values().forEach { tab->
            cacheList = list.asFlow()
                .filter {topDetail->
                    topListIdMap[tab]?.contains(topDetail.id) ?:false
                }
                .flowOn(Dispatchers.IO)
                .toList()
            if (cacheList.isNotEmpty()){
                result[tab] =cacheList
            }
        }
        return result
    }



}