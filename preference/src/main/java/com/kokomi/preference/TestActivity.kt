package com.kokomi.preference

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.example.common.baseui.BaseActivity
import com.example.common.bean.MusicSheet
import com.kokomi.preference.databinding.FragmentUserBinding

class TestActivity : BaseActivity<FragmentUserBinding, TestViewModel>() {

    override val layoutId: Int = R.layout.fragment_user

    override fun initData(savedInstanceState: Bundle?) {
        binding.slvUserCreation.setMusicSheet(
            this, MutableLiveData(
                mutableListOf(
                    MusicSheet(
                        1, "赤土之王与三朝圣者", "原神3.1版本",
                        "https://uploadstatic.mihoyo.com/puzzle/upload/puzzle/2022/09/22/fc1e1f63445f98fe943435474d2bc59f_7853406441613588886.jpg"
                    ),
                    MusicSheet(
                        1, "赤土之王与三朝圣者", "原神3.1版本",
                        "https://uploadstatic.mihoyo.com/puzzle/upload/puzzle/2022/09/22/fc1e1f63445f98fe943435474d2bc59f_7853406441613588886.jpg"
                    )
                )
            )
        )
        binding.slvUserCreation.text = "创建歌单"
    }

}