package com.example.estate.presentation.animation

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.datasource.RawResourceDataSource
import com.example.estate.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimationViewModel @Inject constructor(
    val player: Player
): ViewModel(){
    private val uri: Uri = RawResourceDataSource.buildRawResourceUri(R.raw.animation)

    init {
        player.setMediaItem(MediaItem.fromUri(uri))
        player.prepare()
    }

    override fun onCleared() {
        super.onCleared()
        player.release()
    }
}