package com.example.starwarschallenge

import androidx.lifecycle.ViewModel
import com.example.starwarschallenge.mocks.charactersListMock
import com.example.starwarschallenge.models.StarWarsCharacter
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivityViewModel: ViewModel() {
    val charactersList: MutableStateFlow<List<StarWarsCharacter>> = MutableStateFlow(
        charactersListMock
    )
}
