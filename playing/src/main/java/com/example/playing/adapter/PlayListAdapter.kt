package com.example.playing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.common.bean.searchBean.MusicBean
import com.example.common.utils.BaseListAdapter
import com.example.common.utils.MyApplication
import com.example.playing.databinding.ListItemPlayMusicBinding
import com.example.playing.viewModel.PlayViewModel

class PlayListAdapter(private val onClickCallback : OnItemClickListener) : BaseListAdapter<MusicBean, PlayListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ListItemPlayMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val viewModel = MyApplication.getAppViewModel(PlayViewModel::class.java)

        init {
            binding.root.setOnClickListener {
                binding.item?.let {
                    onClickCallback.onItemClick(it)
                }
            }
            binding.ivRemove.setOnClickListener {
                onClickCallback.removeMusic(bindingAdapterPosition)
            }
        }

        fun bind(item: MusicBean) {
            binding.item = item
            binding.isPlaying = viewModel.currentMusic.value?.id == item.id
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemPlayMusicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface OnItemClickListener {
        fun onItemClick(musicBean: MusicBean)

        fun removeMusic(position: Int)
    }

}