package com.example.playing

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.example.common.utils.MyApplication
import com.example.common.utils.SystemUtils
import com.example.common.utils.setOnSingleClickListener
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
        binding.ivBack.setOnSingleClickListener {
            finish()
        }
        binding.ivPlay.setOnSingleClickListener {
            viewModel.play()
        }
        binding.ivNext.setOnSingleClickListener {
            viewModel.next()
        }
        binding.ivPre.setOnSingleClickListener {
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
        binding.ivPlayMode.setOnSingleClickListener {
            viewModel.changePlayMode()
        }
        binding.ivPlayList.setOnSingleClickListener {
            PLayListFragment.show(this)
        }
        binding.ivAlbum.setOnSingleClickListener {
            binding.ivAlbum.visibility = View.GONE
            binding.mlvLyric.visibility = View.VISIBLE
        }
        binding.mlvLyric.setOnSingleClickListener {
            binding.ivAlbum.visibility = View.VISIBLE
            binding.mlvLyric.visibility = View.GONE
        }
    }

    private fun subscribeData() {
        viewModel.currentMusic.observe(this) {
            if (it.id != -1L) {
                viewModel.getLyric(it.id)
            }
        }

        viewModel.musicLyricList.observe(this) {
            binding.mlvLyric.setLyric(it)
        }

        viewModel.currentProgress.observe(this) {
            binding.mlvLyric.setCurrentTime(it)
        }
    }

}