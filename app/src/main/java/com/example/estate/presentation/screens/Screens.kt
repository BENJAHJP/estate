package com.example.estate.presentation.screens

sealed class Screens ( val route: String ) {
    object AudioScreen: Screens("Music")
    object MainScreen: Screens("Main")
    object AnimationScreen: Screens("Animation")
    object VideoScreen: Screens("Video")
}