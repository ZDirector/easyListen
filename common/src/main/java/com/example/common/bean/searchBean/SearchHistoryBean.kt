package com.example.common.bean.searchBean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "searchHistory")
data class SearchHistoryBean(
    @PrimaryKey
    @ColumnInfo(name = "history", typeAffinity = ColumnInfo.TEXT)
    var history : String
) {
    constructor() : this("")
}