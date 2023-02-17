package com.example.starwarschallenge.models

import CharactersListQuery
import kotlinx.coroutines.flow.MutableStateFlow

data class StarWarsCharacter(
    val id: String,
    val name: String,
    val race: String,
    val homePlanet: String,
    val eyeColor: String,
    val hairColor: String,
    val skinColor: String,
    val birthYear: String,
    val vehicles: List<String>,
    val isFavorite: MutableStateFlow<Boolean>
)

fun CharactersListQuery.Data.mapToStarWarsCharacterList(favoritesList: List<String>): List<StarWarsCharacter> {
    val charactersPreList = this.allPeople?.people ?: listOf()
    return charactersPreList.mapNotNull { person ->
        person.mapToStarWarsCharacter(favoritesList.contains(person?.id))
    }
}

fun CharactersListQuery.Person?.mapToStarWarsCharacter(isFavorite: Boolean): StarWarsCharacter {
    return StarWarsCharacter(
        id = this?.id ?: "Unidentified",
        name = this?.name ?: "Unidentified",
        race = this?.species?.name ?: "Human",
        homePlanet = this?.homeworld?.name ?: "Unidentified",
        eyeColor = this?.eyeColor ?: "Unidentified",
        hairColor = this?.hairColor ?: "Unidentified",
        skinColor = this?.skinColor ?: "Unidentified",
        birthYear = this?.birthYear ?: "Unidentified",
        vehicles = this?.vehicleConnection?.vehicles?.map { vehicle ->
            vehicle?.name ?: "Unidentified"
        } ?: listOf(),
        isFavorite = MutableStateFlow(isFavorite)
    )
}
