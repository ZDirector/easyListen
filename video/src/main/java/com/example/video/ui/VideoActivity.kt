package com.example.video.ui

import android.Manifest
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.common.baseui.BaseActivity
import com.example.common.utils.setStatusBarColor
import com.example.common.utils.setStatusBarTextColor
import com.example.video.BR
import com.example.video.R
import com.example.video.adapter.VideoViewPageAdapter
import com.example.video.databinding.ActivityVideoBinding
import com.example.video.viewmodel.VideoViewModel


class VideoActivity : BaseActivity<ActivityVideoBinding,VideoViewModel>() , View.OnClickListener{

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

        val list = intent.getIntArrayExtra("videoIdList")
        viewModel.videoIdList.addAll(list!!.toMutableList())
        viewModel.currentPage = intent.getIntExtra("currentLocation",0)
        binding.videoVp.adapter = VideoViewPageAdapter(viewModel.videoIdList,supportFragmentManager,lifecycle)
        binding.videoVp.setCurrentItem(viewModel.currentPage,false)
        binding.videoVp.offscreenPageLimit = 1
        binding.videoVp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewModel.currentPage = position
                super.onPageSelected(position)
            }
        })
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

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ic_back ->{
                viewModel.currentExoPlayer?.pause()
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.proxy.shutdown()
    }
}