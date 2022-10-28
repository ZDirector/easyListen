package com.example.homepage.playSquare.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.homepage.R
import com.example.homepage.playSquare.bean.Playlist


class HighQualityAdapter : PagingDataAdapter<Playlist, HighQualityAdapter.ViewHolder>(COMPARATOR) {
    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Playlist>() {
            override fun areItemsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
                return oldItem == newItem
            }

        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
/*        val video = getItem(position)
        if (video!=null&& video.cover.isNotBlank()){
            Glide.with(holder.itemView.context).load(video.cover).override(200,500).into(holder.ivMineVideo)
        }*/

        val playlist = getItem(position)
        if (playlist!=null){
            //Glide设置图片圆角角度
            //Glide设置图片圆角角度
            val roundedCorners = RoundedCorners(20)
            //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
            // RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(20, 20);
            //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
            // RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(20, 20);
            val options = RequestOptions.bitmapTransform(roundedCorners)
            Glide.with(holder.imageView.context)
                .load(playlist.coverImgUrl) //.placeholder(R.drawable.ic_default_image)
                .apply(options)
                .into(holder.imageView)


            holder.textView.text = playlist.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_square_list , parent, false)
        return ViewHolder(view)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.iv_playlist_detail)
        var textView :TextView = itemView.findViewById(R.id.tv_playlist_detail)
    }


}