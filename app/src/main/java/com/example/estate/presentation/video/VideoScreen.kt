package com.example.estate.presentation.video

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.datasource.RawResourceDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.example.estate.R
import com.example.estate.ui.theme.BlackSurface

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType")
@Composable
fun VideoScreen() {
    val context = LocalContext.current
    val uri: Uri = RawResourceDataSource.buildRawResourceUri(R.raw.video)
    val player: Player = ExoPlayer.Builder(context).build()
    player.setMediaItem(MediaItem.fromUri(uri))
    player.prepare()
    val playerView = PlayerView(context)
    playerView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM

    Scaffold() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = BlackSurface)
        ) {
            AndroidView(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                factory = {
                    PlayerView(context).also {
                        it.player = player
                    }
                },
            )
        }
    }
}
