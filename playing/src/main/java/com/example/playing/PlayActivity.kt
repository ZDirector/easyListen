package com.example.playing

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.example.common.music.service.ControlBinder
import com.example.common.music.service.MusicService

class PlayActivity : AppCompatActivity() {

    private var mControlBinder: ControlBinder? = null

    private val mConnection by lazy {
        MusicConnection()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_play)
        initData()
        initListener()
    }

    fun initData() {
        val uri = intent.getStringExtra("uri")
        val intent = Intent(this, MusicService::class.java)

        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent)
        } else {
            startService(intent)
        }
    }

    fun initListener() {

    }


    inner class MusicConnection : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            mControlBinder = service as ControlBinder
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mControlBinder = null
        }
    }


}