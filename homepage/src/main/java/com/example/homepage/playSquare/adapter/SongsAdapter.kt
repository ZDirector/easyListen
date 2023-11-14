package com.example.homepage.playSquare.adapter

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.search.R

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.common.adapter.DataClickListener
import com.example.common.bean.searchBean.Song


class SongsAdapter : BaseQuickAdapter<Song, BaseViewHolder>(R.layout.item_search_music_list) {
    var itemClickListener: DataClickListener<Song>? = null

    override fun convert(helper: BaseViewHolder?, item: Song?) {

        helper?.apply {
            val itemSearchMusicName: TextView = getView(R.id.item_search_music_name)!!
            val itemSearchMusicTns = getView<TextView>((R.id.item_search_music_tns))

            val itemSearchMusicLabelVIP = getView<TextView>(R.id.item_search_music_label_vip)
            val itemSearchMusicLabelAudition: TextView =
                getView(R.id.item_search_music_label_audition)!!
            val itemSearchMusicLabelOriginal: TextView =
                getView(R.id.item_search_music_label_original)!!

            val itemSearchMusicLabelSQ: TextView = getView(R.id.item_search_music_label_sq)!!
            val itemSearchMusicSinger: TextView = getView(R.id.item_search_music_singer)!!
            val itemSearchMusicAl: TextView = getView(R.id.item_search_music_al)!!

            val itemSearchMusicAlia: TextView = getView(R.id.item_search_music_alia)!!
            val itemSearchMusicSetting: ImageView = getView(R.id.item_search_music_setting)!!



            if (item != null) {
                itemSearchMusicName.text = item.name

                if (item.tns?.isNotEmpty() == true) itemSearchMusicTns.text = "( ${item?.tns?.get(0)} )"
                if (item.privilege?.fee != 0) itemSearchMusicLabelVIP.visibility = View.VISIBLE
                if (item.privilege?.freeTrialPrivilege?.resConsumable == true) itemSearchMusicLabelAudition.visibility =
                    View.VISIBLE
                if (item.originCoverType == 1) itemSearchMusicLabelOriginal.visibility =
                    View.VISIBLE
                if (item.sq != null) itemSearchMusicLabelSQ.visibility = View.VISIBLE
                val singer: StringBuilder = StringBuilder()
                for (i in 0 until item.ar.size) {
                    if (i == 0) singer.append(item.ar[i].name)
                    else singer.append("/" + item.ar[i].name)
                }
                itemSearchMusicSinger.text = singer
                itemSearchMusicAl.text = item.al.name
                if (item.alia.isNotEmpty()) {
                    itemSearchMusicAlia.text = item.alia!![0]
                    itemSearchMusicAlia.visibility = View.VISIBLE
                }

                if (item?.privilege?.st != null) {
                    if (item?.privilege?.st!! < 0) {
                        itemSearchMusicName.setTextColor(Color.parseColor("#d2d2d2"))
                        itemSearchMusicTns.setTextColor(Color.parseColor("#d2d2d2"))
                        itemSearchMusicSinger.setTextColor(Color.parseColor("#d2d2d2"))
                        itemSearchMusicAl.setTextColor(Color.parseColor("#d2d2d2"))
                        itemSearchMusicAlia.setTextColor(Color.parseColor("#d2d2d2"))
                    }
                }
            }

        }


    }

}