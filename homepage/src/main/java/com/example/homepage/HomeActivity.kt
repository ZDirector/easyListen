package com.example.homepage

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
 import androidx.navigation.ui.setupWithNavController
import com.example.homepage.databinding.ActivityHomeBinding
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        immersive()
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        val navController = findNavController(R.id.container)
        mBinding.navView .setupWithNavController(navController)
//        mBinding.navView.selectedItemId = R.id.musicFragment
        mBinding.navView.labelVisibilityMode= NavigationBarView.LABEL_VISIBILITY_LABELED
//        mBinding.navView.itemIconTintList = null

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

}