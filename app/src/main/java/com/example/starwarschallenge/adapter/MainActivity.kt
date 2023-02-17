package com.example.starwarschallenge.adapter

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.starwarschallenge.R
import com.example.starwarschallenge.ui.details.DetailsView
import com.example.starwarschallenge.ui.home.HomeView
import com.example.starwarschallenge.ui.theme.StarWarsChallengeTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    lateinit var sharedPreferences: SharedPreferences


    fun saveOnSharedPreferences(id: String, value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(id, value)
        editor.apply()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("Star_wars_challenge_app", Context.MODE_PRIVATE)
        viewModel.getData(sharedPreferences)
        window.statusBarColor = resources.getColor(R.color.black)
        setContent {
            StarWarsChallengeTheme {
                val isInDetailView by viewModel.isInDetailView.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if (isInDetailView) {
                        DetailsView(viewModel)
                    } else {
                        HomeView(viewModel = viewModel, callBack = {
                            viewModel.navigateToDetails(it)
                        }, saveFavoriteCallback = { key, value ->
                            saveOnSharedPreferences(key, value)
                        })
                    }
                }
            }
        }
    }
}
