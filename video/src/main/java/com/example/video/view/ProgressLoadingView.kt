package com.example.video.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.AttributeSet
import android.view.View
import com.example.video.R
import java.util.regex.Pattern

class ProgressLoadingView : View {
    private var mWidth = 0
    private var mHeight = 0
    private var mDefaultWidth: Int
    private var mDefaultHeight: Int
    private var mProgressWidth: Int
    private val mMinProgressWidth: Int
    private val mPaint: Paint
    private var mColor: String? = null
    private val mHandler: Handler
    private var mTimePeriod = 20
    private var isShow = false

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        //获取颜色值和最小宽高度，以及进度条最小宽度
        val typedArray = context!!.obtainStyledAttributes(attrs, R.styleable.ProgressLoadingView)
        val color = typedArray.getString(R.styleable.ProgressLoadingView_progressColor)
        mDefaultWidth = typedArray.getDimension(R.styleable.ProgressLoadingView_minWidth, 600f).toInt()
        mDefaultHeight = typedArray.getDimension(R.styleable.ProgressLoadingView_minHeight, 5f).toInt()
        mMinProgressWidth =
            typedArray.getDimension(R.styleable.ProgressLoadingView_minProgressWidth, 100f).toInt()
        mProgressWidth = mMinProgressWidth

        //根据正则表达式来判断颜色格式是否正确
        val regularStr = "^#[A-Fa-f0-9]{6}"
        val compile = Pattern.compile(regularStr)
        mColor = if (color == null) {
            "#808080"
        } else {
            val matcher = compile.matcher(color)
            if (matcher.matches()) { //如果颜色格式正确
                color
            } else {
                //如果颜色格式不正确
                throw IllegalArgumentException("wrong color string type!")
            }
        }
        typedArray.recycle()

        mPaint = Paint()
        //设置画笔模式为填充带边框
        mPaint.style = Paint.Style.FILL_AND_STROKE
        //设置抗锯齿
        mPaint.isAntiAlias = true
        mHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                if (isShow) invalidate()
                sendEmptyMessageDelayed(1, mTimePeriod.toLong())
            }
        }
        mHandler.sendEmptyMessageDelayed(1, mTimePeriod.toLong())
    }

    /**
     * 设置重绘的周期
     * @param timePeriod
     */
    fun setTimePeriod(timePeriod: Int) {
        if (mTimePeriod > 0) {
            mTimePeriod = timePeriod
        }
    }

    fun show(){
        if (!isShow) isShow = true
        this.visibility = VISIBLE
    }

    fun hide(){
        if (isShow) isShow = false
        this.visibility = GONE
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //通过widthMeasureSpec,heightMeasureSpec 来获取view的测量模式和宽高
        val width = getValue(widthMeasureSpec, true)
        val height = getValue(heightMeasureSpec, false)

        //此方法用来设置设置View的具体宽高
        setMeasuredDimension(width, height)
    }

    /**
     * 获取view的宽高值
     * @param measureSpec
     * @param isWidth 是否是测量宽度
     * @return
     */
    private fun getValue(measureSpec: Int, isWidth: Boolean): Int {
        //获取测量模式
        val mode = MeasureSpec.getMode(measureSpec)
        //获取测量的值
        val size = MeasureSpec.getSize(measureSpec)
        return when (mode) {
            //子view的大小已经被限定死，我们只能使用其固定大小
            MeasureSpec.EXACTLY -> size
            //父控件认为子view的大小不能超过size的值，那么我们就取size和默认值之间的最小值
            MeasureSpec.AT_MOST ->
                if (isWidth) mDefaultWidth else mDefaultHeight.coerceAtMost(size)
            //父view不限定子view的大小，我们将其值设置为默认值
            MeasureSpec.UNSPECIFIED ->
                if (isWidth) mDefaultWidth else mDefaultHeight
            else -> if (isWidth) mDefaultWidth else mDefaultHeight
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight = h
        require(mWidth >= mProgressWidth) {
            //如果宽度小于进度条的宽度
            "the progressWidth must less than mWidth"
        }
        mPaint.strokeWidth = mHeight.toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //首先判断进度条的宽度是否大于view宽度
        if (mProgressWidth < mWidth) {
            //如果不大于，将进度条宽度增加10
            if (mDefaultWidth + 30 < mWidth) mProgressWidth += 30
            else mProgressWidth = mWidth
        } else {
            //如果进度条宽度大于view宽度将进度条宽度设置为初始宽度
            mProgressWidth = mMinProgressWidth
        }
        //计算颜色透明度
        //mProgressWidth/mWidth 计算当前进度条宽度占总宽度的比例
        //255*mProgressWidth/mWidth 计算当前比例下对应的透明度值
        //由于是由不透明变成全透明，所以使用255减去其值
        var currentColorValue = 255 - 255 * mProgressWidth / mWidth
        if (currentColorValue > 255) {
            //由于mProgressWidth有可能大于view的宽度，要保证颜色值不能大于255
            currentColorValue = 255
        }
        if (currentColorValue < 30) {
            //此处是为了限制让其不成为全透明，如果设置为全透明，在最后阶段进度宽度渐变观察不到
            currentColorValue = 30
        }
        //将透明度转换为16进制
        val s = Integer.toHexString(currentColorValue)
        //拼接颜色字符串并转化为颜色值
        val color = Color.parseColor("#" + s + mColor!!.substring(1, mColor!!.length))
        //给画笔设置颜色
        mPaint.color = color
        //使用canvas来画进度条（确实就是画一条线）
        canvas.drawLine(
            (mWidth / 2 - mProgressWidth / 2).toFloat(),
            (mDefaultHeight / 2).toFloat(),
            (mWidth / 2 + mProgressWidth / 2).toFloat(),
            (mDefaultHeight / 2).toFloat(),
            mPaint
        )
    }

}