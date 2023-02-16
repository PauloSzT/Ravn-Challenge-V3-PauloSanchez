package com.example.starwarschallenge.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FailedLoading() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Failed to Load Data",
            color = Color.Red,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun FailedLoginPreview() {
    MaterialTheme {
        FailedLoading()
    }
}
