package com.example.homepage.music.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.homepage.R
import com.example.homepage.playSquare.SongSquareActivity
import com.example.homepage.activity.WebActivity
import com.example.homepage.databinding.FragmentMusicBinding
import com.example.homepage.music.adapter.RankListAdapter
import com.example.homepage.music.bean.Banner
import com.example.homepage.music.bean.Rank
import com.example.homepage.music.viewmodel.MusicViewModel
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.listener.OnBannerListener
import kotlinx.coroutines.launch


class MusicFragment : Fragment(), OnBannerListener<Banner> {
    private lateinit var mBinding: FragmentMusicBinding
    private lateinit var mViewModel: MusicViewModel
    private var mList = mutableListOf<Banner>()
    private var mRanks = mutableListOf<Rank>()
    private lateinit var mRankAdapter:RankListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_music, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProvider(this)[MusicViewModel::class.java]
        init()
        initListener()
    }

    private fun initListener() {
        mBinding.apply {
            btMoreRecommendedPlaylist.setOnClickListener {
                val intent = Intent(activity, SongSquareActivity::class.java)
                startActivity(intent)
            }
            llPlaylist.setOnClickListener {
                val intent = Intent(activity, SongSquareActivity::class.java)
                startActivity(intent)
            }

            llList.setOnClickListener {
 /*               val intent = Intent(activity,TopListActivity::class.java)
                startActivity(intent)*/
            }
        }
    }


    private fun init() {
        lifecycleScope.launch {
            mViewModel.getBanners()
            mViewModel.getRanks()
        }
        initBanner()
        initRecommendedList()
        mBinding.apply {
            val layoutManager = LinearLayoutManager(context)
            layoutManager.orientation = LinearLayout.HORIZONTAL
            rvListRank.layoutManager = layoutManager
            mRankAdapter = RankListAdapter(mRanks)
            rvListRank.adapter = mRankAdapter
                mViewModel.mRankList.observe(viewLifecycleOwner) {
                    mRanks.clear()
                    mRanks.addAll(it)
                    mRankAdapter.notifyDataSetChanged()
                }


        }
    }

    private fun initRecommendedList() {
        lifecycleScope.launch{
            mViewModel.getRecoLists()

        }
        mBinding.apply {
            lvRecommendedPlaylist.setMusicSheet(viewLifecycleOwner,mViewModel.mRecoLists)
        }
    }


    private val mAdapter: BannerImageAdapter<Banner> = object : BannerImageAdapter<Banner>(mList) {
    override fun onBindView(
        holder: BannerImageHolder,
        data: Banner,
        position: Int,
        size: Int
    ) {
        Glide.with(holder.itemView.context)
            .load(data.pic)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
            .into(holder.imageView)

    }
}

private fun initBanner() {
    mBinding.banner.addBannerLifecycleObserver(viewLifecycleOwner)
    mBinding.banner
        .setAdapter(mAdapter)
        .setIndicator(CircleIndicator(context))
        .setLoopTime(3000)
        .setOnBannerListener(this)
    mViewModel.mBanners.observe(
        viewLifecycleOwner
    )
    {
        context?.let {
            if (mList.size > 0) {
            }

        }
        mList.clear()
        mList.addAll(it)
        mAdapter.notifyDataSetChanged()

    }
}

companion object {
    @JvmStatic
    fun newInstance(param1: String, param2: String) =
        MusicFragment().apply {
            arguments = Bundle().apply {
            }
        }
}

    override fun OnBannerClick(data: Banner, position: Int) {
        val intent = Intent(context,WebActivity::class.java)
        intent.putExtra("url",mList[position].url)
        startActivity(intent)
    }
}