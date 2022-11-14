package com.example.homepage.toplist.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homepage.R
import com.example.homepage.databinding.ActivityTopListBinding
import com.example.homepage.toplist.adapter.OfficialAdapter
import com.example.homepage.toplist.adapter.TopOtherAdapter
import com.example.homepage.toplist.bean.Song
import com.example.homepage.toplist.bean.TopListTab
import com.example.homepage.toplist.viewmodel.TopListViewModel
import kotlinx.coroutines.flow.collect

class TopListActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityTopListBinding
    private val mViewModel by viewModels<TopListViewModel>()
    private val mAdapter by lazy { OfficialAdapter() }
    private val mTab = TopListTab.values()
    private val mFeaturesAdapter by lazy { TopOtherAdapter() }
    private val mGlobalAdapter by lazy { TopOtherAdapter() }
    private val mStyleAdapter by lazy { TopOtherAdapter() }
    private val mSelectAdapter by lazy { TopOtherAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_top_list)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = mViewModel
        init()
        setEachRv()
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
                it[TopListTab.Handpick]?.let {
                    println("这是啥%￥4$it")
                    mSelectAdapter.data.clear()
                    mSelectAdapter.data.addAll(it)
                    mSelectAdapter.notifyDataSetChanged()
                }
                it[TopListTab.Characteristic]?.let {
                    mFeaturesAdapter.data.clear()
                    mFeaturesAdapter.data.addAll(it)
                    mFeaturesAdapter.notifyDataSetChanged()
                }
                it[TopListTab.Genre]?.let {
                    mStyleAdapter.data.clear()
                    mStyleAdapter.data.addAll(it)
                    mStyleAdapter.notifyDataSetChanged()
                }
                it[TopListTab.Global]?.let {
                    mGlobalAdapter.data.clear()
                    mGlobalAdapter.data.addAll(it)
                    mGlobalAdapter.notifyDataSetChanged()
                }
            }
        }
        mViewModel.loadTopListData()

    }


    private fun setEachRv(){
        mBinding.apply {
            rvFeatures.layoutManager =  GridLayoutManager(this@TopListActivity,3)
            rvGlobal.layoutManager =  GridLayoutManager(this@TopListActivity,3)
            rvStyle.layoutManager =  GridLayoutManager(this@TopListActivity,3)
            rvSelect.layoutManager =  GridLayoutManager(this@TopListActivity,3)

            rvFeatures.adapter= mFeaturesAdapter
            rvGlobal.adapter = mGlobalAdapter
            rvStyle.adapter = mStyleAdapter
            rvSelect.adapter = mSelectAdapter
        }
    }
}