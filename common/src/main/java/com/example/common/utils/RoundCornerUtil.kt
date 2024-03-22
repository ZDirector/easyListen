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

class BackgroundDrawable(
    private val strokeWidth: Int,
    private val strokeColor: Int,
    private val solidColor: Int,
    private val roundRadius: Float,
    private var leftTopRadius: Float,
    private var rightTopRadius: Float,
    private var leftBottomRadius: Float,
    private var rightBottomRadius: Float
) : Drawable() {

    private val paint = Paint().apply {
        isAntiAlias = true
    }
    private val outerPath = Path()
    private val innerPath = Path()

    override fun onBoundsChange(bounds: Rect) {
        super.onBoundsChange(bounds)
        createPath(bounds)
    }

    private fun createPath(bounds: Rect) {
        if (strokeWidth < 0 || roundRadius < 0f && leftTopRadius < 0f && rightTopRadius < 0f && leftBottomRadius < 0f && rightBottomRadius < 0f) {
            return
        }

        outerPath.reset()
        innerPath.reset()

        // 由于android绘画机制，绘制圆角边框时，会导致圆角宽度比四周粗一倍，所以需要将边框宽度减去一半
        val halfBorderWidth = strokeWidth / 2f
        val outRect = RectF(
            bounds.left + halfBorderWidth,
            bounds.top + halfBorderWidth,
            bounds.right - halfBorderWidth,
            bounds.bottom - halfBorderWidth
        )

        if (roundRadius != 0f) {
            leftTopRadius = roundRadius
            rightTopRadius = roundRadius
            leftBottomRadius = roundRadius
            rightBottomRadius = roundRadius
        }

        val outerRadii = floatArrayOf(
            leftTopRadius,
            leftTopRadius,
            rightTopRadius,
            rightTopRadius,
            rightBottomRadius,
            rightBottomRadius,
            leftBottomRadius,
            leftBottomRadius
        )
        outerPath.addRoundRect(outRect, outerRadii, Path.Direction.CW)

        val innerRect = RectF(
            bounds.left + strokeWidth.toFloat(),
            bounds.top + strokeWidth.toFloat(),
            bounds.right - strokeWidth.toFloat(),
            bounds.bottom - strokeWidth.toFloat()
        )
        val innerRadii = floatArrayOf(
            0f.coerceAtLeast(leftTopRadius - strokeWidth + 1.5f),
            0f.coerceAtLeast(leftTopRadius - strokeWidth + 1.5f),
            0f.coerceAtLeast(rightTopRadius - strokeWidth + 1.5f),
            0f.coerceAtLeast(rightTopRadius - strokeWidth + 1.5f),
            0f.coerceAtLeast(rightBottomRadius - strokeWidth + 1.5f),
            0f.coerceAtLeast(rightBottomRadius - strokeWidth + 1.5f),
            0f.coerceAtLeast(leftBottomRadius - strokeWidth + 1.5f),
            0f.coerceAtLeast(leftBottomRadius - strokeWidth + 1.5f)
        )
        innerPath.addRoundRect(innerRect, innerRadii, Path.Direction.CW)
    }

    override fun draw(canvas: Canvas) {
        paint.color = strokeColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth.toFloat()
        canvas.drawPath(outerPath, paint)

        paint.color = solidColor
        paint.style = Paint.Style.FILL
        canvas.drawPath(innerPath, paint)
    }

    override fun getOutline(outline: Outline) {
        val rect = bounds
        outline.setRoundRect(rect.left, rect.top, rect.right, rect.bottom, roundRadius)
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }
}