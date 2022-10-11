package com.example.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.search.R

class SearchSuggestListAdapter(private val searchSuggestList : List<String>) : RecyclerView.Adapter<SearchSuggestListAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val itemSearchSuggestText : TextView = view.findViewById(R.id.item_search_suggest_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_suggest, parent, false)
        view.setOnClickListener { v ->
            if (v != null) {
                mItemOnClickListener.onClick(v, v.tag as Int)
            }
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemSearchSuggestText.text = searchSuggestList[position]
        holder.itemView.tag = position
    }

    override fun getItemCount() = searchSuggestList.size

    private lateinit var mItemOnClickListener : ItemOnClickListener

    fun setItemOnClickListener(mItemOnClickListener : ItemOnClickListener) {
        this.mItemOnClickListener = mItemOnClickListener
    }

    companion object interface ItemOnClickListener {
        fun onClick(view : View, i : Int)
    }

}