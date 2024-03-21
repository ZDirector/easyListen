package com.example.common.utils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<T, VH : RecyclerView.ViewHolder> :
    ListAdapter<T, VH>(DiffCallback<T>()) {

    var onItemClick: ((t: T) -> Unit)? = null

    override fun submitList(list: List<T>?) {
        this.submitList(list, null)
    }

    override fun submitList(list: List<T>?, commitCallback: Runnable?) {
        super.submitList(list?.toMutableList(), commitCallback)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        if (onItemClick != null) {
            holder.itemView.setOnSingleClickListener {
                if (position in 0 until currentList.size) {
                    onItemClick?.invoke(currentList[position])
                }
            }
        }
    }

    fun submitListOrigin(list: List<T>?) {
        super.submitList(list)
    }

    class DiffCallback<T> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem === newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }
    }
}