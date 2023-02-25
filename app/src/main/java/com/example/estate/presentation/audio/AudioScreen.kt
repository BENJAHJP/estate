package com.example.estate.presentation.audio

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.estate.R
import com.example.estate.ui.theme.BlackSurface
import com.example.estate.ui.theme.Blue

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AudioScreen() {
    var start by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val mediaPlayer: MediaPlayer = MediaPlayer.create(context, R.raw.animation)

    Scaffold() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
                .background(color = Color.White)
        ) {
            ElevatedCard(
                colors = CardDefaults.elevatedCardColors(
                    containerColor = Blue
                ),
                modifier = Modifier
                    .padding(20.dp)
                    .height(400.dp)
                    .fillMaxWidth()
                ,
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 10.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                    ,
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier.size(200.dp),
                        painter = painterResource(id = R.drawable.music),
                        contentDescription = "music"
                    )
                    if (!start){
                        IconButton(
                            onClick = {
                                mediaPlayer.start()
                                start = !start
                            }
                        ) {
                            Icon(
                                modifier = Modifier.size(50.dp),
                                tint = Color.White,
                                painter = painterResource(id = R.drawable.play),
                                contentDescription = "start") }
                    } else {
                        IconButton(onClick = {
                            mediaPlayer.pause()
                            start = !start
                        }) {
                            Icon(
                                modifier = Modifier.size(50.dp),
                                tint = Color.White,
                                painter = painterResource(id = R.drawable.pause),
                                contentDescription = "stop"
                            )
                        }
                    }
                }
            }
        }
    }
}