package com.example.playing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.common.R
import com.example.common.utils.BaseListAdapter
import com.example.playing.data.LyricLine
import com.example.playing.databinding.ListItemLyricBinding

class MusicLyricListAdapter : BaseListAdapter<LyricLine, MusicLyricListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ListItemLyricBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(lyricLine: LyricLine) {
            binding.data = lyricLine
            binding.executePendingBindings()
            if (lyricLine._isPlaying) {
                binding.tvLyric.setTextColor(binding.tvLyric.resources.getColor(R.color.colorWhite))
            } else {
                binding.tvLyric.setTextColor(binding.tvLyric.resources.getColor(R.color.colorWhite50))
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemLyricBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(getItem(position))
    }

}