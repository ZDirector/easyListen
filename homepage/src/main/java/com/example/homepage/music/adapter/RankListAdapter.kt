package com.example.homepage.music.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homepage.R
import com.example.homepage.databinding.ItemListRankingBinding
import com.example.homepage.music.bean.Rank

class RankListAdapter(val list:List<Rank>): RecyclerView.Adapter<RankListAdapter.RankViewHolder>() {
    inner class RankViewHolder(view:View): RecyclerView.ViewHolder(view) {
        var mBinding:ItemListRankingBinding
        init {
            mBinding = DataBindingUtil.bind(view)!!

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankViewHolder {
        val view = View.inflate(parent.context, R.layout.item_list_ranking,null)
        return RankViewHolder(view)
    }

    override fun onBindViewHolder(holder: RankViewHolder, position: Int) {
        holder.mBinding.apply {

            if (list.size>2){

                list[position].apply {
                    if (tracks.size>2){

                        tvRankTitle.text = name
                        tvList1Top1.text = tracks[0].first
                        tvList1Top2.text = tracks[0].second
                        tvList2Top1.text = tracks[1].first
                        tvList2Top2.text = tracks[1].second
                        tvList3Top1.text = tracks[2].first
                        tvList3Top2.text = tracks[2].second
                    }

                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}