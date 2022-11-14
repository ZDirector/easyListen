package com.example.homepage.toplist.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homepage.R
import com.example.homepage.databinding.ActivityTopListBinding
import com.example.homepage.toplist.adapter.OfficialAdapter
import com.example.homepage.toplist.bean.Song
import com.example.homepage.toplist.bean.TopListTab
import com.example.homepage.toplist.viewmodel.TopListViewModel
import kotlinx.coroutines.flow.collect

class TopListActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityTopListBinding
    private val mViewModel by viewModels<TopListViewModel>()
    private val mAdapter by lazy { OfficialAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_top_list)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = mViewModel
        init()
    }


    private fun init() {
        mBinding.apply {
            toolbar.findViewById<TextView>(R.id.tv_bar_text).text = "排行榜"
            rvOfficial.layoutManager = LinearLayoutManager(this@TopListActivity)
            rvOfficial.adapter = mAdapter
        }
        lifecycleScope.launchWhenCreated {
            mViewModel.topDetailsStateFlow.collect { it ->
                it[TopListTab.Official]?.let {
                    mAdapter.data.clear()
                    mAdapter.data.addAll(it)
                    mAdapter.notifyDataSetChanged()
                }
            }
        }
        mViewModel.loadTopListData()

    }
}