package com.example.homepage.toplist.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.common.utils.UiUtils
import com.example.homepage.R
import com.example.homepage.toplist.bean.TopDetail

class TopOtherAdapter : BaseQuickAdapter<TopDetail, BaseViewHolder>(R.layout.item_top_other) {
    override fun convert(helper: BaseViewHolder?, item: TopDetail?) {
        helper?.apply {
            itemView.apply {
                item?.apply {
                    println("adapter 这是事实￥￥$item")
                    UiUtils.setPic(findViewById(R.id.iv_top_playlist),10,coverImgUrl)
                }
            }
        }
    }
}