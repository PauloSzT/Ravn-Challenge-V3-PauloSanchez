package com.example.starwarschallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
fun Header(
    hasBackIcon: Boolean,
    title: String,
    callBack: () -> Unit
) {
    Box(modifier = Modifier.background(color = Color.Black)) {
        if (hasBackIcon) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .padding(start = 23.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(
                        R.drawable.union
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.03.dp)
                        .clickable { callBack() }
                )
            }
        }
        Row(
            modifier = Modifier
                .height(54.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 17.sp,
                style = MaterialTheme.typography.h1,
                fontWeight = FontWeight.W700,
                lineHeight = 20.29.sp,
                letterSpacing = 0.25.sp
            )

        }

    }
}

@Preview
@Composable
fun HeaderPreviewNoIcon() {
    MaterialTheme() {
        Header(
            false,
            "People of Star Wars"
        ) {}
    }

}

@Preview
@Composable
fun HeaderPreviewIcon() {
    MaterialTheme() {
        Header(
            true,
            "Luke Skywalker"
        ) {}
    }
}
