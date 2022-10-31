package com.example.search.util

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.view.*
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.PopupWindowCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.common.bean.searchbean.Song
import com.example.common.utils.MyApplication
import com.example.common.utils.windowsHeight
import com.example.music_comment.ui.MusicCommentActivity
import com.example.search.R.*

/**
 * 音乐列表的音乐设置弹出PopupWindow
 */
class MusicPopupWindow(touchView: View,song : Song) {

    private val mTouchView = touchView
    private val mSong = song
    private lateinit var topMusicImg : ImageView
    private lateinit var topMusicSongName : TextView
    private lateinit var topMusicSingerName : TextView
    private lateinit var topMusicVIP : TextView
    private lateinit var itemMusicNextPlay : ConstraintLayout
    private lateinit var itemMusicCollect : ConstraintLayout
    private lateinit var itemMusicDownload : ConstraintLayout
    private lateinit var itemMusicComment : ConstraintLayout
    private lateinit var itemMusicShare : ConstraintLayout
    private lateinit var itemMusicSinger : ConstraintLayout
    private lateinit var itemMusicAlbum : ConstraintLayout
    private lateinit var itemMusicVideo : ConstraintLayout
    private lateinit var itemMusicSingerName : TextView
    private lateinit var itemMusicAlbumName : TextView
    private lateinit var mContentView : View
    private lateinit var mPopupWindow: PopupWindow

    fun initPopWindow(){
        mContentView = LayoutInflater.from(MyApplication.context).inflate(layout.popupwindow_music_setting,null,false)

        topMusicImg = mContentView.findViewById(id.top_music_pic)
        topMusicSongName = mContentView.findViewById(id.top_music_song_name)
        topMusicSingerName = mContentView.findViewById(id.top_music_singer_name)
        topMusicVIP = mContentView.findViewById(id.top_music_label_vip)
        itemMusicNextPlay = mContentView.findViewById(id.item_music_next_play)
        itemMusicCollect = mContentView.findViewById(id.item_music_collect)
        itemMusicDownload = mContentView.findViewById(id.item_music_download)
        itemMusicComment = mContentView.findViewById(id.item_music_comment)
        itemMusicShare = mContentView.findViewById(id.item_music_share)
        itemMusicSinger = mContentView.findViewById(id.item_music_singer)
        itemMusicAlbum = mContentView.findViewById(id.item_music_album)
        itemMusicVideo = mContentView.findViewById(id.item_music_video)
        itemMusicSingerName = mContentView.findViewById(id.item_music_singer_name)
        itemMusicAlbumName = mContentView.findViewById(id.item_music_album_name)

        initOnClickListener()

        Glide
            .with(topMusicImg)
            .load(mSong.al.picUrl)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(10)))
            .override(120,120)
            .into(topMusicImg)
        val songName : String = if (mSong.alia.isNotEmpty()) mSong.name + "(" + mSong.alia[0] + ")"
        else mSong.name
        topMusicSongName.text = songName
        if (mSong.privilege.fee != 0) topMusicVIP.visibility = View.VISIBLE
        val singer : StringBuilder = StringBuilder()
        for(i in 0 until mSong.ar.size){
            if (i == 0) singer.append(mSong.ar[i].name)
            else singer.append("/" + mSong.ar[i].name )
        }
        topMusicSingerName.text = singer
        itemMusicSingerName.text = singer
        itemMusicAlbumName.text = mSong.al.name

        mPopupWindow = PopupWindow(mContentView,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT, true)
        mPopupWindow.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED
        mPopupWindow.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        mPopupWindow.animationStyle = style.music_popupwindow_anim
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.setBackgroundDrawable(ColorDrawable(0x00000000))
        mContentView.measure(makeDropDownMeasureSpec(mPopupWindow.width),
            makeDropDownMeasureSpec(mPopupWindow.height))
    }

    private fun initOnClickListener(){
        itemMusicComment.setOnClickListener {
            val intent = Intent(MyApplication.context,MusicCommentActivity::class.java)
            intent.putExtra("SongId",mSong.id)
            intent.putExtra("SongCover",mSong.al.picUrl)

            val songName : String = if (mSong.alia.isNotEmpty()) mSong.name + "(" + mSong.alia[0] + ")"
            else mSong.name
            intent.putExtra("SongName",songName)

            val singer : StringBuilder = StringBuilder()
            for(i in 0 until mSong.ar.size){
                if (i == 0) singer.append(mSong.ar[i].name)
                else singer.append("/" + mSong.ar[i].name )
            }
            intent.putExtra("Singer",singer.toString())
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            MyApplication.context.startActivity(intent)
        }
    }

    fun show(){
        //计算弹出的高度
        val location = IntArray(2)
        mTouchView.getLocationInWindow(location)
        val offsetY = (MyApplication.context.windowsHeight - location[1] - mContentView.measuredHeight) + 48//不加底部会漏空
        PopupWindowCompat.showAsDropDown(mPopupWindow, mTouchView, 0, offsetY, Gravity.START)
    }

    //设置弹窗显示时，其余空白处的背景
    fun setBackground(window: Window){
        val lp: WindowManager.LayoutParams = window.attributes
        lp.alpha = 0.5f
        window.attributes = lp

        mPopupWindow.setOnDismissListener {
            lp.alpha = 1f
            window.attributes = lp
        }
    }

    //计算contentView的宽高
    private fun makeDropDownMeasureSpec(measureSpec: Int): Int {
        val mode: Int = if (measureSpec == ViewGroup.LayoutParams.WRAP_CONTENT) {
            View.MeasureSpec.UNSPECIFIED
        } else {
            View.MeasureSpec.EXACTLY
        }
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec), mode)
    }
}