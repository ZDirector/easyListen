package com.example.playing.data

import com.example.common.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MusicRepository {

    private val service = RetrofitClient.retrofit.create(MusicService::class.java)

    suspend fun getMusicUrl(ids: List<Long>) = withContext(Dispatchers.IO) {
        val id = ids.joinToString(separator = ",")
        service.getMusicUrl(id)
    }

    suspend fun getLyric(id: Long) = withContext(Dispatchers.IO) {
        service.getLyric(id.toString())
    }

}