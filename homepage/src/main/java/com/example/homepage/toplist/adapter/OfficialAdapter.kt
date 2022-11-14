package com.example.homepage.toplist.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.common.utils.UiUtils
import com.example.homepage.R
import com.example.homepage.toplist.bean.TopDetail

class OfficialAdapter : BaseQuickAdapter<TopDetail, BaseViewHolder>(R.layout.item_top_official) {


    override fun convert(helper: BaseViewHolder?, item: TopDetail?) {
        helper?.apply {
            item?.apply {
                itemView.apply {
                    findViewById<TextView>(R.id.tv_bang).text = name
                    println("topdatail %${item.songs}")
                    if (songs.isNotEmpty()) {
                        if (songs.size > 2) {
                            println("size 大小是 ${songs[2].ar[0].name}  ${songs[1].ar[0].name}  \n $songs  " )

                            songs[0].al.apply {
                                UiUtils.setPic(findViewById(R.id.iv_one), 10, picUrl)
                            }
                            songs[1].al.apply {
                                UiUtils.setPic(
                                    findViewById(R.id.iv_two_pic),
                                    10,
                                    picUrl
                                )
                            }
                            songs[2].al.apply {
                                UiUtils.setPic(
                                    findViewById(R.id.iv_three),
                                    10,
                                    picUrl
                                )
                            }

                            findViewById<TextView>(R.id.tv_one_song).text = songs[0].name
                            val tvArtistOne = findViewById<TextView>(R.id.tv_one_singer)
                            val stringOne = StringBuffer()
                            songs[0].apply {
                                songs[0].ar.apply {
                                    for (i in 0 until size) {
                                        stringOne.append(get(i).name)
                                        if (i < size - 1) stringOne.append(",")

                                    }
                                }

                            }
                            tvArtistOne.text = stringOne


                            findViewById<TextView>(R.id.tv_two_name).text = songs[1].name
                            val tvArtistTwo = findViewById<TextView>(R.id.tv_two_singer)
                            val stringTwo = StringBuffer()
                            songs[1].apply {
                                ar.apply {
                                    for (i in ar.indices) {
                                        stringTwo.append(get(i).name)
                                        if (i < size - 1) stringTwo.append(",")

                                    }
                                }

                            }
                            println("大小是$stringTwo")
                            tvArtistTwo.text = stringTwo


                            findViewById<TextView>(R.id.tv_three_name).text = songs[2].name
                            val tvArtistThree = findViewById<TextView>(R.id.tv_three_singer)
                            val stringThree = StringBuffer()
                            songs[2].apply {
                                ar.apply {
                                    for (i in ar.indices) {
                                        stringThree.append(get(i).name)
                                        if (i < size - 1) stringThree.append(",")

                                    }
                                }

                            }
                            tvArtistThree.text = stringThree
                            println("大小是$stringThree")

                        }
                    }
                }

            }
        }
    }
}