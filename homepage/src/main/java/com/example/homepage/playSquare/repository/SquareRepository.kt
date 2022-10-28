package com.example.homepage.playSquare.repository
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.homepage.network.MyNetWork
import com.example.homepage.network.ServiceCreator
import com.example.homepage.playSquare.bean.HighQualityResponse
import com.example.homepage.playSquare.bean.Playlist
import com.example.homepage.playSquare.bean.Sub
import com.example.homepage.playSquare.service.SquareService
import com.example.homepage.playSquare.source.HighListPagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.create

object SquareRepository {
    private const val PAGE_SIZE = 18
    private val squareService = ServiceCreator.retrofit.create<SquareService>()
     fun getHighList(cat: String): Flow<PagingData<Playlist>> {
         return Pager(
             config = PagingConfig(PAGE_SIZE),
             pagingSourceFactory = {
                 HighListPagingSource(squareService, cat)
             }
         ).flow
    }


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
}