package com.example.video_player_app

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import androidx.media3.ui.PlayerView
import com.google.common.util.concurrent.MoreExecutors

class TopFragment : Fragment() {

    private var player: MediaController?=null
    private var playerView: PlayerView? = null
    private var videoUrl: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_top, container, false)
        playerView = view.findViewById(R.id.player_view)
        videoUrl = arguments?.getString("Link")
        initializePlayer(videoUrl.toString())
        return view
    }

    private fun initializePlayer(videoUrl: String) {
        val sessionToken = SessionToken(requireContext(), ComponentName(requireContext(), PlayBackService::class.java))
        val controllerFuture = MediaController.Builder(requireContext(), sessionToken).buildAsync()

        controllerFuture.addListener({
            player=controllerFuture.get()
            playerView?.player =player
            val videoUri=Uri.parse(videoUrl)
            val mediaItem = MediaItem.Builder()
                .setMediaId("media-1")
                .setUri(videoUri)
                .setMediaMetadata(
                    MediaMetadata.Builder()
                        .setArtist("David Bowie")
                        .setTitle("Heroes")
                        .build()
                )
                .build()



            player?.setMediaItem(mediaItem)

            player?.prepare()
            player?.playWhenReady
        }, MoreExecutors.directExecutor())
    }

    override fun onDestroy() {
        player?.release()
        super.onDestroy()
    }
}
