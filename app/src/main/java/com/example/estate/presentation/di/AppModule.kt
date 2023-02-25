package com.example.estate.presentation.di

import android.app.Application
import android.media.MediaPlayer
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.example.estate.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    @ViewModelScoped
    fun provideVideoPlayer(app: Application): Player{
        return ExoPlayer.Builder(app)
            .build()
    }

    @Provides
    @ViewModelScoped
    fun provideMediaPlayer(app: Application): MediaPlayer{
        return MediaPlayer.create(app, R.raw.animation)
    }
}