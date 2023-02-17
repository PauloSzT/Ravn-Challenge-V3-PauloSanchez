package com.example.starwarschallenge.adapter

import CharactersListQuery
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.exception.ApolloException
import com.example.starwarschallenge.models.StarWarsCharacter
import com.example.starwarschallenge.models.mapToStarWarsCharacterList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    val charactersList: MutableStateFlow<List<StarWarsCharacter>> = MutableStateFlow(listOf())
    val isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isErrorState: MutableStateFlow<Boolean> = MutableStateFlow(false)


    val api = StarWarsApi().getApolloClient()

    var nextCursor: String? = null
    init {
        getData()
    }

    fun getData() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val response = api.query(CharactersListQuery(Optional.presentIfNotNull(nextCursor))).execute()
                delay(2000)
                charactersList.value = response.data?.mapToStarWarsCharacterList() ?: listOf()
                nextCursor = response.data?.allPeople?.pageInfo?.endCursor
                isLoading.value = false
            } catch (e: ApolloException) {
                isLoading.value = false
                isErrorState.value = true
            }
        }
    }

}
