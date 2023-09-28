package com.example.common.baseui.assembly

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

open class BaseViewPageAdapter(
    fragmentList: List<Fragment>,
    fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager,lifecycle) {

    private val mFragmentList = mutableListOf<Fragment>()

    init {
        mFragmentList.clear()
        mFragmentList.addAll(fragmentList)
    }

    override fun getItemCount() = mFragmentList.size

    override fun createFragment(position: Int) = mFragmentList[position]

}