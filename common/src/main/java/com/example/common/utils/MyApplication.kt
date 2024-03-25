package com.example.common.utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.example.common.music.MusicManager
import java.lang.ref.WeakReference

class MyApplication : Application(), ViewModelStoreOwner {

    /**
     * 全局的音乐播放控制管理器。
     */
    var mediaManager: MusicManager? = null
        private set

    private var viewModelProvider: ViewModelProvider? = null
    private var appViewModelStore: ViewModelStore? = null
    var activityLifeCycle: ActivityLifeCycle? = null

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        fun <T : ViewModel> getAppViewModel(modelClass: Class<T>): T {
            instance.get()?.let {
                return it.getAppViewModelProvider()[modelClass]
            }
            return ViewModelProvider.NewInstanceFactory().create(modelClass)
        }

        lateinit var instance: WeakReference<MyApplication>
            private set
    }

    private fun getAppViewModelProvider(): ViewModelProvider {
        if (viewModelProvider == null) {
            val factory = ViewModelProvider.AndroidViewModelFactory.getInstance(this)
            viewModelProvider = ViewModelProvider(this, factory)
        }
        return viewModelProvider!!
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        CrashHandler.instance.init(context)
        mediaManager = MusicManager(this)
        instance = WeakReference(this)
        activityLifeCycle = ActivityLifeCycle()
        registerActivityLifecycleCallbacks(activityLifeCycle)
    }

    override fun getViewModelStore(): ViewModelStore {
        if (appViewModelStore == null) {
            appViewModelStore = ViewModelStore()
        }
        return appViewModelStore!!
    }
}