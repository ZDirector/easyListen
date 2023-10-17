package com.example.video.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.SeekBar
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.common.baseui.BaseFragment
import com.example.common.utils.LogUtil
import com.example.common.utils.MyApplication
import com.example.common.utils.showToast
import com.example.video.BR
import com.example.video.R
import com.example.video.databinding.FragmentVideoBinding
import com.example.video.util.ProgressUtil
import com.example.video.util.VideoLoadState
import com.example.video.viewmodel.VideoFragmentViewModel
import com.example.video.viewmodel.VideoViewModel
import com.google.android.exoplayer2.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class VideoFragment :
    BaseFragment<FragmentVideoBinding,VideoFragmentViewModel>(),
    View.OnClickListener,
    Player.Listener{

    override val layoutId = R.layout.fragment_video
    override val variableId = BR.videoFragmentViewModel
    private var videoId  = 0
    private var position = 0
    private var mVideoPlayer : ExoPlayer? = null
    private lateinit var activityViewModel : VideoViewModel
    private var isReload = true

    companion object{
        fun newInstance(position: Int,videoId: Int): VideoFragment {
            val bundle = Bundle()
            bundle.putInt("position",position)
            bundle.putInt("videoId",videoId)
            val fragment = VideoFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        }
        //把回调函数添加到Activity中
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun initData(savedInstanceState: Bundle?) {
        position = requireArguments().getInt("position")
        videoId = requireArguments().getInt("videoId")
        initView()
        initListener()
        initObserve()
    }

    private fun initView(){
        activityViewModel = ViewModelProvider(requireActivity())[VideoViewModel::class.java]
        viewModel.getVideoData(videoId.toLong())
    }

    private fun initListener(){
        binding.icBack.setOnClickListener(this)
        binding.icThumb.setOnClickListener(this)
        binding.icMore.setOnClickListener(this)
        binding.videoFragment.setOnClickListener(this)
        binding.icFullScreen.setOnClickListener(this)
        binding.videoPb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser){
                    val currentProgressText =
                        ProgressUtil.toTimeText(binding.videoPb.progress.toLong()) +
                                " / " +
                                ProgressUtil.toTimeText(binding.videoPb.max.toLong())
                    binding.videoCurrentProgressText.text = currentProgressText
                    binding.videoCurrentProgressText.visibility = View.VISIBLE
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                binding.videoCurrentProgressText.visibility = View.GONE
                if (mVideoPlayer != null){
                    mVideoPlayer!!.seekTo(binding.videoPb.progress.toLong())
                }
            }

        })
    }

    private fun initObserve(){
        viewModel.videoData.observe(this){
            binding.thumbText.text = ProgressUtil.getFormatString(it.likedCount)
            binding.commentText.text = ProgressUtil.getFormatString(it.commentCount)
            binding.shareText.text = ProgressUtil.getFormatString(it.shareCount)
            Glide.with(binding.singerCover)
                .load(it.cover)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .override(120,120)
                .into(binding.singerCover)
            binding.singerName.text = it.artistName
            binding.videoName.text = it.name
            if (it.desc != "") binding.videoIntroduce.text = it.desc
            else binding.icMore.visibility = View.GONE
            binding.videoReleaseDate.text = it.publishTime
            if (it.liked) binding.icLike.setImageResource(R.drawable.ic_video_liked)
            binding.videoNameAndSinger.text = it.name + " - " + it.artistName

            if (mVideoPlayer != null){
                if (lifecycle.currentState == Lifecycle.State.RESUMED){
                    loadVideo()
                }
            }
        }

        activityViewModel.currentPage.observe(this){
            if (it - 1 > position || it + 1 < position ){
                if (mVideoPlayer != null){
                    viewModel.lastProcess = mVideoPlayer!!.currentPosition
                    binding.videoPlayer.player = null
                    mVideoPlayer!!.stop()
                    mVideoPlayer!!.removeListener(this)
                    mVideoPlayer = null
                    isReload = true
                }
            }else{
                if (mVideoPlayer == null){
                    when (position) {
                        it - 1 -> mVideoPlayer = activityViewModel.previewExoPlayer
                        it -> mVideoPlayer = activityViewModel.currentExoPlayer
                        it + 1 -> mVideoPlayer = activityViewModel.nextExoPlayer
                    }
                    binding.videoPlayer.player = mVideoPlayer
                    mVideoPlayer!!.addListener(this)
                }
            }
        }

        lifecycleScope.launch{
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED){
                activityViewModel.videoLoadState.collect{
                    if (mVideoPlayer != null && isCurrent()){
                        LogUtil.d("VideoFragment","Player : $mVideoPlayer$it")
                        when(it){
                            is VideoLoadState.Playing ->{
                                binding.videoPbLoading.hide()
                                binding.icPause.visibility = View.GONE
                                mVideoPlayer!!.play()
                            }
                            is VideoLoadState.Pause ->{
                                binding.videoPbLoading.hide()
                                binding.icPause.visibility = View.VISIBLE
                                mVideoPlayer!!.pause()
                            }
                            is VideoLoadState.Loading ->{
                                binding.videoPbLoading.show()
                            }
                            is VideoLoadState.Error ->{
                                binding.videoPbLoading.hide()
                                showToast("抱歉，网络状况不佳请稍后再试！")
                                val mediaItem = MediaItem.fromUri(viewModel.mVideoData!!.url)
                                mVideoPlayer!!.setMediaItem(mediaItem)
                                mVideoPlayer!!.prepare()
                                activityViewModel.onPlayerPause()
                            }
                        }
                    }
                }
            }
        }

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED){
                activityViewModel.progressFlow.collectLatest {
                    if (mVideoPlayer != null && mVideoPlayer!!.isPlaying){
                        binding.videoPb.progress = it.toInt()
                    }
                }
            }
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ic_back ->{
                requireActivity().finish()
            }
            R.id.ic_thumb ->{
                val anim = AnimationUtils.loadAnimation(MyApplication.context,R.anim.anim_like)
                if (viewModel.mVideoData!!.liked){
                    binding.icThumb.setImageResource(R.drawable.ic_video_thumb)
                    binding.thumbText.text = ProgressUtil.getFormatString(viewModel.mVideoData!!.likedCount - 1)
                    binding.icThumb.startAnimation(anim)
                    viewModel.mVideoData!!.liked = false
                }else{
                    binding.icThumb.setImageResource(R.drawable.ic_video_thumbed)
                    binding.thumbText.text = ProgressUtil.getFormatString(viewModel.mVideoData!!.likedCount + 1)
                    binding.icThumb.startAnimation(anim)
                    viewModel.mVideoData!!.liked = true
                }
            }
            R.id.ic_more ->{
                if (viewModel.isMore){
                    binding.icMore.setImageResource(R.drawable.ic_video_more)
                    binding.videoIntroduce.visibility = View.GONE
                    viewModel.isMore = false
                }else{
                    binding.icMore.setImageResource(R.drawable.ic_video_mored)
                    binding.videoIntroduce.visibility = View.VISIBLE
                    viewModel.isMore = true
                }
            }
            R.id.ic_full_screen ->{

            }
            else ->{
                if (mVideoPlayer != null){
                    if (mVideoPlayer!!.isPlaying){
                        if (isCurrent()){
                            activityViewModel.onPlayerPause()
                        }
                    }else{
                        if (isCurrent()){
                            if (mVideoPlayer!!.playbackState == Player.STATE_ENDED){
                                mVideoPlayer!!.seekTo(0)
                            }
                            activityViewModel.onPlayerReady()
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        if (viewModel.mVideoData != null && isReload) loadVideo()
        super.onResume()
    }

    override fun onPlayerError(error: PlaybackException) {
        super.onPlayerError(error)
        if (isCurrent()){
            activityViewModel.onPlayerError(error.errorCode)
        }
    }

    override fun onPlaybackStateChanged(playbackState: Int) {
        super.onPlaybackStateChanged(playbackState)
        when(playbackState) {
            Player.STATE_BUFFERING -> {
                if (isCurrent()){
                    activityViewModel.onPlayerLoading()
                }
            }
            Player.STATE_READY -> {
                if (isCurrent()){
                    activityViewModel.onPlayerReady()
                }
            }
            Player.STATE_ENDED ->{
                if (isCurrent()){
                    activityViewModel.onPlayerPause()
                }
            }
            else -> {}
        }
    }

    private fun isCurrent() : Boolean{
        return activityViewModel.currentExoPlayer == mVideoPlayer
    }

    private fun loadVideo(){
        isReload = false
        val mediaItem = MediaItem.fromUri(viewModel.mVideoData!!.url)
        mVideoPlayer!!.setMediaItem(mediaItem)
        mVideoPlayer!!.prepare()
        mVideoPlayer!!.seekTo(viewModel.lastProcess)
        binding.videoPb.max = if (mVideoPlayer!!.duration > 0) mVideoPlayer!!.duration.toInt() else viewModel.mVideoData!!.duration.toInt()
    }
}