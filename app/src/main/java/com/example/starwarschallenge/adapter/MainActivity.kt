package com.example.starwarschallenge.adapter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.apollographql.apollo3.api.Adapter
import com.example.starwarschallenge.ui.components.CharacterRow
import com.example.starwarschallenge.ui.components.Header
import com.example.starwarschallenge.ui.theme.StarWarsChallengeTheme


class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val charactersList by viewModel.charactersList.collectAsState()
            StarWarsChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                Column {
                    Header(hasBackIcon = false, title = "People of Star Wars") {}
                    charactersList.forEach{ character ->
                        CharacterRow(id = character.id , name = character.name , description = "${character.race} from ${character.homePlanet}" )
                    }

                }
                }
            }
        }
    }
}
