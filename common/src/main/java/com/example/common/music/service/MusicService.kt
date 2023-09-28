package com.example.common.music.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.example.common.bean.searchBean.Song
import com.example.common.music.abs.MusicControl
import com.example.common.music.abs.MusicPlayer
import com.example.common.music.data.Item
import com.example.common.music.impl.*
import com.example.common.music.impl.postion.JudgePosition


class MusicService : Service() {
    private val mPlayer:MusicPlayer by lazy { MusicPlayerImpl() }
    private lateinit var mMusicControl :MusicControlImpl<Item>
    private var mList:MutableList<Item> = mutableListOf()
    private var mMode = JudgePosition.ORDER

    private val mBinder: MusicBinder = MusicBinder()
    override fun onBind(intent: Intent?): IBinder? {
        return mBinder;
    }




    inner class MusicBinder : Binder() ,ControlBinder{
        override fun playOrPause() {
            mMusicControl.playOrPause()
        }


    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val pos = intent?.getIntExtra("position", -1) ?: -1
        mList = intent?.getSerializableExtra("list") as  MutableList<Item>
        mMusicControl = MusicControlImpl(player = mPlayer,list = mList, position = JudgePosition(max = mList.size,mode = mMode, current =  pos))
        mBinder.playOrPause()
        return START_NOT_STICKY
    }



}

interface ControlBinder{
    fun playOrPause()

}
