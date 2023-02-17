package com.example.starwarschallenge.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
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
fun Vehicle(vehicle: String) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp)
                .height(48.dp)
                .background(color = Color.Transparent),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = vehicle,
                fontSize = 17.sp,
                style = MaterialTheme.typography.h1,
                fontWeight = FontWeight.W700,
                color = Color.Gray,
                lineHeight = 20.29.sp,
                letterSpacing = 0.25.sp
            )
        }
        Divider(color = Color.LightGray, thickness = 1.dp)
    }
}
