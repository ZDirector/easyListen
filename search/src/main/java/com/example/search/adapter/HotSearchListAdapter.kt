package com.example.search.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.search.R

class HotSearchListAdapter(private val hotSearchList : List<String>) : RecyclerView.Adapter<HotSearchListAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val itemHotSearchRank : TextView = view.findViewById(R.id.item_hot_rank)
        val itemHotSearchName : TextView = view.findViewById(R.id.item_hot_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hot_list, parent, false)
        view.setOnClickListener { v ->
            if (v != null) {
                mItemOnClickListener.onClick(v, v.tag as Int)
            }
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemHotSearchRank.text = (1 + position).toString()
        holder.itemHotSearchName.text = hotSearchList[position]
        if(position <= 2){
            holder.itemHotSearchRank.setTextColor(Color.parseColor("#1a67a5"))
            holder.itemHotSearchRank.paint.isFakeBoldText = true
            holder.itemHotSearchName.setTextColor(Color.parseColor("#333333"))
            holder.itemHotSearchName.paint.isFakeBoldText = true
        }
        holder.itemView.tag = position
    }

    override fun getItemCount() = hotSearchList.size

    private lateinit var mItemOnClickListener : ItemOnClickListener

    fun setItemOnClickListener(mItemOnClickListener : ItemOnClickListener) {
        this.mItemOnClickListener = mItemOnClickListener
    }

    companion object interface ItemOnClickListener {
        fun onClick(view : View, i : Int)
    }

}