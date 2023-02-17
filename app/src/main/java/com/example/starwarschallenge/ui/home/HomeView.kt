package com.example.starwarschallenge.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.starwarschallenge.adapter.MainActivityViewModel
import com.example.starwarschallenge.ui.components.CharacterRow
import com.example.starwarschallenge.ui.components.FailedLoading
import com.example.starwarschallenge.ui.components.Header
import com.example.starwarschallenge.ui.components.LoadingRow

@Composable
fun HomeView(
    viewModel: MainActivityViewModel,
    callBack: (String) -> Unit
) {
    val charactersList by viewModel.charactersList.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val isErrorState by viewModel.isErrorState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Header(hasBackIcon = false, title = "People of Star Wars") {}
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            if (!isErrorState) {
                charactersList.forEach { character ->
                    CharacterRow(
                        id = character.id,
                        name = character.name,
                        description = "${character.race} from ${character.homePlanet}",
                        callBack = callBack
                    )
                }
                if (isLoading) {
                    LoadingRow()
                }
            } else {
                FailedLoading()
            }
        }
    }
}
