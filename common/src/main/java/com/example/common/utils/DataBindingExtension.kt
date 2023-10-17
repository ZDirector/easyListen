package com.example.common.utils


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.common.R
import jp.wasabeef.glide.transformations.BlurTransformation

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

@BindingAdapter("imageFromUrlRound")
fun bindImageFromUrlRound(view: ImageView, imageUrl: String?) {
    if (imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(R.color.white)
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(RequestOptions.circleCropTransform())
            .into(view)
        return
    }
    Glide.with(view.context)
        .load(imageUrl)
        .transition(DrawableTransitionOptions.withCrossFade())
        .apply(RequestOptions.circleCropTransform())
        .into(view)
}

@BindingAdapter("imageFromUrlBlur")
fun bindImageFromUrlBlur(view: ImageView, imageUrl: String?) {
    if (imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(R.color.black)
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 3)))
            .into(view)
        return
    }
    Glide.with(view.context)
        .load(imageUrl)
        .transition(DrawableTransitionOptions.withCrossFade())
        .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 3)))
        .into(view)
}

@BindingAdapter("playTimeText")
fun playTimeText(view: TextView, time: Int) {
    if (time == 0) {
        view.text = "00:00"
        return
    }
    val minute = time / 1000 / 60
    val second = time / 1000 % 60
    view.text = "$minute:$second"
}

@BindingAdapter("playMode")
fun playMode(view: ImageView, mode: Int) {
    when (mode) {
        0 -> view.setImageResource(R.drawable.ic_play_mode_loop)
        1 -> view.setImageResource(R.drawable.ic_play_mode_random)
        2 -> view.setImageResource(R.drawable.ic_play_mode_single)
        3 -> view.setImageResource(R.drawable.ic_play_mode_order)
        else -> view.setImageResource(R.drawable.ic_play_mode_loop)
    }
}

@BindingAdapter("playState")
fun playState(view: ImageView, isPlaying: Boolean) {
    if (isPlaying) {
        view.setImageResource(R.drawable.ic_pause)
    } else {
        view.setImageResource(R.drawable.ic_play)
    }
}

