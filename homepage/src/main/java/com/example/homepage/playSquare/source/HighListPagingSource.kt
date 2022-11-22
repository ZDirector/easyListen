package com.example.homepage.playSquare.source

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.common.bean.home.Playlist

import com.example.homepage.playSquare.service.SquareService


class HighListPagingSource(
    private val squareService: SquareService,
    private val cat: String
) :
    PagingSource<Long, Playlist>() {
    companion object {
        var comm: Int = 0
    }

    override fun getRefreshKey(state: PagingState<Long, Playlist>): Long? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override suspend fun load(params: LoadParams<Long>): LoadResult<Long, Playlist> {
        return try {


            val page = params.key ?: 1//当前页码，若为空则设为1
            val proxyNextKey = page + 1

            val limit = 3 //每次加载的数目
            val response =
                squareService.getHighList(((page -1) * limit).toInt(), 51, cat)
            val prevKey = if (page > 1) page - 1 else null   //计算上一页的页码
            val nextKey =
                if (response.more/*&&params.key != proxyNextKey*/) page + 1 else null //计算下一页的页码
            val responseData = response.playlists  //获取请求返回的数据
            //将数据和页码设置到LoadResult中
            LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = nextKey
            )



        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }


}