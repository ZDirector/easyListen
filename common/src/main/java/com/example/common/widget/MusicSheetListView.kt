package com.example.common.widget

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.MainThread
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.common.bean.MusicSheet
import com.example.common.utils.dp2px


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
        setPadding(16.dp2px, 8.dp2px, 16.dp2px, 8.dp2px)
        textView = TextView(context).apply {
            setPadding(2.dp2px, 4.dp2px, 0, 4.dp2px)
            layoutParams = LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
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
     * 上方 [TextView] 文字内容
     * */
    var text: CharSequence
        @MainThread get() = textView.text
        @MainThread set(value) {
            textView.text = value
        }

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

        private class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val imageView: ImageView = view.findViewWithTag(IMAGE_VIEW_TAG)
            val textView: TextView = view.findViewWithTag(TEXT_VIEW_TAG)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LinearLayoutCompat(parent.context).apply {
                    orientation = VERTICAL
                    setPadding(2.dp2px, 0, 2.dp2px, 0)
                    layoutParams = LayoutParams(
                        84.dp2px,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    addView(
                        ImageView(context).apply {
                            layoutParams = LayoutParams(80.dp2px, 80.dp2px)
                            tag = IMAGE_VIEW_TAG
                        }
                    )
                    addView(
                        TextView(context).apply {
                            setPadding(2.dp2px, 4.dp2px, 2.dp2px, 0)
                            layoutParams = LayoutParams(
                                84.dp2px,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            )
                            maxLines = 2
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
            }
        }

        override fun getItemCount(): Int = musicSheet.size

    }

}