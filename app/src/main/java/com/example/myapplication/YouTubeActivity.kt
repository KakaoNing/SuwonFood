package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView


class YouTubeActivity : YouTubeBaseActivity() {
    var youTubePlayerView: YouTubePlayerView? = null
    var btn: Button? = null
    var listener: YouTubePlayer.OnInitializedListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)
        btn = findViewById(R.id.youtubeBtn)
        youTubePlayerView = findViewById(R.id.youtubeView)
        listener = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                provider: YouTubePlayer.Provider,
                youTubePlayer: YouTubePlayer,
                b: Boolean
            ) {
                youTubePlayer.loadVideo("7rFtdZv4AZY") //
                //https://www.youtube.com/watch?v=NmkYHmiNArc 유투브에서 v="" 이부분이 키에 해당
            }

            override fun onInitializationFailure(
                provider: YouTubePlayer.Provider,
                youTubeInitializationResult: YouTubeInitializationResult
            ) {
            }
        }
        btn!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                youTubePlayerView!! .initialize("",listener)
            }
        })
    }
}