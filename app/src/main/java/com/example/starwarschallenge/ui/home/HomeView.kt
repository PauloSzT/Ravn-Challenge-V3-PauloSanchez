package com.example.starwarschallenge.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.starwarschallenge.ui.components.FailedLoading
import com.example.starwarschallenge.ui.components.Header

@Composable
fun HomeView() {
    Column() {
        Header(hasBackIcon = false, title = "Luke Skywalker") {}
        Row {
//            CharacterRow()
        }
        //LoadingRow()


    }
}

@Preview
@Composable
fun HomeViewPreview() {
    MaterialTheme {
        HomeView()
    }
}
