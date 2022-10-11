package com.example.common.widget

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.RippleDrawable
import android.os.Build
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.MainThread
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.cardview.widget.CardView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.common.R
import com.example.common.bean.MusicSheet
import com.example.common.utils.dp2px
import com.example.common.utils.isDarkMode

/**
 * 横向滑动显示歌单列表，其中重要的函数/属性有 [text] ,  [setMusicSheet] ,
 * [setOnItemClickListener]
 * */
class MusicSheetListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(
    context, attrs, defStyleAttr
), Observer<List<MusicSheet>> {

    private lateinit var musicSheet: LiveData<List<MusicSheet>>

    private val textView: TextView
    private val recyclerView: RecyclerView

    private val musicSheetList = mutableListOf<MusicSheet>()
    private val musicSheetAdapter: MusicSheetAdapter = MusicSheetAdapter(musicSheetList)

    init {
        orientation = VERTICAL
        textView = TextView(context).apply {
            setPadding(16.dp2px, 4.dp2px, 16, 4.dp2px)
            layoutParams = LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            textSize = 20f
            paint.isFakeBoldText = true
            setTextColor(if (!context.isDarkMode) Color.BLACK else Color.WHITE)
        }
        recyclerView = RecyclerView(context).apply {
            setPadding(0, 0, 0, 4.dp2px)
            layoutParams = LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            adapter = musicSheetAdapter
        }
        addView(textView)
        addView(recyclerView)
    }

    /**
     * 设置上方 [TextView] 文字内容
     * */
    var text: CharSequence
        @MainThread get() = textView.text
        @MainThread set(value) {
            textView.text = value
        }

    /**
     * 设置歌单数据源
     * */
    @MainThread
    fun setMusicSheet(
        lifecycleOwner: LifecycleOwner,
        sheet: LiveData<List<MusicSheet>>
    ) {
        if (this::musicSheet.isInitialized) {
            musicSheet.removeObserver(this)
            val size = musicSheetList.size
            musicSheetList.clear()
            musicSheetAdapter.notifyItemRangeRemoved(0, size)
        }
        musicSheet = sheet
        musicSheet.observe(lifecycleOwner, this)
    }

    /**
     * 设置列表的点击事件
     * */
    @MainThread
    fun setOnItemClickListener(listener: (MusicSheet, Int) -> Unit) {
        musicSheetAdapter.setOnItemClickListener(listener)
    }

    override fun onChanged(t: List<MusicSheet>?) {
        t ?: return
        musicSheetList.addAll(t)
        musicSheetAdapter.notifyItemRangeInserted(0, musicSheetList.size)
    }

    private class MusicSheetAdapter(
        private val musicSheet: List<MusicSheet>
    ) : RecyclerView.Adapter<MusicSheetAdapter.ViewHolder>() {

        companion object {
            private const val IMAGE_VIEW_TAG = "image_view_tag"
            private const val TEXT_VIEW_TAG = "text_view_tag"
        }

        private var onItemClickListener: ((MusicSheet, Int) -> Unit)? = null

        fun setOnItemClickListener(listener: (MusicSheet, Int) -> Unit) {
            onItemClickListener = listener
        }

        private class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val imageView: ImageView = view.findViewWithTag(IMAGE_VIEW_TAG)
            val textView: TextView = view.findViewWithTag(TEXT_VIEW_TAG)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LinearLayoutCompat(parent.context).apply {
                    orientation = VERTICAL
                    setPadding(8.dp2px, 0, 8.dp2px, 0)
                    layoutParams = LayoutParams(
                        120.dp2px,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    addView(
                        CardView(context).apply {
                            layoutParams = LayoutParams(104.dp2px, 104.dp2px)
                            addView(
                                ImageView(context).apply {
                                    layoutParams = LayoutParams(104.dp2px, 104.dp2px)
                                    scaleType = ImageView.ScaleType.CENTER_INSIDE
                                    val rippleDrawable = RippleDrawable(
                                        ColorStateList.valueOf(Color.GRAY),
                                        null,
                                        null
                                    )
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        foreground = rippleDrawable
                                    } else {
                                        background = rippleDrawable
                                    }
                                    tag = IMAGE_VIEW_TAG
                                }
                            )
                            cardElevation = 2.dp2px.toFloat()
                            @Suppress("Deprecation")
                            setCardBackgroundColor(context.resources.getColor(R.color.theme_light))
                            radius = 16.dp2px.toFloat()
                        }
                    )
                    addView(
                        TextView(context).apply {
                            setPadding(4.dp2px, 4.dp2px, 4.dp2px, 0)
                            layoutParams = LayoutParams(
                                96.dp2px,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            )
                            maxLines = 2
                            setLineSpacing(14f, 0.5f)
                            ellipsize = TextUtils.TruncateAt.END
                            tag = TEXT_VIEW_TAG
                        }
                    )
                }
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            with(holder) {
                imageView.load(musicSheet[position].img)
                textView.text = musicSheet[position].name
                itemView.setOnClickListener {
                    onItemClickListener?.invoke(musicSheet[position], position)
                }
            }
        }

        override fun getItemCount(): Int = musicSheet.size

    }

}