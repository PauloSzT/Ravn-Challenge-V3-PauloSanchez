package com.example.starwarschallenge.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailsHead(title: String) {
    Row(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                bottom = 8.dp
            ),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = title,
            color = Color.Black,
            fontSize = 17.sp,
            style = MaterialTheme.typography.h1,
            fontWeight = FontWeight.W700,
            lineHeight = 20.29.sp,
            letterSpacing = 0.25.sp
        )
    }
}
