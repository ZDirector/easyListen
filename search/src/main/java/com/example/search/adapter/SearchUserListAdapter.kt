package com.example.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.common.bean.searchbean.Userprofile
import com.example.search.R

class SearchUserListAdapter(var userList: MutableList<Userprofile>) : RecyclerView.Adapter<SearchUserListAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val itemSearchUserPic : ImageView = view.findViewById(R.id.item_search_user_pic)
        val itemSearchUserName : TextView = view.findViewById(R.id.item_search_user_name)
        val itemSearchUserSex : ImageView = view.findViewById(R.id.item_search_user_sex)
        val itemSearchUserSign : TextView = view.findViewById(R.id.item_search_user_sign)
        val itemSearchUserFollowButton : ConstraintLayout = view.findViewById(R.id.item_search_user_follow_button)
        val itemSearchUserFollowIcon : ImageView = view.findViewById(R.id.item_search_user_follow_ic)
        val itemSearchUserFollowText : TextView = view.findViewById(R.id.item_search_user_follow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_user,parent,false)
        val viewHolder = ViewHolder(view)
        view.setOnClickListener{
            if (it != null) mItemOnClickListener.onClick(it, it.tag as Int)
        }
        viewHolder.itemSearchUserFollowButton.setOnClickListener{
            if (it != null) mItemOnClickListener.onClick(it, it.tag as Int)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tag = position
        holder.itemSearchUserFollowButton.tag = position

        Glide.with(holder.itemSearchUserPic)
            .load(userList[position].avatarUrl)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(holder.itemSearchUserPic)

        holder.itemSearchUserName.text = userList[position].nickname
        when(userList[position].gender){
            1 ->{
                holder.itemSearchUserSex.setImageResource(R.drawable.ic_user_man)
            }
            2 ->{
                holder.itemSearchUserSex.setImageResource(R.drawable.ic_user_woman)
            }
            else ->{
                holder.itemSearchUserSex.visibility = View.GONE
            }
        }

        holder.itemSearchUserSign.text = userList[position].signature
    }

    override fun getItemCount() = userList.size

    private lateinit var mItemOnClickListener : ItemOnClickListener

    fun setItemOnClickListener(mItemOnClickListener : ItemOnClickListener) {
        this.mItemOnClickListener = mItemOnClickListener
    }

    companion object interface ItemOnClickListener {
        fun onClick(view : View, i : Int)
    }

}