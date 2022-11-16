package com.example.common.utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.danikula.videocache.HttpProxyCacheServer
import java.io.File


class MyApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        fun getProxy(): HttpProxyCacheServer {
            val app: MyApplication = context.applicationContext as MyApplication
            return app.proxy ?: app.newProxy().also { app.proxy = it }
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        CrashHandler.instance.init(context)
    }

    private var proxy: HttpProxyCacheServer? = null

    private fun newProxy(): HttpProxyCacheServer {
        return HttpProxyCacheServer.Builder(this)
            .maxCacheSize(1024 * 1024 * 1024)
            .maxCacheFilesCount(20)
            .fileNameGenerator(VideoFileNameGenerator())
            .cacheDirectory(File(context.cacheDir.toString() + "/videoCache/"))
            .build()
    }

}