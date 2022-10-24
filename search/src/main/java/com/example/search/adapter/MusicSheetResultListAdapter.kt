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
import com.example.common.bean.searchbean.Playlists
import com.example.search.R

class MusicSheetResultListAdapter(var musicSheetList : MutableList<Playlists>) : RecyclerView.Adapter<MusicSheetResultListAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val itemMusicSheetPic : ImageView = view.findViewById(R.id.item_music_sheet_pic)
        val itemMusicSheetName : TextView = view.findViewById(R.id.item_music_sheet_name)
        val itemMusicSheetSongsCount : TextView = view.findViewById(R.id.item_music_sheet_songs_count)
        val itemMusicSheetCreator : TextView = view.findViewById(R.id.item_music_sheet_creator)
        val itemMusicSheetPlayCount : TextView = view.findViewById(R.id.item_music_sheet_play_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_music_sheet,parent,false)
        view.setOnClickListener{
            if (it != null) mItemOnClickListener.onClick(it, it.tag as Int)
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tag = position
        Glide.with(holder.itemMusicSheetPic)
            .load(musicSheetList[position].coverImgUrl)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(10)))
            .override(120,120)
            .into(holder.itemMusicSheetPic)

        holder.itemMusicSheetName.text = musicSheetList[position].name
        holder.itemMusicSheetSongsCount.text = musicSheetList[position].trackCount.toString() + "首，"
        holder.itemMusicSheetCreator.text = "by " + musicSheetList[position].creator.nickname

        val playCount = if (musicSheetList[position].playCount > 100000000){
            "，播放 " + "%.1f".format(musicSheetList[position].playCount.div(100000000.0)) + "亿次"
        }else if (musicSheetList[position].playCount > 100000){
            "，播放 " + "%.1f".format(musicSheetList[position].playCount.div(10000.0)) + "万次"
        }else
            "，播放 " + musicSheetList[position].playCount.toString() + "次"
        holder.itemMusicSheetPlayCount.text = playCount
    }

    override fun getItemCount() = musicSheetList.size

    private lateinit var mItemOnClickListener : ItemOnClickListener

    fun setItemOnClickListener(mItemOnClickListener : ItemOnClickListener) {
        this.mItemOnClickListener = mItemOnClickListener
    }

    companion object interface ItemOnClickListener {
        fun onClick(view : View, i : Int)
    }

}