package com.example.starwarschallenge.adapter

import CharactersListQuery
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.exception.ApolloException
import com.example.starwarschallenge.models.StarWarsCharacter
import com.example.starwarschallenge.models.mapToStarWarsCharacterList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    val charactersList: MutableStateFlow<List<StarWarsCharacter>> = MutableStateFlow(listOf())
    val isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isErrorState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isInDetailView: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val detailCurrentCharacter: MutableStateFlow<StarWarsCharacter?> = MutableStateFlow(null)

    val api = StarWarsApi().getApolloClient()

    private var nextCursor: String? = null

    fun getData(sharedPreferences: SharedPreferences) {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val response =
                    api.query(CharactersListQuery(Optional.presentIfNotNull(nextCursor))).execute()
                nextCursor = response.data?.allPeople?.pageInfo?.endCursor
                delay(2000)
                val newList = charactersList.value.toMutableList()
                val favoriteList = response.data?.allPeople?.people?.mapNotNull {
                    if (sharedPreferences.getBoolean(it?.id ?: "", false)) {
                        it?.id
                    } else {
                        null
                    }
                }
                newList.addAll(
                    response.data?.mapToStarWarsCharacterList(
                        favoriteList ?: emptyList()
                    ) ?: listOf()
                )
                charactersList.value = newList
                isLoading.value = false
                if (response.data?.allPeople?.pageInfo?.hasNextPage == true) {
                    getData(sharedPreferences)
                }
            } catch (e: ApolloException) {
                isLoading.value = false
                isErrorState.value = true
            }
        }
    }

    fun navigateToDetails(id: String) {
        detailCurrentCharacter.value = charactersList.value.find { it.id == id }
        isInDetailView.value = true
    }

    fun navigateBack() {
        detailCurrentCharacter.value = null
        isInDetailView.value = false
    }

}
