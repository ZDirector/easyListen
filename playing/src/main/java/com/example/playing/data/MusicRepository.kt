package com.example.playing.data

import com.example.common.bean.BaseBean
import com.example.common.network.RetrofitClient

class MusicRepository {

    private val service = RetrofitClient.retrofit.create(MusicService::class.java)

    suspend fun getMusicUrl(ids: List<Long>) : BaseBean<List<MusicUrl>> {
        val id = ids.joinToString(separator = ",")
        return service.getMusicUrl(id)
    }

    suspend fun getLyric(id: Long) : LyricData {
        return service.getLyric(id.toString())
    }

}