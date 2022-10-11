package com.example.easylisten

import android.os.Bundle
import com.example.common.baseui.BaseActivity
import com.example.easylisten.databinding.ActivityMainBinding

class MainActivity(override val layoutId: Int = R.layout.activity_main) : BaseActivity<ActivityMainBinding,MainViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initData(savedInstanceState: Bundle?) {
        println("我，俄欧皮$viewModel  ${viewModel.ss}")
    }
}