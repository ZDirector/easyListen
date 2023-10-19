package com.example.homepage.activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.common.utils.MyApplication
import com.example.homepage.R
import com.example.homepage.databinding.ActivityHomeBinding
import com.example.homepage.music.fragment.MusicFragment
import com.example.homepage.ui.fragment.CareFragment
import com.example.homepage.ui.fragment.MineFragment
import com.example.homepage.ui.fragment.VideoFragment
import com.example.homepage.utils.HomeConstants
import com.example.homepage.utils.HomeConstants.BOTTOM_MUSIC
import com.example.search.ui.SearchActivity
import com.google.android.material.navigation.NavigationBarView


class HomeActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityHomeBinding
    private var mMusicFragment: MusicFragment? = null
    private var mCareFragment: CareFragment? = null
    private var mVideoFragment: VideoFragment? = null
    private var mMineFragment: MineFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        immersive()
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        init()
        initListener()
        initMusicService()
        mBinding.navView.labelVisibilityMode= NavigationBarView.LABEL_VISIBILITY_LABELED
    }

    private fun init() {
        setFragment(BOTTOM_MUSIC)
        mBinding.apply {
            toolbar.findViewById<TextView>(R.id.et_search).setOnClickListener {
                val intent = Intent(this@HomeActivity,SearchActivity::class.java)
                startActivity(intent)
            }
        }
    }

    /**
     * 初始化音乐服务
     */
    private fun initMusicService() {
        MyApplication.instance.let {
            it.get()?.mediaManager?.connectService()
        }
    }

    private fun initListener() {
        mBinding.apply {
            navView.setOnItemSelectedListener {

                when (it.itemId) {
                    R.id.musicFragment -> {
                        setFragment(BOTTOM_MUSIC)
                    }
                    R.id.careFragment -> {

                        setFragment(HomeConstants.BOTTOM_CARE)
                    }
                    R.id.videoFragment -> {
                        setFragment(HomeConstants.BOTTOM_VIDEO)
                    }
                    R.id.mineFragment -> {
                        setFragment(HomeConstants.BOTTOM_MINE)
                    }

                }
                true
            }
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



    private fun setFragment(index: Int) {
        //获取Fragment管理器
        val mFragmentManager: FragmentManager = supportFragmentManager
        //开启事务
        val mTransaction: FragmentTransaction = mFragmentManager.beginTransaction()
        //隐藏所有Fragment
        hideFragments(mTransaction)
        mBinding.apply {
            when(index){
                BOTTOM_MUSIC->{
                    if (mMusicFragment == null){
                        mMusicFragment = MusicFragment()
                        mTransaction.add(R.id.container,mMusicFragment!!)
                    }else{
                        mTransaction.show(mMusicFragment!!)
                    }
                }
                HomeConstants.BOTTOM_CARE->{
                    if (mCareFragment == null){
                        mCareFragment = CareFragment()
                        mTransaction.add(R.id.container,mCareFragment!!)
                    }else{
                        mTransaction.show(mCareFragment!!)
                    }
                }
                HomeConstants.BOTTOM_VIDEO->{

                    if (mVideoFragment == null){
                        mVideoFragment = VideoFragment()
                        mTransaction.add(R.id.container,mVideoFragment!!)
                    }else{
                        mTransaction.show(mVideoFragment!!)
                    }
                }
                HomeConstants.BOTTOM_MINE->{

                    if (mMineFragment == null){
                        mMineFragment = MineFragment()
                        mTransaction.add(R.id.container,mMineFragment!!)
                    }else{
                        mTransaction.show(mMineFragment!!)
                    }
                }
            }

        }

        mTransaction.commit()
    }


    private fun hideFragments(transaction: FragmentTransaction) {
        if (mMusicFragment != null) {
            transaction.hide(mMusicFragment!!)
        }
        if (mCareFragment != null) {
            transaction.hide(mCareFragment!!)
        }
        if (mVideoFragment != null) {
            transaction.hide(mVideoFragment!!)
        }
        if (mMineFragment != null) {
            transaction.hide(mMineFragment!!)
        }
    }

    private fun disconnectMusicService() {
        MyApplication.instance.get()?.let {
            it.mediaManager?.stop()
            it.mediaManager?.disconnectService()
        }
    }

    override fun onDestroy() {
        disconnectMusicService()
        super.onDestroy()
    }
}