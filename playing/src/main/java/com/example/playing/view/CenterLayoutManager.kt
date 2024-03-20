package com.example.playing.view

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.example.common.utils.dp2px

class CenterLayoutManager(
    context: Context,
    orientation: Int,
    reverseLayout: Boolean
) : LinearLayoutManager(
        context,
        orientation,
        reverseLayout
    ) {

    override fun scrollToPosition(position: Int) {
        val viewWidth = findViewByPosition(position)?.width ?: 0
        val offsetX = viewWidth * 2 + 1.dp2px
        scrollToPositionWithOffset(position, offsetX)
    }

    override fun smoothScrollToPosition(
        recyclerView: RecyclerView,
        state: RecyclerView.State?,
        position: Int
    ) {
        val smoothScroller: RecyclerView.SmoothScroller =
            CenterSmoothScroller(recyclerView.context)
        smoothScroller.targetPosition = position
        startSmoothScroll(smoothScroller)
    }

    class CenterSmoothScroller constructor(context: Context?) :
        LinearSmoothScroller(context) {
        override fun calculateDtToFit(
            viewStart: Int,
            viewEnd: Int,
            boxStart: Int,
            boxEnd: Int,
            snapPreference: Int
        ): Int {
            return boxStart + (boxEnd - boxStart) / 2 - (viewStart + (viewEnd - viewStart) / 2)
        }
    }
}