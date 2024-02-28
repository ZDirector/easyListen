package com.example.playing.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.example.common.utils.MyApplication
import com.example.playing.PLayListFragment
import com.example.playing.R
import com.example.playing.databinding.FloatingPlayControlViewBinding
import com.example.playing.viewModel.PlayViewModel

class FloatingPlayControlView : FrameLayout {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context)
    }

    private lateinit var binding: FloatingPlayControlViewBinding

    private val playViewModel: PlayViewModel by lazy {
        MyApplication.getAppViewModel(PlayViewModel::class.java)
    }

    private fun initView(context: Context) {
        if (context is FragmentActivity) {
            val inflater = LayoutInflater.from(context)
            binding = DataBindingUtil.inflate(
                inflater,
                R.layout.floating_play_control_view,
                this,
                true
            )
            binding.lifecycleOwner = context
            binding.viewModel = playViewModel

            binding.ivControlPlay.setOnClickListener {
                playViewModel.play()
            }

            binding.ivControlMoreList.setOnClickListener {
                PLayListFragment.show(context)
            }
        }
    }

}