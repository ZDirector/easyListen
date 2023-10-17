package com.example.common.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.common.bean.searchBean.MusicBean
import com.example.common.bean.searchBean.SearchHistoryBean
import com.example.common.dao.PlaySongListDao
import com.example.common.dao.SearchHistoryDao
import com.example.common.utils.MyApplication

@Database(
    entities = [SearchHistoryBean::class, MusicBean::class],
    version = 2,
    exportSchema = false
)
abstract class EasyListenDB : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "easyListen.db"

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS `playSongList` (`id` INTEGER PRIMARY KEY NOT NULL, `name` TEXT NOT NULL, `url` TEXT NOT NULL, `tns` TEXT NOT NULL, `ar` TEXT NOT NULL, `arId` INTEGER NOT NULL, `al` TEXT NOT NULL, `alId` INTEGER NOT NULL, `alPicUrl` TEXT NOT NULL, `mv` INTEGER NOT NULL, `lastPlayTime` INTEGER NOT NULL)")
            }
        }

        private val sInstance: EasyListenDB by lazy {
            Room.databaseBuilder(
                MyApplication.context,
                EasyListenDB::class.java,
                DATABASE_NAME
            ).enableMultiInstanceInvalidation()
                .addMigrations(MIGRATION_1_2)
                .build()
        }

        val instance: EasyListenDB
            get() = sInstance
    }


    abstract fun searchHistoryDao(): SearchHistoryDao

    abstract fun playSongListDao(): PlaySongListDao

}