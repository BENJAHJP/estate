package com.example.estate.presentation.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.estate.presentation.animation.AnimationScreen
import com.example.estate.presentation.audio.AudioScreen
import com.example.estate.presentation.main.MainScreen
import com.example.estate.presentation.screens.Screens
import com.example.estate.presentation.video.VideoScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavGraph(
    navHostController: NavHostController
) {
    AnimatedNavHost(
        navController = navHostController,
        startDestination = Screens.MainScreen.route
    ){
        composable(
            Screens.AudioScreen.route,
            enterTransition = {
                when (targetState.destination.route) {
                    navHostController.currentDestination?.route ->
                        slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(300))
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    navHostController.currentDestination?.route ->
                        slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(1000))
                    else -> null
                }
            }
        ){
            AudioScreen()
        }
        composable(
            Screens.MainScreen.route
        ){
            MainScreen(navHostController)
        }
        composable(
            Screens.VideoScreen.route,
            enterTransition = {
                when (targetState.destination.route) {
                    navHostController.currentDestination?.route ->
                        slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(300))
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    navHostController.currentDestination?.route ->
                        slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(1000))
                    else -> null
                }
            }
        ){
            VideoScreen()
        }
        composable(
            Screens.AnimationScreen.route,
            enterTransition = {
                when (targetState.destination.route) {
                    navHostController.currentDestination?.route ->
                        slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(300))
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    navHostController.currentDestination?.route ->
                        slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(1000))
                    else -> null
                }
            }
        ){
            AnimationScreen()
        }
    }
}