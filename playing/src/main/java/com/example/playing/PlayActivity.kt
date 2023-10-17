package com.example.playing

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.common.utils.MyApplication
import com.example.common.utils.SystemUtils
import com.example.playing.databinding.ActivityPlayBinding
import com.example.playing.viewModel.PlayViewModel

class PlayActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, PlayActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityPlayBinding
    private lateinit var viewModel: PlayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_play)
        binding.lifecycleOwner = this

        SystemUtils.changeStatusBarTransTextWhite(this)

        viewModel = MyApplication.getAppViewModel(PlayViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        initView()
        subscribeData()
    }

    private fun initView() {
        binding.ivPlay.setOnClickListener {
            viewModel.play()
        }
    }

    private fun subscribeData() {

    }

}