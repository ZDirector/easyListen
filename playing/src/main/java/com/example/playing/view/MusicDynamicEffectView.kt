package com.example.playing.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.example.common.utils.dp2px
import com.example.playing.R

class MusicDynamicEffectView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    companion object {
        const val TAG = "MusicDynamicEffectView"
    }

    init {
        initView(context)
    }

    private val path = Path()
    private val paint = Paint()
    private val controlPointList = mutableListOf<Pair<Double, Double>>()
    private val mRatio = 0.551915024494
    private val strokeWidth = 1.dp2px.toDouble()
    private var padding = 30.dp2px

    private fun initView(context: Context) {
        if (isInEditMode) {
            return
        }
        post {
            initPath()
            invalidate()
        }
    }

    /**
     * 初始化画笔
     * 1. 获取父布局的宽高
     * 2. 计算中心坐标
     * 3. 计算出三阶贝塞尔曲线的控制点
     * 4. 初始化 Path
     */
    private fun initPath() {
        val radius = measuredWidth / 2f - padding - strokeWidth
        val centerX = measuredWidth / 2f
        val centerY = measuredHeight / 2f

        // 12点钟方向控制点
        controlPointList.add(
            Pair(
                centerX.toDouble(), centerX - radius
            )
        )
        // 1点钟方向控制点
        controlPointList.add(
            Pair(
                centerX + radius * mRatio, centerX - radius
            )
        )
        // 2点钟方向控制点
        controlPointList.add(
            Pair(
                centerX + radius, centerY - radius * mRatio
            )
        )
        // 3点钟方向控制点
        controlPointList.add(
            Pair(
                centerX + radius, centerY.toDouble()
            )
        )
        // 4点钟方向控制点
        controlPointList.add(
            Pair(
                centerX + radius,
                centerY + radius * mRatio
            )
        )
        // 5点钟方向控制点
        controlPointList.add(
            Pair(
                centerX + radius * mRatio,
                centerY + radius
            )
        )
        // 6点钟方向控制点
        controlPointList.add(
            Pair(
                centerX.toDouble(), centerY + radius
            )
        )
        // 7点钟方向控制点
        controlPointList.add(
            Pair(
                centerX - radius * mRatio,
                centerY + radius
            )
        )
        // 8点钟方向控制点
        controlPointList.add(
            Pair(
                centerX - radius, centerY + radius * mRatio
            )
        )
        // 9点钟方向控制点
        controlPointList.add(
            Pair(
                centerX - radius, centerY.toDouble()
            )
        )
        // 10点钟方向控制点
        controlPointList.add(
            Pair(
                centerX - radius, centerY - radius * mRatio
            )
        )
        // 11点钟方向控制点
        controlPointList.add(
            Pair(
                centerX - radius * mRatio, centerX - radius
            )
        )

        paint.isAntiAlias = true
        paint.color = resources.getColor(R.color.white)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth.toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (controlPointList.isEmpty()) {
            return
        }

        path.reset()
        // 从12点钟方向开始画
        path.moveTo(controlPointList[0].first.toFloat(), controlPointList[0].second.toFloat())

        // 画贝塞尔曲线
        // 第一象限圆弧
        path.cubicTo(
            controlPointList[1].first.toFloat(),
            controlPointList[1].second.toFloat(),
            controlPointList[2].first.toFloat(),
            controlPointList[2].second.toFloat(),
            controlPointList[3].first.toFloat(),
            controlPointList[3].second.toFloat()
        )
        canvas.drawPath(path, paint)

        // 第二象限圆弧
        path.cubicTo(
            controlPointList[4].first.toFloat(),
            controlPointList[4].second.toFloat(),
            controlPointList[5].first.toFloat(),
            controlPointList[5].second.toFloat(),
            controlPointList[6].first.toFloat(),
            controlPointList[6].second.toFloat()
        )
        canvas.drawPath(path, paint)

        // 第三象限圆弧
        path.cubicTo(
            controlPointList[7].first.toFloat(),
            controlPointList[7].second.toFloat(),
            controlPointList[8].first.toFloat(),
            controlPointList[8].second.toFloat(),
            controlPointList[9].first.toFloat(),
            controlPointList[9].second.toFloat()
        )
        canvas.drawPath(path, paint)
        // 第四象限圆弧
        path.cubicTo(
            controlPointList[10].first.toFloat(),
            controlPointList[10].second.toFloat(),
            controlPointList[11].first.toFloat(),
            controlPointList[11].second.toFloat(),
            controlPointList[0].first.toFloat(),
            controlPointList[0].second.toFloat()
        )
        canvas.drawPath(path, paint)
    }
}