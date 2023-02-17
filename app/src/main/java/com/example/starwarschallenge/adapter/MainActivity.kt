package com.example.starwarschallenge.adapter

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                        })
                    }
                }
            }
        }
    }
}
