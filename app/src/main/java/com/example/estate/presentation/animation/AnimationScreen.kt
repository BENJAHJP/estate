package com.example.estate.presentation.animation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.media3.ui.PlayerView
import com.example.estate.ui.theme.BlackSurface

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AnimationScreen(
    viewModel: AnimationViewModel = hiltViewModel()
) {
    Scaffold(
        containerColor = Color.White
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AndroidView(
                modifier = Modifier.fillMaxWidth()
                    .aspectRatio(16 / 9f),
                factory = { context ->
                    PlayerView(context).also {
                        it.player = viewModel.player
                    }
                },
            )
        }
    }
}
