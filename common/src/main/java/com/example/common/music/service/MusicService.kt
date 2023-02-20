package com.example.common.music.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.example.common.music.abs.MusicPlayer
import com.example.common.music.impl.MusicPlayerImpl


class MusicService : Service() {
    private val mBinder: MusicBinder = MusicBinder()
    override fun onBind(intent: Intent?): IBinder? {
        return mBinder;
    }

    inner class MusicBinder : Binder() ,ControlBinder{
        private val musicPlayer = MusicPlayerImpl(preparedListener = object : MusicPlayer.PreparedListener {
            override fun prepared() {
            }

        }, completeListener = object : MusicPlayer.CompleteListener {
            override fun completed() {
            }

        }, errorListener = object : MusicPlayer.ErrorListener {
            override fun onError(what: Int, extra: Int) {

            }
        })


        override fun playOrPause(){
            musicPlayer.playOrPause()
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }
}

interface ControlBinder{
    fun playOrPause()
}
