package com.example.video.ui

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.SCROLL_STATE_DRAGGING
import androidx.viewpager2.widget.ViewPager2.SCROLL_STATE_SETTLING
import com.example.common.baseui.BaseActivity
import com.example.common.utils.LogUtil
import com.example.common.utils.setStatusBarColor
import com.example.common.utils.setStatusBarTextColor
import com.example.video.BR
import com.example.video.R
import com.example.video.adapter.VideoViewPageAdapter
import com.example.video.databinding.ActivityVideoBinding
import com.example.video.viewmodel.VideoViewModel


class VideoActivity : BaseActivity<ActivityVideoBinding,VideoViewModel>(){

    override val layoutId = R.layout.activity_video
    override val variableId = BR.videoViewModel

    companion object{
        const val REQUEST_CODE_PERMISSIONS = 10//授权回调RequestCode
        //需要的权限列表
        private val REQUIRED_PERMISSIONS = mutableListOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ).toTypedArray()
    }

    override fun initData(savedInstanceState: Bundle?) {
        setStatusBarColor(Color.BLACK)
        setStatusBarTextColor(false)
        initPermission()

        LogUtil.d("VideoFragment","previewExoPlayer : ${viewModel.previewExoPlayer}")
        LogUtil.d("VideoFragment","currentExoPlayer : ${viewModel.currentExoPlayer}")
        LogUtil.d("VideoFragment","nextExoPlayer : ${viewModel.nextExoPlayer}")
        val list = intent.getIntArrayExtra("videoIdList")
        viewModel.videoIdList.addAll(list!!.toMutableList())
        viewModel.currentPage.value = intent.getIntExtra("currentLocation",0)
        binding.videoVp.adapter = VideoViewPageAdapter(viewModel.videoIdList,supportFragmentManager,lifecycle)
        binding.videoVp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                if (state == SCROLL_STATE_DRAGGING) viewModel.onPlayerPause()
                LogUtil.d("VideoFragment","onPageScrollStateChanged")
                super.onPageScrollStateChanged(state)
            }

            override fun onPageSelected(position: Int) {
                if(viewModel.currentPage.value!! < position){
                    val temp = viewModel.previewExoPlayer
                    viewModel.previewExoPlayer = viewModel.currentExoPlayer
                    viewModel.currentExoPlayer = viewModel.nextExoPlayer
                    viewModel.nextExoPlayer = temp
                }else if (viewModel.currentPage.value!! > position){
                    val temp = viewModel.nextExoPlayer
                    viewModel.nextExoPlayer = viewModel.currentExoPlayer
                    viewModel.currentExoPlayer = viewModel.previewExoPlayer
                    viewModel.previewExoPlayer = temp
                }
                LogUtil.d("VideoFragment","onPageSelected")
                viewModel.currentPage.postValue(position)
                viewModel.onPlayerReady()
                super.onPageSelected(position)
            }
        })
        binding.videoVp.setCurrentItem(viewModel.currentPage.value!!,false)
        binding.videoVp.offscreenPageLimit = 1
    }


    //判断权限是否获取成功
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    //判断是否授权
    private fun initPermission(){
        if (!allPermissionsGranted()){
            //未授权，请求权限
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults:
        IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionsGranted()){
                Toast.makeText(this,
                    "授权失败，请到设置页中对应用进行相应的授权",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.previewExoPlayer.release()
        viewModel.currentExoPlayer.release()
        viewModel.nextExoPlayer.release()
    }
}