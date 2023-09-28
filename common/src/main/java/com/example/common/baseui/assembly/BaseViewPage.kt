package com.example.common.baseui.assembly

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.common.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class BaseViewPage : LinearLayout {

    val mTableLayout : TabLayout
    val mViewPage : ViewPager2

    init {
        LayoutInflater.from(context).inflate(R.layout.base_viewpage,this, true)
        mTableLayout = findViewById(R.id.base_viewPage_Tab)
        mViewPage = findViewById(R.id.base_viewPage_VP)
        mViewPage.offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs,defStyleAttr)

    fun attach(tabList: List<String>){
        val tabLayoutMediator = TabLayoutMediator(mTableLayout,mViewPage) { tab, position ->
            tab.text = tabList[position]
        }
        tabLayoutMediator.attach()
    }

}