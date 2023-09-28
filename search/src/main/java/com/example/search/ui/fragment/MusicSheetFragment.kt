package com.example.search.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.baseui.BaseFragment
import com.example.common.utils.showToast
import com.example.search.BR
import com.example.search.R.*
import com.example.search.adapter.MusicSheetResultListAdapter
import com.example.search.databinding.FragmentMusicSheetBinding
import com.example.search.viewmodel.SearchViewModel
import com.example.search.viewmodel.fragment.MusicSheetViewModel

class MusicSheetFragment : BaseFragment<FragmentMusicSheetBinding,MusicSheetViewModel>() {

    override val layoutId = layout.fragment_music_sheet
    override val variableId = BR.musicSheetViewModel

    private lateinit var activityModel : SearchViewModel

    override fun initData(savedInstanceState: Bundle?) {
        activityModel = ViewModelProvider(requireActivity())[SearchViewModel::class.java]
        initView()
        initListener()
        initObserve()
    }

    private fun initView(){
        binding.musicSheetResultList.layoutManager = LinearLayoutManager(requireActivity())
        binding.musicSheetResultList.itemAnimator = null//设置list删除或增加动画，避免bug
        binding.musicSheetResultListRefresh.setEnableRefresh(false)
    }

    private fun initListener(){
        //监听滑动到底部后加载更多
        binding.musicSheetResultListRefresh.setOnLoadMoreListener {
            viewModel.offset++
            viewModel.getSearchMusicSheetResultList(activityModel.keyWords.value.toString())
        }
    }

    private fun initObserve(){
        //监听外部的输入框内的消息
        activityModel.keyWords.observe(this){
            viewModel.offset = 0
            activityModel.isSearchResultFinishLoading(false)
            viewModel.getSearchMusicSheetResultList(it)
        }

        //获取到歌单结果后设置到list中
        viewModel.mSearchMusicSheetResultList.observe(this){
            if (it.isNullOrEmpty()){
                showToast("没有更多数据啦!")
                binding.musicSheetResultListRefresh.finishLoadMore()
                if (viewModel.offset > 0) viewModel.offset--
            }else{
                val adapter : MusicSheetResultListAdapter
                if (binding.musicSheetResultList.adapter == null){
                    adapter = MusicSheetResultListAdapter(it.toMutableList())
                    adapter.setItemOnClickListener(object : MusicSheetResultListAdapter.ItemOnClickListener{
                        override fun onClick(view: View, i: Int) {

                        }
                    })
                    binding.musicSheetResultList.adapter = adapter
                }else{
                    adapter = binding.musicSheetResultList.adapter as MusicSheetResultListAdapter
                    adapter.musicSheetList = it.toMutableList()
                    adapter.notifyItemRangeInserted(viewModel.offset * 20,20)
                    binding.musicSheetResultListRefresh.finishLoadMore()
                }
                activityModel.isSearchResultFinishLoading(true)
            }
        }
    }


}