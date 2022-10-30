package com.example.homepage.playSquare

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.homepage.R
import com.example.homepage.databinding.ActivitySquareDetailBinding
import kotlin.math.abs


class SquareDetailActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySquareDetailBinding
    private var mMainColor:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_square_detail)
        mBinding.apply {
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.adapter = RvAdapter()
            tvTitleBar.bringToFront()
            setToolBar()
        }
        val draw1 = this.resources.getDrawable(com.example.homepage.R.drawable.star)
        val bitmap = drawableToBitmap(draw1)
        val builder = bitmap?.let { Palette.from(it) }
        val palette = builder?.generate()
        if (palette != null) {
            mMainColor = palette.getDarkVibrantColor(Color.WHITE)

        }
        initColor()
        setImageView()
    }

    private fun initColor(){
        mBinding.apply {
            toolbar.setBackgroundColor(mMainColor)
            clPlaylist.setBackgroundColor(mMainColor)
            appBar.setBackgroundColor(mMainColor)
        }
    }

    private fun setToolBar() {
        mBinding.apply {
            setSupportActionBar(toolbar)
            toolbarLayout.isTitleEnabled = false
            toolbarLayout.expandedTitleGravity = Gravity.CENTER//设置展开后标题的位置
            toolbarLayout.collapsedTitleGravity = Gravity.CENTER//设置收缩后标题的位置
            toolbarLayout.setExpandedTitleColor(Color.WHITE)//设置展开后标题的颜色
            toolbarLayout.setCollapsedTitleTextColor(Color.WHITE)//设置收缩后标题的颜色
            appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
                val offset = abs(verticalOffset)
                toolbar.setBackgroundColor(
                    changeAlpha(
                        resources.getColor(R.color.blue),
                        abs(verticalOffset * 1.0f) / appBarLayout.totalScrollRange
                    )
                )
                clPlaylist.alpha =
                    (appBarLayout.totalScrollRange / 2 - offset * 1.0f) / (appBarLayout.totalScrollRange / 2)
                /**
                 * 当前最大高度便宜值除以2 在减去已偏移值 获取浮动 先显示在隐藏
                 */

                if (offset < appBarLayout.totalScrollRange / 2) {
                    tvTitleBar.alpha =
                        (appBarLayout.totalScrollRange / 2 - offset * 1.0f) / (appBarLayout.totalScrollRange / 2)
                    toolbar.title = ""
                    toolbar.alpha =
                        (appBarLayout.totalScrollRange / 2 - offset * 1.0f) / (appBarLayout.totalScrollRange / 2)
                    clPlaylist.alpha =
                        (appBarLayout.totalScrollRange / 2 - offset * 1.0f) / (appBarLayout.totalScrollRange / 2)
                    /**
                     * 从最低浮动开始渐显 当前 Offset就是  appBarLayout.getTotalScrollRange() / 2
                     * 所以 Offset - appBarLayout.getTotalScrollRange() / 2
                     */
                } else if (offset > appBarLayout.totalScrollRange / 2) {
                    val alpha: Float =
                        (offset - appBarLayout.totalScrollRange / 2) * 1.0f / (appBarLayout.totalScrollRange / 2)

//                    toolbar.alpha = alpha
                    clPlaylist.alpha = alpha
//                    toolbar.setNavigationIcon(R.mipmap.image_left)
                    toolbar.title = "最动听的歌单"
                    toolbar.alpha = alpha
                    toolbar.setBackgroundColor(mMainColor)
                }
            }
        }
    }

    /**
     * 根据百分比改变颜色透明度
     */
    private fun changeAlpha(color: Int, fraction: Float): Int {
        val alpha = (Color.alpha(color) * fraction).toInt()
        return Color.argb(alpha, 0, 128, 0)
    }


    private fun setImageView(){
        mBinding.apply {
            //Glide设置图片圆角角度
            val roundedCorners = RoundedCorners(20)
            //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
            val options = RequestOptions.bitmapTransform(roundedCorners)

            Glide.with(ibPlaylist.context)
                .load(R.drawable.star) //.placeholder(R.drawable.ic_default_image)
                .apply(options)
                .into(ibPlaylist)
        }
    }

    private fun drawableToBitmap(drawable: Drawable): Bitmap? // drawable 转换成bitmap
    {
        val width = drawable.intrinsicWidth // 取drawable的长宽
        val height = drawable.intrinsicHeight
        val config =
            if (drawable.opacity != PixelFormat.OPAQUE) Bitmap.Config.ARGB_8888 else Bitmap.Config.RGB_565 // 取drawable的颜色格式
        val bitmap = Bitmap.createBitmap(width, height, config) // 建立对应bitmap
        val canvas = Canvas(bitmap) // 建立对应bitmap的画布
        drawable.setBounds(0, 0, width, height)
        drawable.draw(canvas) // 把drawable内容画到画布中
        return bitmap
    }

}

class RvAdapter : Adapter<RvAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.foot_layout, null)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 30
    }

}