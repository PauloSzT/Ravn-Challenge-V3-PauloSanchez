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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PersonDetails() {
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        DetailsHead("General Information")
        PersonalInformation("Eye Color", "Blue")
        PersonalInformation("Hair Color", "Blond")
        PersonalInformation("Eye Color", "Fair")
        PersonalInformation("Birth Year", "19BBY")
        DetailsHead("Vehicles")
        Vehicle("Snowspeeder")
        Vehicle("Imperial Speeder Bike")
    }
}

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
            fontSize = 17.sp,
            fontWeight = FontWeight.W700,
            lineHeight = 20.29.sp,
            letterSpacing = 0.25.sp
        )
    }
}

@Composable
fun PersonalInformation(information: String, detail: String) {
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
                text = information,
                fontSize = 17.sp,
                fontWeight = FontWeight.W700,
                color = Color.Gray,
                lineHeight = 20.29.sp,
                letterSpacing = 0.25.sp
            )
            Text(
                text = detail,
                fontSize = 17.sp,
                fontWeight = FontWeight.W700,
                color = Color.Black,
                lineHeight = 20.29.sp,
                letterSpacing = 0.25.sp
            )
        }
        Divider(color = Color.LightGray, thickness = 1.dp)
    }
}

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
                fontWeight = FontWeight.W700,
                color = Color.Gray,
                lineHeight = 20.29.sp,
                letterSpacing = 0.25.sp
            )
        }
        Divider(color = Color.LightGray, thickness = 1.dp)
    }
}

@Preview
@Composable
fun PersonDetailsPreview() {
    MaterialTheme {
        PersonDetails()
    }
}
