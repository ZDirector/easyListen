package com.example.homepage.playSquare.adapter

import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.common.adapter.DataClickListener
import com.example.homepage.R
import com.example.homepage.playSquare.bean.Playlist

class PlaylistSquareAdapter: BaseQuickAdapter<Playlist,BaseViewHolder>(R.layout.item_square_list) {
    var itemClickListener: DataClickListener<Playlist>? = null

    override fun convert(helper: BaseViewHolder, item: Playlist) {
        helper.apply {
/*            itemView.setOnClickListener {
                    itemClickListener?.onClick(item,data.indexOf(item))

            }*/
            itemView.findViewById<LinearLayout>(R.id.ll_playlist_item).setOnClickListener {
                itemClickListener?.onClick(item,data.indexOf(item))

            }


            val imageView = getView<ImageView>(R.id.iv_playlist_detail)
                //Glide设置图片圆角角度
                val roundedCorners = RoundedCorners(20)
                //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
                val options = RequestOptions.bitmapTransform(roundedCorners)
                Glide.with(imageView.context)
                    .load(item.coverImgUrl) //.placeholder(R.drawable.ic_default_image)
                    .apply(options)
                    .into(imageView)
            helper.getView<TextView>(R.id.tv_playlist_detail).text = item.name

        }



    }
}