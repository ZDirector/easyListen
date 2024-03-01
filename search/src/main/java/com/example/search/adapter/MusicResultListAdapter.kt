package com.example.search.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.common.bean.searchBean.Song
import com.example.search.R

class MusicResultListAdapter(var musicResultList: MutableList<Song>) :
    RecyclerView.Adapter<MusicResultListAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemSearchMusicName: TextView = view.findViewById(R.id.item_search_music_name)
        val itemSearchMusicTns: TextView = view.findViewById(R.id.item_search_music_tns)
        val itemSearchMusicLabelVIP: TextView = view.findViewById(R.id.item_search_music_label_vip)
        val itemSearchMusicLabelAudition: TextView =
            view.findViewById(R.id.item_search_music_label_audition)
        val itemSearchMusicLabelOriginal: TextView =
            view.findViewById(R.id.item_search_music_label_original)
        val itemSearchMusicLabelSQ: TextView = view.findViewById(R.id.item_search_music_label_sq)
        val itemSearchMusicSinger: TextView = view.findViewById(R.id.item_search_music_singer)
        val itemSearchMusicAl: TextView = view.findViewById(R.id.item_search_music_al)
        val itemSearchMusicAlia: TextView = view.findViewById(R.id.item_search_music_alia)
        val itemSearchMusicSetting: ImageView = view.findViewById(R.id.item_search_music_setting)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_music_list, parent, false)
        view.setOnClickListener {
            if (it != null) mItemOnClickListener.onClick(it, it.tag as Int)
        }
        val viewHolder = ViewHolder(view)
        viewHolder.itemSearchMusicSetting.setOnClickListener {
            if (it != null) mItemOnClickListener.onClick(it, it.tag as Int)
        }
        return viewHolder
    }

    override fun getItemCount() = musicResultList.size

    private lateinit var mItemOnClickListener: ItemOnClickListener

    fun setItemOnClickListener(mItemOnClickListener: ItemOnClickListener) {
        this.mItemOnClickListener = mItemOnClickListener
    }

    companion object
    interface ItemOnClickListener {
        fun onClick(view: View, i: Int)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tag = position
        holder.itemSearchMusicSetting.tag = position

        val song = musicResultList[position]
        holder.itemSearchMusicName.text = song.name

        if (song.tns?.isNotEmpty() == true) holder.itemSearchMusicTns.text =
            "( ${song?.tns?.get(0)} )"
        if (song.privilege.fee != 0) holder.itemSearchMusicLabelVIP.visibility = View.VISIBLE
        if (song.privilege.freeTrialPrivilege.resConsumable) holder.itemSearchMusicLabelAudition.visibility =
            View.VISIBLE
        if (song.originCoverType == 1) holder.itemSearchMusicLabelOriginal.visibility = View.VISIBLE
        if (song.sq != null) holder.itemSearchMusicLabelSQ.visibility = View.VISIBLE
        val singer: StringBuilder = StringBuilder()
        for (i in 0 until song.ar.size) {
            if (i == 0) singer.append(song.ar[i].name)
            else singer.append("/" + song.ar[i].name)
        }
        holder.itemSearchMusicSinger.text = singer
        holder.itemSearchMusicAl.text = song.al.name
        if (!song.alia.isNullOrEmpty()) {
            holder.itemSearchMusicAlia.text = song.alia[0]
            holder.itemSearchMusicAlia.visibility = View.VISIBLE
        }

        if (song.privilege.st < 0) {
            holder.itemSearchMusicName.setTextColor(Color.parseColor("#d2d2d2"))
            holder.itemSearchMusicTns.setTextColor(Color.parseColor("#d2d2d2"))
            holder.itemSearchMusicSinger.setTextColor(Color.parseColor("#d2d2d2"))
            holder.itemSearchMusicAl.setTextColor(Color.parseColor("#d2d2d2"))
            holder.itemSearchMusicAlia.setTextColor(Color.parseColor("#d2d2d2"))
        }
    }

}