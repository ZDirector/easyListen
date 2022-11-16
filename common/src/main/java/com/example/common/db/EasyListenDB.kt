package com.example.common.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.common.bean.searchBean.SearchHistoryBean
import com.example.common.dao.SearchHistoryDao
import com.example.common.utils.MyApplication

@Database(entities = [SearchHistoryBean::class], version = 1, exportSchema = false)
abstract class EasyListenDB : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "easyListen.db"

        private val sInstance: EasyListenDB by lazy {
            Room.databaseBuilder(
                MyApplication.context,
                EasyListenDB::class.java,
                DATABASE_NAME
            ).enableMultiInstanceInvalidation()// 这个属性是允许多进程环境下操作数据库
                .build()
        }

        val instance: EasyListenDB
            get() = sInstance
    }

    abstract fun searchHistoryDao() : SearchHistoryDao

}