package com.example.estate.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.estate.R
import com.example.estate.ui.theme.BlackSurface
import com.example.estate.ui.theme.Blue
import com.example.estate.ui.theme.Purple
import com.example.estate.ui.theme.Red

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navHostController: NavHostController
) {
    val items = listOf<CardItem>(
        CardItem(
            color = Blue,
            image = painterResource(id = R.drawable.music),
            title = "Music"
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
        containerColor = BlackSurface
    ) {
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