package com.example.homepage.toplist.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.common.utils.bindImageFromUrlRoundCorner
import com.example.homepage.R
import com.example.homepage.toplist.bean.TopDetail

class OfficialAdapter : BaseQuickAdapter<TopDetail, BaseViewHolder>(R.layout.item_top_official) {

    override fun convert(helper: BaseViewHolder?, item: TopDetail?) {
        helper?.apply {
            item?.apply {
                itemView.apply {
                    findViewById<TextView>(R.id.tv_bang).text = name
                    if (tracks.isNotEmpty()) {
                        if (tracks.size > 2) {
                            bindImageFromUrlRoundCorner(findViewById(R.id.iv_one), coverImgUrl, 8)

                            findViewById<TextView>(R.id.tv_one_song).text = tracks[0].first
                            val tvArtistOne = findViewById<TextView>(R.id.tv_one_singer)
                            tvArtistOne.text = tracks[0].second


                            findViewById<TextView>(R.id.tv_two_name).text = tracks[1].first
                            val tvArtistTwo = findViewById<TextView>(R.id.tv_two_singer)
                            tvArtistTwo.text = tracks[1].second


                            findViewById<TextView>(R.id.tv_three_name).text = tracks[2].first
                            val tvArtistThree = findViewById<TextView>(R.id.tv_three_singer)
                            tvArtistThree.text = tracks[2].second
                        }
                    }
                }

            }
        }
    }
}