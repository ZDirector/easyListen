package com.example.video.adapter

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.video.ui.fragment.VideoFragment

class VideoViewPageAdapter(
    videoIdList: List<Int>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager,lifecycle) {

    private val mVideoIdList = videoIdList
    override fun getItemCount() = mVideoIdList.size

    override fun createFragment(position: Int) = VideoFragment.newInstance(mVideoIdList[position])

}