package com.example.homepage.playSquare


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.common.adapter.DataClickListener
import com.example.common.bean.home.Playlist
import com.example.common.bean.searchBean.Song
import com.example.common.utils.UiUtils.setPic
import com.example.common.utils.bindImageFromUrlBlur
import com.example.common.utils.immersive
import com.example.homepage.R
import com.example.homepage.databinding.ActivitySquareDetailBinding
import com.example.homepage.playSquare.adapter.SongsAdapter
import com.example.homepage.playSquare.viewmodel.PlayListDetailViewModel
import kotlin.math.abs


class SquareDetailActivity : FragmentActivity() {

    private lateinit var mBinding: ActivitySquareDetailBinding
    private lateinit var mViewModel: PlayListDetailViewModel
    private var mMainColor: Int = 0
    private var mMore = true
    private var loading: Boolean = false
    private val mAdapter: SongsAdapter by lazy {
        val adapter = SongsAdapter()
        adapter.itemClickListener = object : DataClickListener<Song> {
            override fun onClick(value: Song, position: Int) {

            }
        }
        adapter
    }


    private val mFootView by lazy {
        LayoutInflater.from(applicationContext).inflate(
            R.layout.foot_layout, null
        )
    }

    companion object {
        fun getStatusBarHeight(context: Context): Int {
            var result = 0
            val resId: Int =
                context.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resId > 0) {
                result = context.resources.getDimensionPixelOffset(resId)
            }
            return result
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        immersive(window, this)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_square_detail)
        mViewModel = ViewModelProvider(this)[PlayListDetailViewModel::class.java]
        mBinding.viewModel = mViewModel
        init()
        mBinding.apply {
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.adapter = mAdapter
            tvTitleBar.bringToFront()
            setToolBar()
        }
        mBinding.lifecycleOwner = this

        getPicColor()

        initColor()
        setImageView()
        initList()
        initSongs()

    }

    private fun getPicColor() {
        lifecycleScope.launchWhenCreated {
            mViewModel.setBitMap()

            mViewModel.bitmapStateFlow.collect {
                val builder = it.let { Palette.from(it) }
                val palette = builder.generate()
                mMainColor = palette.getDarkVibrantColor(Color.WHITE)
                initColor()
            }
        }

    }


    private fun initColor() {
        mBinding.apply {
            toolbar.setBackgroundColor(mMainColor)
            clPlaylist.setBackgroundColor(mMainColor)
            appBar.setBackgroundColor(mMainColor)
            viewTop.setBackgroundColor(mMainColor)
        }
    }

    private fun setToolBar() {
        mBinding.apply {
            toolbarLayout.isTitleEnabled = false
            toolbarLayout.expandedTitleGravity = Gravity.CENTER//设置展开后标题的位置
            toolbarLayout.collapsedTitleGravity = Gravity.CENTER//设置收缩后标题的位置
            toolbarLayout.setExpandedTitleColor(Color.WHITE)//设置展开后标题的颜色
            toolbarLayout.setCollapsedTitleTextColor(Color.WHITE)//设置收缩后标题的颜色
            appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
                val offset = abs(verticalOffset)

                /**
                 * 当前最大高度偏移值除以2 在减去已偏移值 获取浮动 先显示在隐藏
                 */
                toolbar.setBackgroundColor(mMainColor)

                if (offset < appBarLayout.totalScrollRange / 2) {
                    tvTitleBar.setTextColor(resources.getColor(R.color.white))

                    tvTitleBar.alpha =
                        (appBarLayout.totalScrollRange / 2 - offset * 1.0f) / (appBarLayout.totalScrollRange / 2)
                    toolbar.title = ""
                    if (tvTitleBar.alpha > 15) {
                        tvTitleBar.hint = ""
                        tvTitleBarPlay.text = mViewModel.nameLiveData.value

                    } else {
                        tvTitleBar.hint = "歌单"
                        tvTitleBarPlay.text = ""
                    }

                } else if (offset > appBarLayout.totalScrollRange / 2) {
                    val alpha: Float =
                        (offset - appBarLayout.totalScrollRange / 2) * 1.0f / (appBarLayout.totalScrollRange / 2)
                    toolbar.alpha = alpha
                    tvTitleBarPlay.text = mViewModel.nameLiveData.value
                }
            }
        }
    }

    private fun init() {
        if (intent.getSerializableExtra("playlist") != null) {
            val playlist = intent.getSerializableExtra("playlist") as Playlist
            mViewModel.listData = playlist
            getPicColor()
            mBinding.apply {
                mViewModel.apply {
                    urlLiveData.value = playlist.coverImgUrl
                    nameLiveData.postValue(playlist.name)
                    describeLiveData.postValue(playlist.description)
                    val picUrl: String = if (listData!!.picUrl != "") {
                        listData?.picUrl.toString()
                    } else listData?.coverImgUrl!!
                    setPic(ibPlaylist, 20, picUrl)
                    bindImageFromUrlBlur(ivBg, picUrl)
                    loadList()
                }
            }
        }
        mBinding.apply {
            viewTop.layoutParams.height = getStatusBarHeight(applicationContext)
            tvTitleBarPlay.requestFocus()
        }
    }

    private fun initSongs() {
        mBinding.apply {
            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE && !recyclerView.canScrollVertically(
                            1
                        )
                    ) {
                        if (mMore) {
                            if (!loading) {
                                loadList()
                                mAdapter.addFooterView(mFootView)
                            }
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "所有数据加载完毕！",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            })
        }
    }

    private fun loadList() {
        loading = true
        mViewModel.listData?.let {
            mViewModel.getSongs(it.id, 18, mAdapter.data.size)
        }
    }

    private fun initList() {
        lifecycleScope.launchWhenCreated {
            mViewModel.songsStateFlow.collect {
                val size = mAdapter.data.size
                mAdapter.data.addAll(it)
                mAdapter.notifyItemRangeChanged(size, it.size)
                loading = false
                mAdapter.removeFooterView(mFootView)
            }
        }
    }

    private fun setImageView() {
        mBinding.apply {
            //Glide设置图片圆角角度
            val roundedCorners = RoundedCorners(20)
            //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
            val options = RequestOptions.bitmapTransform(roundedCorners)

            Glide.with(ibPlaylist.context)
                .load(R.drawable.star) //.placeholder(R.drawable.ic_default_image)
                .apply(options)
                .into(ibPlaylist)
        }
    }
}



