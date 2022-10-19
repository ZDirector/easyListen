package com.example.common.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.common.bean.searchbean.SearchHistoryBean
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchHistoryDao {

    @Query("SELECT * From searchHistory")
    fun queryAllSearchHistory() : Flow<List<SearchHistoryBean>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSearchHistory(vararg history : SearchHistoryBean)

    @Query("DELETE FROM searchHistory")
    fun deleteAllSearchHistory()

}