package com.example.playing.view

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.common.utils.LogUtil
import com.example.common.utils.MyApplication
import com.example.common.utils.setOnSingleClickListener
import com.example.playing.R
import com.example.playing.adapter.MusicLyricListAdapter
import com.example.playing.data.LyricLine
import com.example.playing.databinding.MusicLyricViewBinding
import com.example.playing.viewModel.PlayViewModel
import kotlin.math.abs

class MusicLyricView : FrameLayout {

    companion object {
        const val TAG = "MusicLyricView"
        const val REFRESH_PLAY_LINE_INTERVAL = 500L
    }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context)
    }

    private lateinit var binding: MusicLyricViewBinding
    private val adapter = MusicLyricListAdapter()
    private lateinit var linearSnapHelper: LinearSnapHelper
    private var currentPosition = 0
    private var isScrolling = false // 是否是用户手动滚动
    private var refreshPlayLineLastTime = 0L
    private var beSelectPosition = 0
    private var handler: Handler? = Handler(Looper.getMainLooper())

    private fun initView(context: Context) {
        if (context is FragmentActivity) {
            val inflater = LayoutInflater.from(context)
            binding = DataBindingUtil.inflate(
                inflater,
                R.layout.music_lyric_view,
                this,
                true
            )
            binding.lifecycleOwner = context

            binding.rvLyric.adapter = adapter
            binding.rvLyric.itemAnimator = null
            binding.rvLyric.layoutManager =
                CenterLayoutManager(context, RecyclerView.VERTICAL, false)
            linearSnapHelper = LinearSnapHelper()
            linearSnapHelper.attachToRecyclerView(binding.rvLyric)

            binding.rvLyric.addOnItemTouchListener(object :
                RecyclerView.SimpleOnItemTouchListener() {
                override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                    when (e.action) {
                        MotionEvent.ACTION_DOWN -> {
                            isScrolling = true
                            binding.clPlayLine.visibility = VISIBLE
                            handler?.removeCallbacksAndMessages(null)
                        }

                        MotionEvent.ACTION_UP -> {
                            // 延迟3s后设置为false，防止歌曲进度回调导致立即滚动回currentPosition
                            gonePlayLine(3000)
                        }
                    }
                    return false
                }
            })
            binding.rvLyric.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (isScrolling) {
                        val isRefreshPlayLine =
                            System.currentTimeMillis() - refreshPlayLineLastTime > REFRESH_PLAY_LINE_INTERVAL
                        if (isRefreshPlayLine) {
                            refreshPlayLineLastTime = System.currentTimeMillis()
                            // 计算当前居中的item
                            val centerItem = calculateCenterItemPosition(
                                binding.rvLyric,
                                binding.rvLyric.layoutManager as LinearLayoutManager
                            )
                            LogUtil.d(TAG, "centerItem = $centerItem")
                            centerItem?.let {
                                val list = adapter.currentList.toMutableList()
                                binding.currentTime = list[it].time
                                beSelectPosition = it
                            }
                        }
                    }
                }
            })

            binding.clPlayLine.setOnSingleClickListener {
                val viewModel = MyApplication.getAppViewModel(PlayViewModel::class.java)
                gonePlayLine(0)
                binding.currentTime?.let { time ->
                    viewModel.seekTo(time)
                }
            }
        }
    }

    fun setLyric(lyricList: List<LyricLine>) {
        val newList = lyricList.toMutableList()
        // 前后各加9行空白，为了让首末歌词能够居中显示
        for (i in 0 until 9) {
            newList.add(0, LyricLine(0, " "))
        }
        for (i in 0 until 9) {
            newList.add(LyricLine(0, " "))
        }
        adapter.submitList(newList)
    }

    fun setCurrentTime(currentTime: Int) {
        // 如果正在滚动，不处理
        if (isScrolling) {
            return
        }
        val lyricList = adapter.currentList.toMutableList()
        for (i in 0 until lyricList.size) {
            val lyricLine = lyricList[i]
            if (lyricLine.time > currentTime) {
                val position = if (i == 0) 0 else i - 1
                if (position == currentPosition && beSelectPosition != 0) {
                    // 如果当前位置没有变化，不处理
                    return
                }
                beSelectPosition = 0
                currentPosition = position
                lyricList.forEachIndexed { index, item ->
                    if (index == currentPosition) {
                        lyricList[index] = item.copy(_isPlaying = true)
                    } else if (item._isPlaying) {
                        lyricList[index] = item.copy(_isPlaying = false)
                    }
                }

                adapter.submitList(lyricList)
                binding.currentTime = lyricLine.time
                binding.rvLyric.smoothScrollToPosition(currentPosition)
                break
            }
        }
    }

    private fun gonePlayLine(interval: Int) {
        handler?.removeCallbacksAndMessages(null)
        handler?.postDelayed({
            isScrolling = false
            binding.clPlayLine.visibility = GONE
        }, interval.toLong())
    }

    private fun calculateCenterItemPosition(
        recyclerView: RecyclerView,
        layoutManager: LinearLayoutManager
    ): Int? {
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
        val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

        val center = recyclerView.height / 2
        var closestPosition = -1
        var closestDistance = Int.MAX_VALUE

        for (i in firstVisibleItemPosition..lastVisibleItemPosition) {
            val child = layoutManager.findViewByPosition(i) ?: continue
            val childCenter = (child.top + child.bottom) / 2
            val distance = abs(childCenter - center)

            if (distance < closestDistance) {
                closestDistance = distance
                closestPosition = i
            }
        }

        return if (closestPosition >= 0) closestPosition else null
    }


}