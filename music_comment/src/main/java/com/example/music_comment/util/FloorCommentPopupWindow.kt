package com.example.music_comment.util

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.*
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.PopupWindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.common.bean.musicComment.Comment
import com.example.common.utils.LogUtil
import com.example.common.utils.MyApplication
import com.example.common.utils.windowsHeight
import com.example.music_comment.R.*
import com.example.music_comment.adapter.MusicCommentListAdapter
import com.scwang.smart.refresh.layout.SmartRefreshLayout

class FloorCommentPopupWindow(touchView: View){

    private val mTouchView = touchView
    var ownerComment : Comment? = null
    var mWindow : Window? = null
    var parentCommentId : Long = 0

    private val musicCommentBack : ImageView
    private val replyCommentCount : TextView
    private val ownerCommentUserCover : ImageView
    private val ownerCommentUserName : TextView
    private val ownerCommentUserVipLevel : ImageView
    private val ownerCommentUserReleaseDate : TextView
    private val ownerCommentUserLocation : TextView
    private val ownerCommentIconLike : ImageView
    private val ownerCommentLikeCount : TextView
    private val ownerCommentContent : TextView
    private val ownerCommentContentReplied : ConstraintLayout
    private val ownerCommentContentRepliedContent : TextView
    private val floorCommentList : RecyclerView
    val floorCommentListRefresh : SmartRefreshLayout
    private val mContentView : View = LayoutInflater.from(MyApplication.context).inflate(layout.popupwindow_floow_comment,null,false)
    val mPopupWindow: PopupWindow

    init {
        musicCommentBack = mContentView.findViewById(id.music_comment_back)
        replyCommentCount = mContentView.findViewById(id.reply_comment_count)
        ownerCommentUserCover = mContentView.findViewById(id.ownerComment_user_cover)
        ownerCommentUserName = mContentView.findViewById(id.ownerComment_user_name)
        ownerCommentUserVipLevel = mContentView.findViewById(id.ownerComment_user_vip_level)
        ownerCommentUserReleaseDate = mContentView.findViewById(id.ownerComment_user_release_date)
        ownerCommentUserLocation = mContentView.findViewById(id.ownerComment_user_location)
        ownerCommentIconLike = mContentView.findViewById(id.ownerComment_icon_like)
        ownerCommentLikeCount = mContentView.findViewById(id.ownerComment_like_count)
        ownerCommentContent = mContentView.findViewById(id.ownerComment_content)
        ownerCommentContentReplied = mContentView.findViewById(id.ownerComment_content_replied)
        ownerCommentContentRepliedContent = mContentView.findViewById(id.ownerComment_content_replied_content)
        floorCommentList = mContentView.findViewById(id.floor_comment_list)
        floorCommentListRefresh = mContentView.findViewById(id.floor_comment_list_refresh)

        floorCommentList.layoutManager = LinearLayoutManager(MyApplication.context)
        floorCommentList.itemAnimator = null
        floorCommentListRefresh.setEnableRefresh(false)

        mPopupWindow = PopupWindow(mContentView,
            ViewGroup.LayoutParams.MATCH_PARENT,
            (MyApplication.context.windowsHeight * 0.9).toInt(), true)
        mPopupWindow.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED
        mPopupWindow.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        mPopupWindow.animationStyle = style.popupwindow_anim
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.setBackgroundDrawable(ColorDrawable(0x00000000))

        initListener()
    }

    private fun initListener(){
        musicCommentBack.setOnClickListener {
            mPopupWindow.dismiss()
        }

        ownerCommentIconLike.setOnClickListener {
            if (ownerComment != null){
                if (!ownerComment!!.liked){
                    ownerComment!!.liked = true
                    ownerCommentIconLike.setImageResource(drawable.ic_liked)
                    ownerCommentLikeCount.text = (ownerCommentLikeCount.text.toString().toInt() + 1).toString()
                    ownerCommentLikeCount.setTextColor(Color.parseColor("#1a67a5"))
                    ownerCommentIconLike.startAnimation(AnimationUtils.loadAnimation(MyApplication.context, anim.anim_like))
                }else{
                    ownerComment!!.liked = false
                    ownerCommentIconLike.setImageResource(drawable.ic_like)
                    ownerCommentLikeCount.text = (ownerCommentLikeCount.text.toString().toInt() - 1).toString()
                    ownerCommentLikeCount.setTextColor(Color.parseColor("#757575"))
                }
            }
        }
    }

    fun initView(){
        if (ownerComment != null){
            Glide.with(ownerCommentUserCover)
                .load(ownerComment!!.user.avatarUrl)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .override(120,120)
                .into(ownerCommentUserCover)

            ownerCommentUserName.text = ownerComment!!.user.nickname
            ownerCommentUserName.paint.isFakeBoldText = true
            if (ownerComment!!.user.vipRights?.associator != null){
                Glide.with(ownerCommentUserVipLevel)
                    .load(ownerComment!!.user.vipRights!!.associator!!.iconUrl)
                    .into(ownerCommentUserVipLevel)
            }
            ownerCommentUserReleaseDate.text = ownerComment!!.timeStr
            ownerCommentUserLocation.text = ownerComment!!.ipLocation.location
            if (ownerComment!!.liked) ownerCommentIconLike.setImageResource(drawable.ic_liked)
            ownerCommentLikeCount.text = ownerComment!!.likedCount.toString()
            ownerCommentContent.text = ownerComment!!.content

            if (!ownerComment!!.beReplied.isNullOrEmpty()){
                ownerCommentContentReplied.visibility = View.VISIBLE
                if (!ownerComment!!.beReplied!![0].content.isNullOrEmpty()){
                    val spanString = SpannableString(ownerComment!!.beReplied!![0].user.nickname + " :" + ownerComment!!.beReplied!![0].content)
                    spanString.setSpan(ForegroundColorSpan(Color.parseColor("#1a67a5")),0,spanString.indexOf(":") + 1,0)
                    ownerCommentContentRepliedContent.text = spanString
                }else{
                    ownerCommentContentRepliedContent.text = "该评论已删除"
                    ownerCommentContentRepliedContent.setTextColor(Color.parseColor("#757575"))
                }
            }
        }
    }

    fun loadFloorComment(commentList : List<Comment>){
        if (floorCommentList.adapter == null){
            val adapter = MusicCommentListAdapter(commentList.toMutableList(),parentCommentId)
                floorCommentList.adapter = adapter
            adapter.setItemOnClickListener(object : MusicCommentListAdapter.ItemOnClickListener{
                override fun onClick(view: View, i: Int) {

                }
            })
        }else{
            val adapter = floorCommentList.adapter as MusicCommentListAdapter
            adapter.musicCommentList.addAll(commentList)
            adapter.notifyItemRangeInserted(adapter.musicCommentList.size - commentList.size,commentList.size)
        }
    }

    fun show(){
        mContentView.measure(makeDropDownMeasureSpec(mPopupWindow.width),
            makeDropDownMeasureSpec(mPopupWindow.height))
        //计算弹出的高度
        val location = IntArray(2)
        mTouchView.getLocationInWindow(location)
        val offsetY = (MyApplication.context.windowsHeight - location[1] - mContentView.measuredHeight) + 58//不加底部会漏空
        LogUtil.d("FloorCommentPopupWindow",MyApplication.context.windowsHeight.toString())
        LogUtil.d("FloorCommentPopupWindow",location[1].toString())
        LogUtil.d("FloorCommentPopupWindow",mContentView.measuredHeight.toString())
        PopupWindowCompat.showAsDropDown(mPopupWindow, mTouchView, 0, offsetY, Gravity.START)
    }

    //设置弹窗显示时，其余空白处的背景
    fun setBackground(){
        if (mWindow != null){
            val lp: WindowManager.LayoutParams = mWindow!!.attributes
            lp.alpha = 0.5f
            mWindow!!.attributes = lp
        }
    }

    //计算contentView的宽高
    private fun makeDropDownMeasureSpec(measureSpec: Int): Int {
        val mode: Int = if (measureSpec == ViewGroup.LayoutParams.WRAP_CONTENT) {
            View.MeasureSpec.UNSPECIFIED
        } else {
            View.MeasureSpec.EXACTLY
        }
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec), mode)
    }

}