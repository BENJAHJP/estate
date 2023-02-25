package com.example.estate.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.estate.R
import com.example.estate.ui.theme.Blue
import com.example.estate.ui.theme.Purple
import com.example.estate.ui.theme.Red
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navHostController: NavHostController
) {
    var isLoading by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true){
        scope.launch {
            isLoading = true
            delay(2500L)
            isLoading = false
        }
    }
    val items = listOf<CardItem>(
        CardItem(
            color = Blue,
            image = painterResource(id = R.drawable.music),
            title = "Audio"
        ),
        CardItem(
            color = Red,
            image = painterResource(id = R.drawable.video),
            title = "Video"
        ),
        CardItem(
            color = Purple,
            image = painterResource(id = R.drawable.animation),
            title = "Animation"
        )
    )
    Scaffold(
        containerColor = Color.White
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
        ){
            if (isLoading){
                val lottieCompositionSpec by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(
                    R.raw.loading))
                LottieAnimation(
                    composition = lottieCompositionSpec,
                    iterations = Int.MAX_VALUE,
                    alignment = Alignment.Center
                )
            } else {
                LazyColumn(){
                    items(items){ item ->
                        SingleCard(
                            title = item.title,
                            icon = item.image,
                            color = item.color,
                            onClick = {
                                navHostController.navigate(item.title)
                            }
                        )
                    }
                }
            }
        }
    }
}