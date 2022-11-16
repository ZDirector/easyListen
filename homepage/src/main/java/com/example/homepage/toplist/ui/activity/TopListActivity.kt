package com.example.homepage.toplist.ui.activity

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.utils.UiUtils
import com.example.common.utils.immersive
import com.example.common.utils.navigationBarHeight
import com.example.homepage.R
import com.example.homepage.databinding.ActivityTopListBinding
import com.example.homepage.toplist.adapter.OfficialAdapter
import com.example.homepage.toplist.adapter.TopOtherAdapter
import com.example.homepage.toplist.bean.TopListTab
import com.example.homepage.toplist.viewmodel.TopListViewModel
import com.google.android.material.tabs.TabLayout


class TopListActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityTopListBinding
    private val mViewModel by viewModels<TopListViewModel>()
    private val mAdapter by lazy { OfficialAdapter() }
    private val mFeaturesAdapter by lazy { TopOtherAdapter() }
    private val mGlobalAdapter by lazy { TopOtherAdapter() }
    private val mStyleAdapter by lazy { TopOtherAdapter() }
    private val mSelectAdapter by lazy { TopOtherAdapter() }
    private var mTabIndex = 0
    private var mScrollviewFlag = false //标记是否是scrollview在滑动
    private var h1 = 0
    private var h2 = 0
    private var h3 = 0
    private var h4 = 0
    private var h5 = 0

    private lateinit var mViewTreeObserver: ViewTreeObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        immersive(window,this)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_top_list)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = mViewModel
        initBottomImmersive()
        mViewTreeObserver = mBinding.scrollView.viewTreeObserver
        init()
        composeTabScroll()

        setEachRv()

    }

    private fun initBottomImmersive(){
        mBinding.apply {
            val lp = bottomView.layoutParams as ConstraintLayout.LayoutParams
            lp.height= bottomView.height + navigationBarHeight
            bottomView.layoutParams = lp
            bottomView.requestLayout()
            flControlPlay.bringToFront()
        }
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


    private fun setEachRv() {
        mBinding.apply {
            rvFeatures.layoutManager = GridLayoutManager(this@TopListActivity, 3)
            rvGlobal.layoutManager = GridLayoutManager(this@TopListActivity, 3)
            rvStyle.layoutManager = GridLayoutManager(this@TopListActivity, 3)
            rvSelect.layoutManager = GridLayoutManager(this@TopListActivity, 3)

            rvFeatures.adapter = mFeaturesAdapter
            rvGlobal.adapter = mGlobalAdapter
            rvStyle.adapter = mStyleAdapter
            rvSelect.adapter = mSelectAdapter
        }
    }

    private fun composeTabScroll() {
        mBinding.apply {
            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    if (!mScrollviewFlag) {
                        when (tab?.position) {
                            0 -> scrollView.scrollTo(0, h1)
                            1 -> scrollView.scrollTo(0, h2)
                            2 -> scrollView.scrollTo(0, h3)
                            3 -> scrollView.scrollTo(0, h4)
                            4 -> scrollView.scrollTo(0, h5)
                        }
                    }
                    mScrollviewFlag = false
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
            })


            scrollView.viewTreeObserver.addOnScrollChangedListener {
                scrollView.apply {
                    println("scrollY为$scrollY   ${rvStyle.top} ${rvStyle.measuredHeight} ${tvSelect.top}}")


                    h1 =tvOfficial.marginTop
                    h2 = calculateView(tvOfficial)+calculateView(rvOfficial)+tvStyle.marginTop
                    h3=  calculateView(tvOfficial)+calculateView(rvOfficial)+calculateView(tvStyle)+calculateView(rvStyle)+tvGlobal.marginTop

                    h4 = h3+ calculateView(rvSelect)
                    h5 = h4+ calculateView(tvFeatures)
                    println("$h1,$h2,$h3,$h4,$h5 莎莎很大声的 ${tvStyle.top}")

                    mScrollviewFlag = true
                    mTabIndex = tabLayout.selectedTabPosition
                        if (scrollY < h2) {
                            if (mTabIndex != 0) {//增加判断，如果滑动的区域是tableIndex=0对应的区域，则不改变tablayout的状态
                                tabLayout.selectTab(tabLayout.getTabAt(0))
                            }
                        } else if (scrollY in h2 until h3) {
                            if (mTabIndex != 1) {
                                tabLayout.selectTab(tabLayout.getTabAt(1))
                            }
                        } else if (scrollY in h3 until h4) {
                            if (mTabIndex != 2) {
                                tabLayout.selectTab(tabLayout.getTabAt(2))
                            }
                        } else if (scrollY in h4 until h5) {
                            if (mTabIndex != 3) {
                                tabLayout.selectTab(tabLayout.getTabAt(3))
                            }
                        } else {
                            if (mTabIndex != 4) {
                                tabLayout.selectTab(tabLayout.getTabAt(4))
                            }
                        }
                    }
                    mScrollviewFlag = false

            }

        }
    }

    private fun calculateView(view: View):Int{
        return view.marginTop+view.marginBottom+view.measuredHeight
    }





}
