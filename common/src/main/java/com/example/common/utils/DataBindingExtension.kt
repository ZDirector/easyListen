package com.example.common.utils


import android.widget.ImageView
import androidx.annotation.Nullable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, @Nullable url: String?) {
        if (url == null) {
            return
        }
        Glide.with(view)
            .load(url)
            .centerCrop()
            .dontAnimate()
            .into(view)
    }

