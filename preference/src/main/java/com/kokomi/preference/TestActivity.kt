package com.kokomi.preference

import android.os.Bundle
import com.example.common.baseui.BaseActivity
import com.kokomi.preference.databinding.ActivityTestBinding

class TestActivity : BaseActivity<ActivityTestBinding, TestViewModel>() {

    override val layoutId: Int = R.layout.activity_test

    override fun initData(savedInstanceState: Bundle?) {

    }

}