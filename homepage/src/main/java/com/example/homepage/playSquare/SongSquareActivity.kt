package com.example.homepage.playSquare

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowManager
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.common.baseui.assembly.BaseViewPageAdapter
import com.example.common.utils.navigationBarHeight
import com.example.common.utils.setOnSingleClickListener
import com.example.homepage.R
import com.example.homepage.databinding.ActivitySongSquareBinding
import com.example.homepage.playSquare.fragment.PlaySquareDetailFragment
import com.example.homepage.playSquare.viewmodel.SquareViewModel
import com.google.android.material.tabs.TabLayout

class SongSquareActivity : FragmentActivity() {
    private lateinit var mBinding: ActivitySongSquareBinding
    private lateinit var mViewModel: SquareViewModel
    private val mTabList: MutableList<String> = mutableListOf()
    private val mPageList: MutableList<PlaySquareDetailFragment> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        immersive()
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_song_square)
        mBinding.lifecycleOwner = this
        mViewModel = ViewModelProvider(this)[SquareViewModel::class.java]
        init()
    }

    private fun init() {
        getTags()

        mBinding.apply {

            val lp = bottomNav.layoutParams as ConstraintLayout.LayoutParams
            lp.height = bottomNav.height + navigationBarHeight
            bottomNav.layoutParams = lp
            bottomNav.requestLayout()

            mBinding.ivBack.setOnSingleClickListener {
                finish()
            }
        }

    }

    /**
     * 初始化tags
     */
    private fun getTags() {
        lifecycleScope.launchWhenCreated {
            mViewModel.tagsStateFlow.collect {
                mTabList.clear()
                for (i in it.indices) {
                    mTabList.add(it[i].name)
                }
                initFragment()
                initPager()

            }
        }
        mViewModel.getTags()

    }

    private fun initFragment() {
        mPageList.clear()
        for (i in mTabList.indices) {
            mPageList.add(PlaySquareDetailFragment(mTabList[i]))
        }
    }

    private fun initPager() {
        mBinding.apply {
            vpTabSquare.mViewPage.adapter =
                BaseViewPageAdapter(mPageList, supportFragmentManager, lifecycle)
            vpTabSquare.attach(mTabList)
            vpTabSquare.mTableLayout.tabMode = TabLayout.MODE_SCROLLABLE
        }
    }


    /**
     * 沉浸式处理
     */
    private fun immersive() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.apply {
                //清除透明状态栏标识
                clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                //添加绘制状态栏标识
                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                // 添加透明导航标识
                addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
                //设置状态栏的颜色为透明
                statusBarColor = Color.TRANSPARENT
            }
            findViewById<ViewGroup>(android.R.id.content).apply {
                //遍历根布局的子布局
                for (index in 0 until childCount) {
                    val child = getChildAt(index) as? ViewGroup
                    //让布局根据系统窗口来调整自己的布局
                    child?.let {
                        it.fitsSystemWindows = true
                        it.clipToPadding = true
                    }
                }
            }

        } else {
            //Android4.4这个设置就能实现沉浸式效果
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }
}
