package com.example.search.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.baseui.BaseFragment
import com.example.common.utils.showToast
import com.example.search.BR
import com.example.search.R
import com.example.search.adapter.SearchUserListAdapter
import com.example.search.databinding.FragmentSearchUserBinding
import com.example.search.viewmodel.SearchViewModel
import com.example.search.viewmodel.fragment.SearchUserViewModel

class SearchUserFragment : BaseFragment<FragmentSearchUserBinding,SearchUserViewModel>() {

    override val layoutId = R.layout.fragment_search_user
    override val variableId = BR.searchUserViewModel
    private lateinit var activityModel : SearchViewModel

    override fun initData(savedInstanceState: Bundle?) {
        activityModel = ViewModelProvider(requireActivity())[SearchViewModel::class.java]
        initView()
        initListener()
        initObserve()
    }

    private fun initView(){
        binding.searchUserList.layoutManager = LinearLayoutManager(requireActivity())
        binding.searchUserList.itemAnimator = null//设置list删除或增加动画，避免bug
        binding.searchUserListRefresh.setEnableRefresh(false)
    }

    private fun initListener(){
        //监听滑动到底部后加载更多
        binding.searchUserListRefresh.setOnLoadMoreListener {
            viewModel.offset++
            viewModel.getSearchUserList(activityModel.keyWords.value.toString())
        }
    }

    private fun initObserve(){
        //监听外部的输入框内的消息
        activityModel.keyWords.observe(this){
            viewModel.offset = 0
            activityModel.isSearchResultFinishLoading(false)
            viewModel.getSearchUserList(it)
        }

        viewModel.mSearchUserList.observe(this){
            if (it.isNullOrEmpty()){
                showToast("没有更多数据啦!")
                binding.searchUserListRefresh.finishLoadMore()
                if (viewModel.offset > 0) viewModel.offset--
            }else{
                val adapter : SearchUserListAdapter
                if (binding.searchUserList.adapter == null){
                    adapter = SearchUserListAdapter(it.toMutableList())
                    adapter.setItemOnClickListener(object : SearchUserListAdapter.ItemOnClickListener{
                        override fun onClick(view: View, i: Int) {

                        }
                    })
                    binding.searchUserList.adapter = adapter
                }else{
                    adapter = binding.searchUserList.adapter as SearchUserListAdapter
                    adapter.userList = it.toMutableList()
                    adapter.notifyItemRangeInserted(viewModel.offset * 20,20)
                    binding.searchUserListRefresh.finishLoadMore()
                }
                activityModel.isSearchResultFinishLoading(true)
            }
        }
    }
}