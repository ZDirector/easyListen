package com.example.search.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.baseui.BaseFragment
import com.example.common.utils.LogUtil
import com.example.common.utils.showToast
import com.example.search.BR
import com.example.search.R
import com.example.search.adapter.MusicResultListAdapter
import com.example.search.databinding.FragmentMusicResultBinding
import com.example.search.util.MusicPopupWindow
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
        binding.musicResultList.itemAnimator = null//设置list删除或增加动画，避免bug
        binding.musicResultListRefresh.setEnableRefresh(false)
    }

    private fun initListener(){
        //监听滑动到底部后加载更多
        binding.musicResultListRefresh.setOnLoadMoreListener {
            viewModel.offset++
            viewModel.getSearchMusicResultList(activityModel.keyWords.value.toString())
        }
    }

    private fun initObserve(){
        //监听外部的输入框内的消息
        activityModel.keyWords.observe(this){
            viewModel.offset = 0
            activityModel.isSearchResultFinishLoading(false)
            viewModel.getSearchMusicResultList(it)
        }

        //获取到单曲结果后设置到list中
        viewModel.mSearchMusicResultList.observe(this){
            if (it.isNullOrEmpty()){
                showToast("没有更多数据啦!")
                binding.musicResultListRefresh.finishLoadMore()
                viewModel.offset--
            }else{
                val adapter : MusicResultListAdapter
                if (binding.musicResultList.adapter == null){
                    adapter = MusicResultListAdapter(it.toMutableList())
                    adapter.setItemOnClickListener(object : MusicResultListAdapter.ItemOnClickListener{
                        override fun onClick(view: View, i: Int) {
                            when(view.id){
                                R.id.item_search_music_setting ->{//当点击音乐列表item中的设置图标时显示弹窗
                                    val popupWindow = MusicPopupWindow(view,adapter.musicResultList[i])
                                    popupWindow.initPopWindow()
                                    popupWindow.setBackground(requireActivity().window)
                                    popupWindow.show()
                                }
                                else ->{

                                }
                            }
                        }
                    })
                    binding.musicResultList.adapter = adapter
                }else{
                    adapter = binding.musicResultList.adapter as MusicResultListAdapter
                    adapter.musicResultList = it.toMutableList()
                    adapter.notifyItemRangeInserted(viewModel.offset * 20,20)
                    binding.musicResultListRefresh.finishLoadMore()
                }
            }
            activityModel.isSearchResultFinishLoading(true)
        }
    }

}