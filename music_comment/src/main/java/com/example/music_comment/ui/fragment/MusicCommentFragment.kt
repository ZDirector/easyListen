package com.example.music_comment.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.baseui.BaseFragment
import com.example.common.utils.LogUtil
import com.example.common.utils.showToast
import com.example.music_comment.BR
import com.example.music_comment.R
import com.example.music_comment.adapter.MusicCommentListAdapter
import com.example.music_comment.databinding.FragmentMusicCommentBinding
import com.example.music_comment.viewmodel.MusicCommentViewModel
import com.example.music_comment.viewmodel.fragment.CommentFragmentViewModel


class MusicCommentFragment : BaseFragment<FragmentMusicCommentBinding,CommentFragmentViewModel>() {

    override val layoutId = R.layout.fragment_music_comment
    override val variableId = BR.commentFragmentViewModel
    private lateinit var activityViewModel: MusicCommentViewModel

    override fun initData(savedInstanceState: Bundle?) {
        activityViewModel = ViewModelProvider(requireActivity())[MusicCommentViewModel::class.java]
        viewModel.songId = activityViewModel.songId

        initView()
        initObserve()
        initListener()
    }

    private fun initView(){
        binding.musicCommentList.layoutManager = LinearLayoutManager(requireActivity())
        binding.musicCommentList.itemAnimator = null//设置list删除或增加动画，避免bug

        onLoading()
    }

    private fun initObserve(){
        //监听activity的评论排序
        activityViewModel.sortType.observe(this){
            viewModel.pageNo = 1
            viewModel.sortType = it
            viewModel.getMusicCommentList()
            onLoading()
        }

        activityViewModel.isFinishLoadMore.observe(this){
            if (!it){
                viewModel.pageNo++
                viewModel.getMusicCommentList()
            }
        }

        //获取评论列表
        viewModel.mMusicCommentList.observe(this){
            if (it.isNullOrEmpty()){
                showToast("没有更多数据啦!")
                activityViewModel.isFinishLoadMore.postValue(true)
                viewModel.pageNo--
            }else{
                val adapter : MusicCommentListAdapter
                if (binding.musicCommentList.adapter == null){
                    adapter = MusicCommentListAdapter(it.toMutableList())
                    adapter.setItemOnClickListener(object : MusicCommentListAdapter.ItemOnClickListener{
                        override fun onClick(view: View, i: Int) {

                        }
                    })
                    binding.musicCommentList.adapter = adapter
                }else{
                    adapter = binding.musicCommentList.adapter as MusicCommentListAdapter
                    adapter.musicCommentList = it.toMutableList()
                    adapter.notifyItemRangeInserted((viewModel.pageNo - 1) * 20,20)
                    activityViewModel.isFinishLoadMore.postValue(true)
                }
            }
            finishLoading()
        }
    }

    private fun initListener(){


    }

    private fun onLoading(){
        binding.musicCommentList.visibility = View.GONE
        binding.loadingLayout.visibility = View.VISIBLE
    }

    private fun finishLoading(){
        binding.musicCommentList.visibility = View.VISIBLE
        binding.loadingLayout.visibility = View.GONE
    }
}