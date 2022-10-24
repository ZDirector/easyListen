package com.example.search.ui

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.baseui.BaseActivity
import com.example.common.baseui.assembly.BaseViewPageAdapter
import com.example.common.utils.setStatusBarColor
import com.example.common.utils.setStatusBarTextColor
import com.example.search.BR
import com.example.search.R
import com.example.search.adapter.HotSearchListAdapter
import com.example.search.adapter.RecommendSearchListAdapter
import com.example.search.adapter.SearchSuggestListAdapter
import com.example.search.databinding.ActivitySearchBinding
import com.example.search.manager.FlowLayoutManager
import com.example.search.ui.fragment.MusicResultFragment
import com.example.search.ui.fragment.MusicSheetFragment
import com.example.search.ui.fragment.MusicVideoFragment
import com.example.search.ui.fragment.TestFragment
import com.example.search.viewmodel.SearchViewModel

class SearchActivity : BaseActivity<ActivitySearchBinding,SearchViewModel>() ,
    View.OnClickListener{
    override var layoutId: Int = R.layout.activity_search
    override var variableId: Int = BR.searchViewModel

    private val titleList = listOf("单曲","歌单","视频","用户")
    private val pageList = listOf(
        MusicResultFragment(),
        MusicSheetFragment(),
        MusicVideoFragment(),
        TestFragment()
    )
    private var isSuggestToSearch = false

    override fun initData(savedInstanceState: Bundle?) {
        setStatusBarTextColor(true)
        setStatusBarColor(Color.WHITE)
        initView()
        initListener()
        initObserve()
    }

    private fun initView(){
        binding.searchSuggestList.layoutManager = LinearLayoutManager(this)
        binding.searchHotList.layoutManager = LinearLayoutManager(this)
        binding.searchRecommendList.layoutManager = FlowLayoutManager()
        binding.searchHistoryList.layoutManager = FlowLayoutManager()

        binding.searchResultLayout.mViewPage.adapter = BaseViewPageAdapter(pageList,supportFragmentManager,lifecycle)
        binding.searchResultLayout.attach(titleList)

        startLoading()
        //加载搜索历史记录
        viewModel.getSearchHistory()
        //加载搜索推荐
        viewModel.getRecommendSearchList()
        //加载热搜榜
        viewModel.getHotSearchList()
    }

    private fun initListener(){
        binding.searchBack.setOnClickListener(this)
        binding.searchEditTextClear.setOnClickListener(this)
        binding.searchHistoryClear.setOnClickListener(this)

        //输入过程中的搜索建议监听
        binding.searchTextInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString() == ""){
                    binding.searchSuggestList.visibility = View.GONE
                    binding.searchMainLayout.visibility = View.VISIBLE
                    binding.searchResultLayout.visibility = View.GONE
                }
                else{
                    if (!isSuggestToSearch){
                        viewModel.getSearchSuggest(s.toString())
                        startLoading()
                        binding.searchMainLayout.visibility = View.GONE
                        binding.searchResultLayout.visibility = View.GONE
                    }else isSuggestToSearch = false
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        //设置搜索回车监听和相关逻辑
        binding.searchTextInput.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && keyCode != KeyEvent.ACTION_UP) {
                val text = binding.searchTextInput.text
                onClickSearch(text.toString())
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
                }
                return@setOnKeyListener true
            } else return@setOnKeyListener false
        }
    }

    private fun initObserve(){
        //获得搜索建议数据并传递给搜索建议列表
        viewModel.mSearchSuggestList.observe(this){
            val adapter : SearchSuggestListAdapter
            //防止反复创建adapter
            if (binding.searchSuggestList.adapter == null){
                adapter = SearchSuggestListAdapter(it)
                adapter.setItemOnClickListener(object : SearchSuggestListAdapter.ItemOnClickListener{
                    override fun onClick(view: View, i: Int) {
                        isSuggestToSearch = true
                        binding.searchTextInput.setText(adapter.searchSuggestList[i])
                        onClickSearch(adapter.searchSuggestList[i])
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                            imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
                        }
                    }
                })
                binding.searchSuggestList.adapter = adapter
            }else{
                adapter = binding.searchSuggestList.adapter as SearchSuggestListAdapter
                adapter.searchSuggestList = it
                adapter.notifyDataSetChanged()
            }
            finishLoading()
            binding.searchSuggestList.visibility = View.VISIBLE
        }

        //获得热搜榜数据并传递给热搜榜
        viewModel.mHotSearchList.observe(this){
            val adapter = HotSearchListAdapter(it)
            adapter.setItemOnClickListener(object : HotSearchListAdapter.ItemOnClickListener{
                override fun onClick(view: View, i: Int) {
                    binding.searchTextInput.setText(it[i])
                }
            })
            binding.searchHotList.adapter = adapter
        }

        //获得推荐搜索列表数据并传递给推荐搜索列表
        viewModel.mRecommendSearchList.observe(this){
            val adapter = RecommendSearchListAdapter(it)
            adapter.setItemOnClickListener(object : RecommendSearchListAdapter.ItemOnClickListener{
                override fun onClick(view: View, i: Int) {
                    binding.searchTextInput.setText(it[i])
                }
            })
            binding.searchRecommendList.adapter = adapter
        }

        //获得搜索历史列表数据并传递给搜索历史列表
        viewModel.mSearchHistoryList.observe(this){
            if (it.isEmpty()){
                binding.searchHistoryLayout.visibility = View.GONE
            }else{
                binding.searchHistoryLayout.visibility = View.VISIBLE
                //防止反复创建adapter
                val adapter : RecommendSearchListAdapter
                if (binding.searchHistoryList.adapter == null){
                    adapter = RecommendSearchListAdapter(it)
                    adapter.setItemOnClickListener(object : RecommendSearchListAdapter.ItemOnClickListener{
                        override fun onClick(view: View, i: Int) {
                            binding.searchTextInput.setText(adapter.recommendSearchList[i])
                        }
                    })
                    binding.searchHistoryList.adapter = adapter
                }else{
                    adapter = binding.searchHistoryList.adapter as RecommendSearchListAdapter
                    adapter.recommendSearchList = it
                    adapter.notifyDataSetChanged()
                }
            }
        }

        //当初始化加载完成后显示界面并取消加载界面
        viewModel.initMission.observe(this){
            val initList = listOf("getHotSearchList","getRecommendSearchList","getSearchHistory")
            var isFinish = true
            initList.forEach { item ->
                if (it.containsKey(item)){
                    if(!it[item]!!) isFinish = false
                }
            }
            if (isFinish){
                finishLoading()
                binding.searchMainLayout.visibility = View.VISIBLE
            }
        }

        //fragment加载时通知Activity
        viewModel.isSearchResultFinishLoading.observe(this){
            if (it){
                finishLoading()
                binding.searchResultLayout.visibility = View.VISIBLE
            }
            else{
                startLoading()
                binding.searchResultLayout.visibility = View.INVISIBLE
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.search_back ->{
                finish()
            }
            R.id.search_editText_clear ->{
                binding.searchTextInput.setText("")
                finishLoading()
            }
            R.id.search_history_clear ->{
                viewModel.delAllSearchHistory()
            }
        }
    }

    private fun startLoading(){
        binding.searchLoadingLayout.visibility = View.VISIBLE
        binding.searchLoadingAnim.smoothToShow()
    }

    private fun finishLoading(){
        binding.searchLoadingLayout.visibility = View.GONE
        binding.searchLoadingAnim.smoothToShow()
    }

    private fun onClickSearch(keyWords : String){
        viewModel.addSearchHistory(keyWords)
        binding.searchSuggestList.visibility = View.GONE
        binding.searchMainLayout.visibility = View.GONE
        viewModel.keyWords.postValue(keyWords)
        binding.searchResultLayout.mViewPage.adapter?.notifyDataSetChanged()
        binding.searchResultLayout.mViewPage.currentItem = 0
    }

}