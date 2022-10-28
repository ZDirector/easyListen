package com.example.homepage.playSquare.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.adapter.DataClickListener
import com.example.homepage.R
import com.example.homepage.databinding.FragmentPlaySquareDetailBinding
import com.example.homepage.playSquare.adapter.PlaylistSquareAdapter
import com.example.homepage.playSquare.bean.Playlist
import com.example.homepage.playSquare.viewmodel.SquareViewModel
import java.util.concurrent.RecursiveAction


class PlaySquareDetailFragment(private val title: String) : Fragment() {
    private lateinit var mViewModel: SquareViewModel
    private lateinit var mBinding: FragmentPlaySquareDetailBinding

    //    private lateinit var mAdapter :HighQualityAdapter
    private var loading: Boolean = false
    private var more = true
    private lateinit var footLayout: View
    //加载更多的具体用法
    /**
     * 歌单广场的适配器
     */
    private val mAdapter: PlaylistSquareAdapter by lazy {
        val adapter = PlaylistSquareAdapter()
        adapter.itemClickListener = object : DataClickListener<Playlist> {
            override fun onClick(value: Playlist, position: Int) {
                //跳转到歌单详程
            }
        }
        adapter
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_play_square_detail,
            container,
            false
        )
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initSquareList()
        loadList()
        mAdapter.addFooterView(footLayout)
    }


    private fun init() {
        mViewModel = ViewModelProvider(this)[SquareViewModel::class.java]
        val layoutManager = GridLayoutManager(requireContext(), 3)
        mBinding.apply {
            rvSquare.layoutManager = layoutManager
            rvSquare.adapter = mAdapter
            footLayout = LayoutInflater.from(requireContext()).inflate(
                R.layout.foot_layout, null
            )
            initRvListener(rvSquare)
        }
    }


    /**
     * 初始化列表，收集列表
     */
    private fun initSquareList() {
        lifecycleScope.launchWhenCreated {
            mViewModel.squareListStateFlow.collect {
                val size = mAdapter.data.size
                mAdapter.data.addAll(it.playlists)
                mAdapter.notifyItemRangeChanged(size, it.playlists.size)
                more = it.more
                loading = false
                mAdapter.removeFooterView(footLayout)
            }
        }
    }


    private fun initRvListener(rv: RecyclerView) {
        rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE &&
                    !recyclerView.canScrollVertically(1)
                ) {
                    if (more) {
                        if (!loading) {
                            loadList()
                            mAdapter.addFooterView(footLayout)
                        } else {
                            Toast.makeText(requireContext(), "数据加载完毕！", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

        })

    }


    /**
     * 加载更多数据
     */
    private fun loadList() {
        loading = true
        mViewModel.getSquareList(mAdapter.data.size, 51, title)
    }


/*
    private fun getHighList(){
        lifecycleScope.launch {
            mViewModel.highListStateFlow.collect{
                mAdapter.submitData(it)
            }
        }
        mViewModel.getHighList(title)


    }
*/


}