package com.example.homepage.toplist.repostory

import com.example.homepage.toplist.bean.TopDetail
import com.example.homepage.toplist.bean.TopListTab
import com.example.homepage.toplist.bean.topListIdMap
import com.example.homepage.toplist.network.TopNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.toList

object TopListRepository {
    fun getTopDetail(): Flow<List<TopDetail>> {
        return flow {
            val response = TopNetwork.getTopDetails()

            if (response.code == 200) {
                emit(response.list)
            }
        }.flowOn(Dispatchers.IO)
    }


    suspend fun collectTopListMap(list: List<TopDetail>): Map<TopListTab, List<TopDetail>> {
        val result = mutableMapOf<TopListTab, List<TopDetail>>()
        var cacheList: List<TopDetail>

        TopListTab.values().forEach { tab ->
            cacheList = list.asFlow()
                .filter { topDetail ->
                    topListIdMap[tab]?.contains(topDetail.id) ?: false
                }
                .flowOn(Dispatchers.IO)
                .toList()
            if (cacheList.isNotEmpty()) {
                result[tab] = cacheList
            }
        }
        return result
    }

}