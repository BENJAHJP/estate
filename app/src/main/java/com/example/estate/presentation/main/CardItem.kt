package com.example.estate.presentation.main

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class CardItem(
    val color: Color,
    val image: Painter,
    val title: String
)