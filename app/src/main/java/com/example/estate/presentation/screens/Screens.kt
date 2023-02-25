package com.example.estate.presentation.screens

sealed class Screens ( val route: String ) {
    object AudioScreen: Screens("Audio")
    object MainScreen: Screens("Main")
    object AnimationScreen: Screens("Animation")
    object VideoScreen: Screens("Video")
}