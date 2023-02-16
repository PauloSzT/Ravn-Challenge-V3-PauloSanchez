package com.example.starwarschallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starwarschallenge.R

@Composable
fun LoadingRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(
                R.drawable.spinner
            ),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(16.dp)
        )
        Text(
            text = "Loading",
            modifier = Modifier.padding(start = 10.dp),
            fontSize = 17.sp,
            fontWeight = FontWeight.W700,
            lineHeight = 20.29.sp,
            letterSpacing = 0.25.sp,
            color = Color.Gray

        )
    }
}

@Preview
@Composable
fun LoadingRowPreview() {
    MaterialTheme() {
        Row(
            modifier = Modifier
                .width(375.dp)
                .height(50.dp),
        ) {
            LoadingRow()
        }
    }
}
