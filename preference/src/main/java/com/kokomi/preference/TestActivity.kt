package com.kokomi.preference

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.example.common.baseui.BaseActivity
import com.example.common.bean.MusicSheet
import com.kokomi.preference.databinding.FragmentUserBinding

class TestActivity : BaseActivity<FragmentUserBinding, TestViewModel>() {

    override val layoutId: Int = R.layout.fragment_user

    override fun initData(savedInstanceState: Bundle?) {
        binding.slvUserCreation.setMusicSheet(this, MutableLiveData())
        binding.slvUserCreation.text = "创建歌单"
    }

}