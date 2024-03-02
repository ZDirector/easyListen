package com.example.common.music

import android.app.Service
import android.content.Intent
import android.graphics.Bitmap
import android.os.IBinder
import com.example.common.IMusicCommunicate
import com.example.common.IMusicService
import com.example.common.bean.searchBean.MusicBean

class MusicService : Service() {

    /**
     * 音乐播放流程控制。
     */
    private lateinit var mc: MusicControl
    private var binder: IBinder? = null

    override fun onBind(intent: Intent?): IBinder? {
        binder = MediaServiceImpl()
        return binder
    }

    override fun onCreate() {
        super.onCreate()
        mc = MusicControl(this)
    }

    private inner class MediaServiceImpl : IMusicService.Stub() {
        override fun play(pos: Int): Boolean {
            return mc.play(pos)
        }

        override fun replay(): Boolean {
            return mc.replay()
        }

        override fun pause(): Boolean {
            return mc.pause()
        }

        override fun prev(): Boolean {
            return mc.prev()
        }

        override fun next(): Boolean {
            return mc.next()
        }

        override fun stop() {
            mc.stop()
        }

        override fun duration(): Int {
            return mc.duration()
        }

        override fun position(): Int {
            return mc.position()
        }

        override fun curIndex(): Int {
            return mc.getCurPlayIndex()
        }

        override fun pendingProgress(): Int {
            return mc.pendingProgress()
        }

        override fun seekTo(progress: Int): Boolean {
            return mc.seekTo(progress)
        }

        override fun refreshPlaylist(playlist: MutableList<MusicBean>) {
            assert(playlist.isNotEmpty())
            mc.refreshPlaylist(playlist)
        }

        override fun addMusic(music: MusicBean?) {
            music?.let {
                mc.addMusic(it)
            }
        }

        override fun removeMusic(pos: Int) {
            mc.removeMusic(pos)
        }

        override fun setPlayMode(mode: Int) {
            mc.setPlayMode(mode)
        }

        override fun loadCurMusic(music: MusicBean) {
            mc.loadCurMusic(music)
        }

        override fun updateNotification(bitmap: Bitmap?, title: String?, name: String?) {

        }

        override fun cancelNotification() {

        }

        override fun resister(callback: IMusicCommunicate?) {
            callback?.let {
                mc.resister(callback)
            }
        }

        override fun unresister() {
            mc.unResister()
        }

    }

    override fun onDestroy() {
        mc.saveLatest()
        mc.exit()
        super.onDestroy()
    }
}