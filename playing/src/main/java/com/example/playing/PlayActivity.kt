package com.example.playing

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.example.common.utils.MyApplication
import com.example.common.utils.SystemUtils
import com.example.playing.databinding.ActivityPlayBinding
import com.example.playing.viewModel.PlayViewModel

class PlayActivity : FragmentActivity() {

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
        binding.ivBack.setOnClickListener {
            finish()
        }
        binding.ivPlay.setOnClickListener {
            viewModel.play()
        }
        binding.ivNext.setOnClickListener {
            viewModel.next()
        }
        binding.ivPre.setOnClickListener {
            viewModel.previous()
        }
        binding.musicSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    viewModel.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        binding.ivPlayMode.setOnClickListener {
            viewModel.changePlayMode()
        }
        binding.ivPlayList.setOnClickListener {
            PLayListFragment.show(this)
        }
    }

    private fun subscribeData() {

    }

}