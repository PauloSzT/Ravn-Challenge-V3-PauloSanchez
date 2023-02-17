package com.example.starwarschallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.starwarschallenge.R

val SFProDisplay = FontFamily(
    Font(R.font.sfprodisplayregular),
    Font(R.font.sfprodisplaybold, FontWeight.Bold)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    )
)
