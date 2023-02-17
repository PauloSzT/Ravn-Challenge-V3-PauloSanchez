package com.example.starwarschallenge.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.starwarschallenge.adapter.MainActivityViewModel
import com.example.starwarschallenge.ui.components.DetailsHead
import com.example.starwarschallenge.ui.components.Header
import com.example.starwarschallenge.ui.components.PersonalInformation
import com.example.starwarschallenge.ui.components.Vehicle


@Composable
fun DetailsView(
    viewModel: MainActivityViewModel
) {
    val character by viewModel.detailCurrentCharacter.collectAsState()
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Header(hasBackIcon = true, title = character?.name ?: "Undefined") {
            viewModel.navigateBack()
        }
        DetailsHead("General Information")
        PersonalInformation("Eye Color", character?.eyeColor ?: "Undefined")
        PersonalInformation("Hair Color", character?.hairColor ?: "Undefined")
        PersonalInformation("Skin Color", character?.skinColor ?: "Undefined")
        PersonalInformation("Birth Year", character?.birthYear ?: "Undefined")
        DetailsHead("Vehicles")
        character?.vehicles?.forEach {
            Vehicle(it)
        }
    }
}
