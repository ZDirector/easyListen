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
import com.danikula.videocache.CacheListener
import com.danikula.videocache.HttpProxyCacheServer
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
import java.io.File

class VideoFragment :
    BaseFragment<FragmentVideoBinding,VideoFragmentViewModel>(),
    View.OnClickListener,
    Player.Listener, CacheListener {

    override val layoutId = R.layout.fragment_video
    override val variableId = BR.videoFragmentViewModel
    private var videoId  = 0
    private var mVideoPlayer : ExoPlayer? = null
    private lateinit var activityViewModel : VideoViewModel
    private var proxy : HttpProxyCacheServer? = null

    companion object{
        fun newInstance(videoId: Int): VideoFragment {
            val bundle = Bundle()
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
                if (mVideoPlayer != null){
                    mVideoPlayer!!.pause()
                    mVideoPlayer!!.release()
                    mVideoPlayer = null
                }
                requireActivity().finish()
            }
        }
        //把回调函数添加到Activity中
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun initData(savedInstanceState: Bundle?) {
        videoId = arguments?.getInt("videoId") ?: 0
        initView()
        initListener()
        initObserve()
    }

    private fun initView(){
        activityViewModel = ViewModelProvider(requireActivity())[VideoViewModel::class.java]
        mVideoPlayer = ExoPlayer.Builder(MyApplication.context).build()

        viewModel.getVideoData(videoId.toLong())
    }

    private fun initListener(){
        binding.icBack.setOnClickListener(this)
        binding.icThumb.setOnClickListener(this)
        binding.icMore.setOnClickListener(this)
        binding.videoFragment.setOnClickListener(this)
        binding.icFullScreen.setOnClickListener(this)
        if (mVideoPlayer != null){
            mVideoPlayer!!.addListener(this)
        }
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
                binding.videoPlayer.player = mVideoPlayer
                if (lifecycle.currentState == Lifecycle.State.RESUMED && proxy == null){
                    loadVideo()
                }
            }
        }

        lifecycleScope.launch{
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED){
                activityViewModel.videoLoadState.collect{
                    if (mVideoPlayer != null && isCurrent()){
                        LogUtil.d("VideoFragment","$it")
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
                if (mVideoPlayer != null){
                    mVideoPlayer!!.pause()
                    mVideoPlayer!!.release()
                    mVideoPlayer = null
                }
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

    override fun onResume() {
        if (mVideoPlayer != null){

            if (viewModel.mVideoData != null && proxy == null){
                loadVideo()
            }

            binding.icPause.visibility = View.GONE
            activityViewModel.currentExoPlayer = mVideoPlayer
            if (isCurrent()){
                activityViewModel.onPlayerReady()
            }
        }
        super.onResume()
    }

    override fun onPause() {
        if (mVideoPlayer != null){
            mVideoPlayer!!.pause()
            binding.icPause.visibility = View.VISIBLE
        }
        super.onPause()
    }

    override fun onStop() {
        if (mVideoPlayer != null){
            mVideoPlayer!!.stop()
            proxy = null
        }
        super.onStop()
    }

    override fun onDestroyView() {
        if (mVideoPlayer != null){
            mVideoPlayer!!.release()
            mVideoPlayer = null
            proxy?.unregisterCacheListener(this)
        }
        super.onDestroyView()
    }
    
    private fun isCurrent() : Boolean{
        return activityViewModel.currentExoPlayer == mVideoPlayer
    }

    private fun loadVideo(){
        proxy = activityViewModel.proxy
        proxy!!.registerCacheListener(this,viewModel.mVideoData!!.url)
        val mediaItem = MediaItem.fromUri(proxy!!.getProxyUrl(viewModel.mVideoData!!.url))
        mVideoPlayer!!.setMediaItem(mediaItem)
        mVideoPlayer!!.prepare()
        binding.videoPb.max = if (mVideoPlayer!!.duration > 0) mVideoPlayer!!.duration.toInt() else viewModel.mVideoData!!.duration.toInt()
        activityViewModel.currentVideoData = viewModel.mVideoData
        if (proxy!!.isCached(viewModel.mVideoData!!.url)) binding.videoPb.secondaryProgress = binding.videoPb.max
    }

    override fun onCacheAvailable(cacheFile: File?, url: String?, percentsAvailable: Int) {
        if (viewModel.mVideoData!!.url == url){
            LogUtil.d("VideoViewModel","当前进度：${binding.videoPb.progress}  " + "缓存进度：${(percentsAvailable / 100.0 * binding.videoPb.max).toInt()}")
            binding.videoPb.secondaryProgress = (percentsAvailable / 100.0 * binding.videoPb.max).toInt()
        }
    }
}