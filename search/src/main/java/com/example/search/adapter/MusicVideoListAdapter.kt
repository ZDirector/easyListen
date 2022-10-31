package com.example.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.common.bean.searchbean.Mv
import com.example.search.R
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class MusicVideoListAdapter(var musicVideoList: MutableList<Mv>) : RecyclerView.Adapter<MusicVideoListAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val itemMusicVideoPic : ImageView = view.findViewById(R.id.item_music_video_cover)
        val itemMusicVideoDur : TextView = view.findViewById(R.id.item_music_video_dur)
        val itemMusicVideoName : TextView = view.findViewById(R.id.item_music_video_name)
        val itemMusicVideoSingerName : TextView = view.findViewById(R.id.item_music_video_singer_name)
        val itemMusicVideoPlayCount : TextView = view.findViewById(R.id.item_music_video_play_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_music_video,parent,false)
        view.setOnClickListener{
            if (it != null) mItemOnClickListener.onClick(it, it.tag as Int)
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tag = position
        Glide.with(holder.itemMusicVideoPic)
            .load(musicVideoList[position].cover)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(10)))
            .into(holder.itemMusicVideoPic)

        val duration = musicVideoList[position].duration.toDuration(DurationUnit.MILLISECONDS)
        val dur = duration.toComponents { minutes, seconds, _ ->
                String.format("%02d:%02d", minutes, seconds)
            }
        holder.itemMusicVideoDur.text = dur

        holder.itemMusicVideoName.text = musicVideoList[position].name
        var singerName = ""
        musicVideoList[position].artists.forEach{
            if (singerName == "") singerName = it.name
            else singerName += "/" + it.name
        }
        holder.itemMusicVideoSingerName.text = singerName

        val playCount = if (musicVideoList[position].playCount > 100000000){
            "播放 " + "%.1f".format(musicVideoList[position].playCount.div(100000000.0)) + "亿次"
        }else if (musicVideoList[position].playCount > 100000){
            "播放 " + "%.1f".format(musicVideoList[position].playCount.div(10000.0)) + "万次"
        }else "播放 " + musicVideoList[position].playCount.toString() + "次"
        holder.itemMusicVideoPlayCount.text = playCount
    }

    override fun getItemCount() = musicVideoList.size

    private lateinit var mItemOnClickListener : ItemOnClickListener

    fun setItemOnClickListener(mItemOnClickListener : ItemOnClickListener) {
        this.mItemOnClickListener = mItemOnClickListener
    }

    companion object interface ItemOnClickListener {
        fun onClick(view : View, i : Int)
    }

}