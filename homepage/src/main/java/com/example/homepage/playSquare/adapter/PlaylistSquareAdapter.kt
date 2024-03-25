package com.example.homepage.playSquare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.common.bean.home.Playlist
import com.example.common.utils.BaseListAdapter
import com.example.homepage.databinding.ItemSquareListBinding

class PlaylistSquareAdapter : BaseListAdapter<Playlist, PlaylistSquareAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemSquareListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Playlist) {
            //Glide设置图片圆角角度
            val roundedCorners = RoundedCorners(20)
            //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
            val options = RequestOptions.bitmapTransform(roundedCorners)
            Glide.with(binding.ivPlaylistDetail.context)
                .load(item.coverImgUrl) //.placeholder(R.drawable.ic_default_image)
                .apply(options)
                .into(binding.ivPlaylistDetail)
            binding.tvPlaylistDetail.text = item.name
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSquareListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}