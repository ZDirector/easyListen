package com.example.common.utils


import android.graphics.Outline
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewOutlineProvider
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

@BindingAdapter("goneUnless")
fun bindGoneUnless(view: View, show: Boolean?) {
    if (show == true) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter("invisibleUnless")
fun bindInvisibleUnless(view: View, show: Boolean?) {
    view.visibility = if (show == true) View.VISIBLE else View.INVISIBLE
}

/**
 * 设置View圆角(单位默认dp)
 * @param roundRadius 圆角大小
 * @param leftTopRadius 左上角圆角角度
 * @param rightTopRadius 右上角圆角角度
 * @param leftBottomRadius 左下角圆角角度
 * @param rightBottomRadius 右下角圆角角度
 * 这里有个坑，如果使用圆角的view要动态变化宽高，那么就会失效，需要重新调用一次
 */
@BindingAdapter(
    value = ["roundRadius", "leftTopRadius", "rightTopRadius", "leftBottomRadius", "rightBottomRadius"],
    requireAll = false
)
fun setRoundCornerOutline(
    view: View,
    roundRadius: Int = 0,
    leftTopRadius: Int = 0,
    rightTopRadius: Int = 0,
    leftBottomRadius: Int = 0,
    rightBottomRadius: Int = 0,
) {
    val background = view.background
    if (background is ColorDrawable) {
        val roundedCornersDrawable = RoundedCornersDrawable(
            background.color,
            roundRadius.dp2px.toFloat(),
            leftTopRadius.dp2px.toFloat(),
            rightTopRadius.dp2px.toFloat(),
            leftBottomRadius.dp2px.toFloat(),
            rightBottomRadius.dp2px.toFloat()
        )
        view.background = roundedCornersDrawable

        //为了能够兼容evaluate，使用outlineProvider
        view.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                roundedCornersDrawable.getOutline(outline)
            }
        }
        view.clipToOutline = true
        return
    }

    // 图片为背景时，只能全圆角，其他圆角设置无效
    // 单独设置图片某个圆角实际应用很少，且目前没有方案实现，所以暂时不考虑
    if (view is ImageView || background is BitmapDrawable) {
        if (roundRadius == 0) {
            return
        }
        view.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(
                    0,
                    0,
                    view.width,
                    view.height,
                    roundRadius.dp2px.toFloat()
                )
            }
        }
        view.clipToOutline = true
    }
}

/**
 * 绘制背景，支持stroke和solid
 * @param strokeWidth 边框宽度
 * @param strokeColor 边框颜色
 * @param roundRadius 圆角大小
 * @param leftTopRadius 左上角圆角角度
 * @param rightTopRadius 右上角圆角角度
 * @param leftBottomRadius 左下角圆角角度
 * @param rightBottomRadius 右下角圆角角度
 * 这里有个坑，如果使用圆角的view要动态变化宽高，那么就会失效，需要重新调用一次
 */
@BindingAdapter(
    value = ["bg_strokeWidth", "bg_strokeColor", "bg_roundRadius", "bg_leftTopRadius", "bg_rightTopRadius", "bg_leftBottomRadius", "bg_rightBottomRadius"],
    requireAll = false
)
fun setRoundCornerBackground(
    view: View,
    strokeWidth: Int = 0,
    @androidx.annotation.ColorInt
    strokeColor: Int = 0,
    roundRadius: Int = 0,
    leftTopRadius: Int = 0,
    rightTopRadius: Int = 0,
    leftBottomRadius: Int = 0,
    rightBottomRadius: Int = 0,
) {
    val background = view.background
    if (background is ColorDrawable) {
        val drawable = BackgroundDrawable(
            strokeWidth.dp2px,
            strokeColor,
            background.color,
            roundRadius.dp2px.toFloat(),
            leftTopRadius.dp2px.toFloat(),
            rightTopRadius.dp2px.toFloat(),
            leftBottomRadius.dp2px.toFloat(),
            rightBottomRadius.dp2px.toFloat()
        )

        view.background = drawable
        //为了能够兼容evaluate，使用outlineProvider
        view.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                drawable.getOutline(outline)
            }
        }
        view.clipToOutline = true
    }
}

@BindingAdapter("textStyleBold")
fun setTextStyleBold(textView: TextView, isBold: Boolean) {
    textView.setTypeface(null, if (isBold) Typeface.BOLD else Typeface.NORMAL)
}


