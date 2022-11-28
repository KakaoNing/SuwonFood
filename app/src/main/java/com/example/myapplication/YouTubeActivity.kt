package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.myapplication.YoutubeActivity.Companion.TAG
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener
import com.google.android.youtube.player.YouTubePlayerView


//YouTubeBaseActivity를 상속받게끔 설정한다.
class YoutubeActivity : YouTubeBaseActivity() {
    //객체 선언
    var playerView: YouTubePlayerView? = null
    var player: YouTubePlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)
        initPlayer()
        val btnPlay = findViewById<Button>(R.id.button1)
        btnPlay.setOnClickListener { playVideo() }
    }

    private fun playVideo() {
        if (player != null) {
            if (player!!.isPlaying) {
                player!!.pause()
            }
            player!!.cueVideo(YoutubeActivity.Companion.videoId)
        }
    }

    //유튜브 플레이어 메서드
    private fun initPlayer() {
        ///playerView = findViewById(R.id.playerView)
        playerView!!.initialize(
            YoutubeActivity.Companion.API_KEY,
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider,
                    youTubePlayer: YouTubePlayer,
                    b: Boolean
                ) {
                    player = youTubePlayer
                    player!!.setPlayerStateChangeListener(object : PlayerStateChangeListener {
                        override fun onLoading() {}
                        override fun onLoaded(id: String) {
                            Log.d(YoutubeActivity.Companion.TAG, "onLoaded: $id")
                            player!!.play()
                        }

                        override fun onAdStarted() {}
                        override fun onVideoStarted() {}
                        override fun onVideoEnded() {}
                        override fun onError(errorReason: YouTubePlayer.ErrorReason) {
                            Log.d(YoutubeActivity.Companion.TAG, "onError: $errorReason")
                        }
                    })
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider,
                    youTubeInitializationResult: YouTubeInitializationResult
                ) {
                }
            })
    }

    companion object {
        //유튜브 API KEY와 동영상 ID 변수 설정
        private const val API_KEY = "AIzaSyAM5oDhdgB0MF-a7WhASPHSIGiOOiSz-Yg"

        //https://www.youtube.com/watch?v=6egQkFx7UkM ▶ 유튜브 동영상 v= 다음 부분이 videoId
        private const val videoId = "6egQkFx7UkM"

        //logcat 사용 설정
        private const val TAG = "YoutubeActivity"
    }
}