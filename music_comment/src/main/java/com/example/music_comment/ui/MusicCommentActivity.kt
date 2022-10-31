package com.example.music_comment.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.common.baseui.BaseActivity
import com.example.common.utils.LogUtil
import com.example.common.utils.setStatusBarColor
import com.example.common.utils.setStatusBarTextColor
import com.example.common.utils.showToast
import com.example.music_comment.BR
import com.example.music_comment.R
import com.example.music_comment.adapter.MusicCommentListAdapter
import com.example.music_comment.databinding.ActivityMusicCommentBinding
import com.example.music_comment.util.FloorCommentPopupWindow
import com.example.music_comment.viewmodel.MusicCommentViewModel
class MusicCommentActivity : BaseActivity<ActivityMusicCommentBinding,MusicCommentViewModel>() {

    override val layoutId = R.layout.activity_music_comment
    override val variableId = BR.musicCommentViewModel

    private var currentFloorCommentPopupWindow : FloorCommentPopupWindow? = null

    override fun initData(savedInstanceState: Bundle?) {
        viewModel.songId = intent.getLongExtra("SongId",0)
        initView()
        initObserve()
        initListener()
        viewModel.getMusicCommentList()
    }

    private fun initView(){
        setStatusBarTextColor(true)
        setStatusBarColor(Color.WHITE)

        Glide.with(binding.musicCommentAlbum)
            .load(intent.getStringExtra("SongCover"))
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .override(128,128)
            .into(binding.musicCommentAlbum)

        binding.musicName.text = intent.getStringExtra("SongName")
        binding.musicSingerName.text = "- " + intent.getStringExtra("Singer")

        binding.musicCommentListRefresh.setEnableRefresh(false)
        binding.musicCommentList.layoutManager = LinearLayoutManager(this)
        binding.musicCommentList.itemAnimator = null//设置list删除或增加动画，避免bug
    }

    private fun initObserve(){
        viewModel.mMusicCommentCount.observe(this){
            val count = "($it)"
            binding.musicCommentCount.text = count
        }

        viewModel.mMusicCommentList.observe(this){
            if (it.isNullOrEmpty()){
                showToast("没有更多数据啦!")
                finishLoading()
                if (viewModel.pageNo > 1) viewModel.pageNo--
                if (binding.musicCommentListRefresh.isLoading) binding.musicCommentListRefresh.finishLoadMore()
            }else{
                val adapter : MusicCommentListAdapter
                if (binding.musicCommentList.adapter == null){
                    adapter = MusicCommentListAdapter(it.toMutableList())
                    adapter.setItemOnClickListener(object : MusicCommentListAdapter.ItemOnClickListener{
                        override fun onClick(view: View, i: Int) {
                            when(view.id){
                                R.id.item_icon_like ->{

                                }
                                R.id.item_comment_replied_more ->{
                                    currentFloorCommentPopupWindow = FloorCommentPopupWindow(view)
                                    currentFloorCommentPopupWindow!!.parentCommentId = adapter.musicCommentList[i].commentId
                                    currentFloorCommentPopupWindow!!.mWindow = window
                                    viewModel.getFloorCommentList(currentFloorCommentPopupWindow!!.parentCommentId)

                                    currentFloorCommentPopupWindow!!.floorCommentListRefresh.setOnLoadMoreListener {
                                        viewModel.getFloorCommentList(currentFloorCommentPopupWindow!!.parentCommentId)
                                    }

                                    currentFloorCommentPopupWindow!!.mPopupWindow.setOnDismissListener {
                                        val lp: WindowManager.LayoutParams = window.attributes
                                        lp.alpha = 1f
                                        window.attributes = lp
                                        currentFloorCommentPopupWindow = null
                                        viewModel.floorTime = 0
                                    }
                                }
                            }
                        }
                    })
                    binding.musicCommentList.adapter = adapter
                }else{
                    adapter = binding.musicCommentList.adapter as MusicCommentListAdapter
                    adapter.musicCommentList = it.toMutableList()
                    adapter.notifyDataSetChanged()
//                    adapter.notifyItemRangeInserted((viewModel.pageNo - 1) * 20,20)
                    if (binding.musicCommentListRefresh.isLoading) binding.musicCommentListRefresh.finishLoadMore()
                }
            }
            finishLoading()
        }

        viewModel.mCurrentFloorCommentList.observe(this){
            if (currentFloorCommentPopupWindow != null){
                if (it != null){
                    if (currentFloorCommentPopupWindow!!.ownerComment == null){
                        currentFloorCommentPopupWindow!!.ownerComment = it.ownerComment
                        currentFloorCommentPopupWindow!!.initView()
                        currentFloorCommentPopupWindow!!.setBackground()
                        currentFloorCommentPopupWindow!!.loadFloorComment(it.comments)
                        currentFloorCommentPopupWindow!!.show()
                    }else currentFloorCommentPopupWindow!!.loadFloorComment(it.comments)
                }else{
                    showToast("没有更多数据啦!")
                }
                currentFloorCommentPopupWindow!!.floorCommentListRefresh.finishLoadMore()
            }
        }
    }

    private fun initListener(){
        binding.musicCommentBack.setOnClickListener{
            finish()
        }

        binding.hottestComment.setOnClickListener {
            if (viewModel.sortType != 2){
                viewModel.pageNo = 1
                viewModel.sortType = 2
                viewModel.getMusicCommentList()

                binding.hottestComment.setTextColor(Color.parseColor("#333333"))
                binding.newestComment.setTextColor(Color.parseColor("#757575"))
                binding.hottestComment.paint.isFakeBoldText = true
                binding.newestComment.paint.isFakeBoldText = false

                showLoading()
            }
        }

        binding.newestComment.setOnClickListener {
            if (viewModel.sortType != 3){
                viewModel.pageNo = 1
                viewModel.sortType = 3
                viewModel.commentTime = 0
                viewModel.getMusicCommentList()

                binding.hottestComment.setTextColor(Color.parseColor("#757575"))
                binding.newestComment.setTextColor(Color.parseColor("#333333"))
                binding.hottestComment.paint.isFakeBoldText = false
                binding.newestComment.paint.isFakeBoldText = true

                showLoading()
            }
        }

        //监听滑动到底部后加载更多
        binding.musicCommentListRefresh.setOnLoadMoreListener {
            viewModel.pageNo++
            viewModel.getMusicCommentList()
        }
    }

    private fun showLoading(){
        binding.musicCommentListRefresh.visibility = View.GONE
        binding.loadingLayout.visibility = View.VISIBLE
    }

    private fun finishLoading(){
        binding.musicCommentListRefresh.visibility = View.VISIBLE
        binding.loadingLayout.visibility = View.GONE
    }

}