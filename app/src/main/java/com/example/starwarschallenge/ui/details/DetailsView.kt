package com.example.starwarschallenge.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.starwarschallenge.ui.components.DetailsHead
import com.example.starwarschallenge.ui.components.PersonalInformation
import com.example.starwarschallenge.ui.components.Vehicle


@Composable
fun DetailsView() {
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

@Preview
@Composable
fun DetailsPreview() {
    MaterialTheme {
        DetailsView()
    }
}
