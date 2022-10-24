package com.example.search.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.baseui.BaseFragment
import com.example.common.utils.showToast
import com.example.search.BR
import com.example.search.R
import com.example.search.adapter.MusicVideoListAdapter
import com.example.search.databinding.FragmentMusicViedoBinding
import com.example.search.viewmodel.SearchViewModel
import com.example.search.viewmodel.fragment.MusicVideoViewModel

class MusicVideoFragment : BaseFragment<FragmentMusicViedoBinding,MusicVideoViewModel>() {

    override val layoutId = R.layout.fragment_music_viedo
    override val variableId = BR.musicVideoViewModel
    private lateinit var activityModel : SearchViewModel

    override fun initData(savedInstanceState: Bundle?) {
        activityModel = ViewModelProvider(requireActivity())[SearchViewModel::class.java]
        initView()
        initListener()
        initObserve()
    }

    private fun initView(){
        binding.musicVideoList.layoutManager = LinearLayoutManager(requireActivity())
        binding.musicVideoList.itemAnimator = null//设置list删除或增加动画，避免bug
        binding.musicVideoListRefresh.setEnableRefresh(false)
    }

    private fun initListener(){
        //监听滑动到底部后加载更多
        binding.musicVideoListRefresh.setOnLoadMoreListener {
            viewModel.offset++
            viewModel.getSearchMusicVideoList(activityModel.keyWords.value.toString())
        }
    }

    private fun initObserve(){
        //监听外部的输入框内的消息
        activityModel.keyWords.observe(this){
            viewModel.offset = 0
            activityModel.isSearchResultFinishLoading(false)
            viewModel.getSearchMusicVideoList(it)
        }

        viewModel.mSearchMusicVideoList.observe(this){
            if (it.isNullOrEmpty()){
                showToast("没有更多数据啦!")
                binding.musicVideoListRefresh.finishLoadMore()
                viewModel.offset--
            }else{
                val adapter : MusicVideoListAdapter
                if (binding.musicVideoList.adapter == null){
                    adapter = MusicVideoListAdapter(it.toMutableList())
                    adapter.setItemOnClickListener(object : MusicVideoListAdapter.ItemOnClickListener{
                        override fun onClick(view: View, i: Int) {

                        }
                    })
                    binding.musicVideoList.adapter = adapter
                }else{
                    adapter = binding.musicVideoList.adapter as MusicVideoListAdapter
                    adapter.musicVideoList = it.toMutableList()
                    adapter.notifyItemRangeInserted(viewModel.offset * 20,20)
                    binding.musicVideoListRefresh.finishLoadMore()
                }
                activityModel.isSearchResultFinishLoading(true)
            }
        }
    }

}