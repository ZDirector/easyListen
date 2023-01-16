package com.example.music_comment.ui

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.common.baseui.BaseActivity
import com.example.common.utils.setStatusBarColor
import com.example.common.utils.setStatusBarTextColor
import com.example.music_comment.BR
import com.example.music_comment.R
import com.example.music_comment.databinding.ActivityMusicCommentBinding
import com.example.music_comment.ui.fragment.MusicCommentFragment
import com.example.music_comment.viewmodel.MusicCommentViewModel
import com.scwang.smart.refresh.layout.api.RefreshFooter
import com.scwang.smart.refresh.layout.simple.SimpleMultiListener

class MusicCommentActivity : BaseActivity<ActivityMusicCommentBinding,MusicCommentViewModel>() {
    override val activity: Activity
        get() =  this
    override val layoutId = R.layout.activity_music_comment
    override val variableId = BR.musicCommentViewModel

    override fun initData(savedInstanceState: Bundle?) {
        viewModel.songId = intent.getIntExtra("SongId",0)
        viewModel.getMusicCommentCount(viewModel.songId,1)
        initView()
        initObserve()
        initListener()
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

        val musicCommentFragment = MusicCommentFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.music_comment_frag_container,musicCommentFragment).commitAllowingStateLoss()
    }

    private fun initObserve(){
        viewModel.mMusicCommentCount.observe(this){
            val count = "($it)"
            binding.musicCommentCount.text = count
        }

        viewModel.isFinishLoadMore.observe(this){
            if (it) binding.musicCommentListRefresh.finishLoadMore()
        }
    }

    private fun initListener(){
        binding.musicCommentBack.setOnClickListener{
            finish()
        }
        binding.hottestComment.setOnClickListener {
            if (viewModel.sortType.value!! != 2){
                viewModel.sortType.postValue(2)
                binding.hottestComment.setTextColor(Color.parseColor("#333333"))
                binding.newestComment.setTextColor(Color.parseColor("#757575"))
                binding.hottestComment.paint.isFakeBoldText = true
                binding.newestComment.paint.isFakeBoldText = false
            }
        }
        binding.newestComment.setOnClickListener {
            if (viewModel.sortType.value!! != 3){
                viewModel.sortType.postValue(3)
                binding.hottestComment.setTextColor(Color.parseColor("#757575"))
                binding.newestComment.setTextColor(Color.parseColor("#333333"))
                binding.hottestComment.paint.isFakeBoldText = false
                binding.newestComment.paint.isFakeBoldText = true
            }
        }

        //监听滑动到底部后加载更多
        binding.musicCommentListRefresh.setOnLoadMoreListener {
            viewModel.isFinishLoadMore.postValue(false)
        }

        binding.musicCommentListRefresh.setOnMultiListener(object : SimpleMultiListener() {
            override fun onFooterMoving(
                footer: RefreshFooter,
                isDragging: Boolean,
                percent: Float,
                offset: Int,
                footerHeight: Int,
                maxDragHeight: Int
            ) {
                // 上拉加载时，保证吸顶头部不被推出屏幕。
                binding.musicCommentFragContainer.stickyOffset = offset
            }
        })
    }
}