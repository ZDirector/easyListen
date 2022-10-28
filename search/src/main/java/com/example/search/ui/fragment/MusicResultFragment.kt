package com.example.search.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.baseui.BaseFragment
import com.example.common.utils.LogUtil
import com.example.search.BR
import com.example.search.R
import com.example.search.adapter.MusicResultListAdapter
import com.example.search.databinding.FragmentMusicResultBinding
import com.example.search.viewmodel.SearchViewModel
import com.example.search.viewmodel.fragment.MusicResultViewModel

class MusicResultFragment : BaseFragment<FragmentMusicResultBinding,MusicResultViewModel>() {
    override val layoutId: Int = R.layout.fragment_music_result
    override val variableId: Int = BR.musicResultViewModel

    private lateinit var activityModel : SearchViewModel

    override fun initData(savedInstanceState: Bundle?) {
        activityModel = ViewModelProvider(requireActivity())[SearchViewModel::class.java]
        initView()
        initListener()
        initObserve()
    }

    private fun initView(){
        binding.musicResultList.layoutManager = LinearLayoutManager(requireActivity())
        binding.musicResultListRefresh.setEnableRefresh(false)
    }

    private fun initListener(){
        binding.musicResultListRefresh.setOnLoadMoreListener {
            viewModel.offset++
            viewModel.getSearchMusicResultList(activityModel.keyWords.value.toString())
        }
    }

    private fun initObserve(){
        activityModel.keyWords.observe(this){
            viewModel.offset = 0
            activityModel.isSearchResultFinishLoading(false)
            viewModel.getSearchMusicResultList(it)
        }

        viewModel.mSearchMusicResultList.observe(this){
            if (it.isNullOrEmpty()){
                binding.musicResultListRefresh.setNoMoreData(true)
            }else{
                val adapter : MusicResultListAdapter
                if (binding.musicResultList.adapter == null){
                    adapter = MusicResultListAdapter(it.toMutableList())
                    adapter.setItemOnClickListener(object : MusicResultListAdapter.ItemOnClickListener{
                        override fun onClick(view: View, i: Int) {

                        }
                    })
                    binding.musicResultList.adapter = adapter
                }else{
                    adapter = binding.musicResultList.adapter as MusicResultListAdapter
                    adapter.musicResultList = it.toMutableList()
                    adapter.notifyItemRangeChanged(viewModel.offset * 20,20)
                    binding.musicResultListRefresh.finishLoadMore()
                }
            }
            activityModel.isSearchResultFinishLoading(true)
        }
    }

}