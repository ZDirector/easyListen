package com.example.playing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.example.common.bean.searchBean.MusicBean
import com.example.common.utils.FragmentUtil
import com.example.common.utils.MyApplication
import com.example.playing.adapter.PlayListAdapter
import com.example.playing.databinding.FragmentPlayListBinding
import com.example.playing.viewModel.PlayViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PLayListFragment : BottomSheetDialogFragment() {

    companion object {
        private const val TAG = "PLayListFragment"

        fun show(activity: FragmentActivity) {
            FragmentUtil.hideDialog(activity, TAG)
            FragmentUtil.showDialog(
                activity,
                TAG,
                PLayListFragment()
            )
        }
    }

    private lateinit var binding: FragmentPlayListBinding
    private lateinit var viewModel: PlayViewModel
    private lateinit var adapter: PlayListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.PlayListFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.fragment_play_list,
            null, false
        )
        binding.lifecycleOwner = this

        viewModel = MyApplication.getAppViewModel(PlayViewModel::class.java)
        initView()
        subscribeData()
        return binding.root
    }

    private fun initView() {
        adapter = PlayListAdapter(object : PlayListAdapter.OnItemClickListener {
            override fun onItemClick(musicBean: MusicBean) {
                viewModel.setCurMusic(musicBean)
                dismiss()
            }

            override fun removeMusic(position: Int) {
                viewModel.removeMusic(position)
                dismiss()
            }
        })
        binding.rvPlayList.adapter = adapter
    }

    private fun subscribeData() {
        viewModel.musicList.observe(this) {
            adapter.submitList(it)
        }
    }

}