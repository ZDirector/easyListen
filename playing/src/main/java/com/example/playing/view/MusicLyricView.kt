package com.example.playing.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.example.playing.R
import com.example.playing.databinding.MusicLyricViewBinding

class MusicLyricView : FrameLayout{

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context)
    }

    private lateinit var binding : MusicLyricViewBinding
    private var beSelectPosition = 0

    private fun initView(context: Context) {
        if (context is FragmentActivity) {
            val inflater = LayoutInflater.from(context)
            binding = DataBindingUtil.inflate(
                inflater,
                R.layout.music_lyric_view,
                this,
                true
            )
            binding.lifecycleOwner = context
        }
    }

}