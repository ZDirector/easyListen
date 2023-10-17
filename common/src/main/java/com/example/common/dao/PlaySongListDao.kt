package com.example.common.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.common.bean.searchBean.MusicBean

@Dao
interface PlaySongListDao {

    @Query("SELECT * From playSongList")
    fun queryPlaySongList() : List<MusicBean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add2PlaySongList(vararg history : MusicBean)

    @Query("DELETE FROM playSongList")
    fun deleteAll()

}