package com.example.common.utils

import android.content.Context.MODE_PRIVATE
import com.example.common.db.EasyListenDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object LogoutUtils {

    fun logout() {
        GlobalScope.launch(Dispatchers.Default) {
            val prefs = MyApplication.context.getSharedPreferences("data", MODE_PRIVATE)
            val editor = prefs.edit()
            editor.putString("cookie", "")
            editor.putLong("current_music_id", -1)
            editor.apply()

            EasyListenDB.instance.searchHistoryDao().deleteAllSearchHistory()
            EasyListenDB.instance.playSongListDao().deleteAll()

            MyApplication.instance.get()?.viewModelStore?.clear()
            MyApplication.instance.get()?.activityLifeCycle?.closeAll()
        }
    }

}