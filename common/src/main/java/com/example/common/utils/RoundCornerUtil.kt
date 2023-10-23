package com.example.common.utils

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Outline
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PixelFormat
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.drawable.Drawable

class RoundedCornersDrawable(
    private val backgroundColor: Int,
    private val radius: Float = 0f,
    private val leftTopRadius: Float = 0f,
    private val rightTopRadius: Float = 0f,
    private val leftBottomRadius: Float = 0f,
    private val rightBottomRadius: Float = 0f
) : Drawable() {
    private val paint = Paint().apply {
        isAntiAlias = true
        color = backgroundColor
    }
    private val path = Path()

    override fun onBoundsChange(bounds: Rect) {
        super.onBoundsChange(bounds)
        path.reset()
        val rect = RectF(bounds)
        if (radius != 0f) {
            path.addRoundRect(rect, radius, radius, Path.Direction.CW)
        } else {
            val radii = floatArrayOf(
                leftTopRadius, leftTopRadius,
                rightTopRadius, rightTopRadius,
                rightBottomRadius, rightBottomRadius,
                leftBottomRadius, leftBottomRadius
            )
            path.addRoundRect(rect, radii, Path.Direction.CW)
        }
        path.close()
    }

    override fun getOutline(outline: Outline) {
        val rect = bounds
        outline.setRoundRect(rect.left, rect.top, rect.right, rect.bottom, radius)
    }

    override fun draw(canvas: Canvas) {
        canvas.drawPath(path, paint)
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int = PixelFormat.TRANSLUCENT
}