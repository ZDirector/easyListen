package com.example.music_comment.adapter

import android.graphics.Color
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.common.bean.musicComment.Comment
import com.example.common.utils.MyApplication
import com.example.music_comment.R

class MusicCommentListAdapter(musicCommentList : MutableList<Comment>,parentCommentId : Long) : RecyclerView.Adapter<MusicCommentListAdapter.ViewHolder>() {

    var musicCommentList : MutableList<Comment>
    private var parentCommentId : Long

    init {
        this.musicCommentList = musicCommentList
        this.parentCommentId = parentCommentId
    }

    constructor(musicCommentList : MutableList<Comment>) : this(musicCommentList,0L)


    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val itemUserCover : ImageView = view.findViewById(R.id.item_user_cover)
        val itemUserName : TextView = view.findViewById(R.id.item_user_name)
        val itemUserVipLevel : ImageView = view.findViewById(R.id.item_user_vip_level)
        val itemUserReleaseDate : TextView = view.findViewById(R.id.item_user_release_date)
        val itemUserLocation : TextView = view.findViewById(R.id.item_user_location)
        val itemIconLike : ImageView = view.findViewById(R.id.item_icon_like)
        val itemLikeCount : TextView = view.findViewById(R.id.item_like_count)
        val itemComment : TextView = view.findViewById(R.id.item_comment)
        val itemCommentReplied : ConstraintLayout = view.findViewById(R.id.item_comment_replied)
        val itemCommentRepliedText : TextView = view.findViewById(R.id.item_comment_replied_text)
        val itemCommentRepliedMore : ConstraintLayout = view.findViewById(R.id.item_comment_replied_more)
        val itemCommentRepliedCount : TextView = view.findViewById(R.id.item_comment_replied_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music_comment,parent,false)
        view.setOnClickListener { v ->
            if (v != null) {
                mItemOnClickListener.onClick(v, v.tag as Int)
            }
        }
        val viewHolder = ViewHolder(view)
        viewHolder.itemUserName.setOnClickListener { v ->
            if (v != null) {
                mItemOnClickListener.onClick(v, v.tag as Int)
            }
        }
        viewHolder.itemIconLike.setOnClickListener { v ->
            if (v != null) {
                if (!musicCommentList[v.tag as Int].liked){
                    musicCommentList[v.tag as Int].liked = true
                    viewHolder.itemIconLike.setImageResource(R.drawable.ic_liked)
                    viewHolder.itemLikeCount.text = (viewHolder.itemLikeCount.text.toString().toInt() + 1).toString()
                    viewHolder.itemLikeCount.setTextColor(Color.parseColor("#1a67a5"))
                    viewHolder.itemIconLike.startAnimation(AnimationUtils.loadAnimation(MyApplication.context,R.anim.anim_like))
                }else{
                    musicCommentList[v.tag as Int].liked = false
                    viewHolder.itemIconLike.setImageResource(R.drawable.ic_like)
                    viewHolder.itemLikeCount.text = (viewHolder.itemLikeCount.text.toString().toInt() - 1).toString()
                    viewHolder.itemLikeCount.setTextColor(Color.parseColor("#757575"))
                }
                mItemOnClickListener.onClick(v, v.tag as Int)
            }
        }
        viewHolder.itemCommentRepliedMore.setOnClickListener{ v ->
            if (v != null) {
                mItemOnClickListener.onClick(v, v.tag as Int)
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tag = position
        holder.itemUserName.tag = position
        holder.itemIconLike.tag = position
        holder.itemCommentRepliedMore.tag = position
        val comment = musicCommentList[position]

        Glide.with(holder.itemUserCover)
            .load(comment.user.avatarUrl)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .override(120,120)
            .into(holder.itemUserCover)

        holder.itemUserName.text = comment.user.nickname
        holder.itemUserName.paint.isFakeBoldText = true
        if (comment.user.vipRights?.associator != null){
            Glide.with(holder.itemUserVipLevel)
                .load(comment.user.vipRights!!.associator!!.iconUrl)
                .into(holder.itemUserVipLevel)
        }
        holder.itemUserReleaseDate.text = comment.timeStr
        holder.itemUserLocation.text = comment.ipLocation.location
        if (comment.liked){
            holder.itemIconLike.setImageResource(R.drawable.ic_liked)
            holder.itemLikeCount.setTextColor(Color.parseColor("#1a67a5"))
        }
        holder.itemLikeCount.text = comment.likedCount.toString()
        holder.itemComment.text = comment.content

        if (!comment.beReplied.isNullOrEmpty()){
            holder.itemCommentReplied.visibility = View.VISIBLE
            if (!comment.beReplied!![0].content.isNullOrEmpty()){
                if (comment.beReplied!![0].beRepliedCommentId == parentCommentId){
                    holder.itemCommentReplied.visibility = View.GONE
                }else{
                    val spanString = SpannableString(comment.beReplied!![0].user.nickname + " :" + comment.beReplied!![0].content)
                    spanString.setSpan(ForegroundColorSpan(Color.parseColor("#1a67a5")),0,spanString.indexOf(":") + 1,0)
                    holder.itemCommentRepliedText.text = spanString
                }
            }else{
                holder.itemCommentRepliedText.text = "该评论已删除"
                holder.itemCommentRepliedText.setTextColor(Color.parseColor("#757575"))
            }
        }

        if (comment.replyCount != 0){
            holder.itemCommentRepliedMore.visibility = View.VISIBLE
            val text = comment.replyCount.toString() + "条回复"
            holder.itemCommentRepliedCount.text = text
        }else holder.itemCommentRepliedMore.visibility = View.GONE
    }

    override fun getItemCount() = musicCommentList.size

    private lateinit var mItemOnClickListener : ItemOnClickListener

    fun setItemOnClickListener(mItemOnClickListener : ItemOnClickListener) {
        this.mItemOnClickListener = mItemOnClickListener
    }

    companion object interface ItemOnClickListener {
        fun onClick(view : View, i : Int)
    }

}