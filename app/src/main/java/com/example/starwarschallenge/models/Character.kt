package com.example.starwarschallenge.models

import CharactersListQuery

data class StarWarsCharacter(
    val id: String,
    val name: String,
    val race: String,
    val homePlanet: String,
    val eyeColor: String,
    val hairColor: String,
    val skinColor: String,
    val birthYear: String,
    val vehicles: List<String>
    )

fun CharactersListQuery.Data.mapToStarWarsCharacterList(): List<StarWarsCharacter>{
    val charactersPreList = this.allPeople?.people ?: listOf()
    return charactersPreList.mapNotNull { person ->
        person.mapToStarWarsCharacter()
    }
}

fun CharactersListQuery.Person?.mapToStarWarsCharacter(): StarWarsCharacter {
    return StarWarsCharacter(
        id = this?.id ?: "Unidentified",
        name = this?.name ?: "Unidentified",
        race = this?.species?.name ?: "Unidentified",
        homePlanet = this?.homeworld?.name ?: "Unidentified",
        eyeColor = this?.eyeColor ?: "Unidentified",
        hairColor = this?.hairColor ?: "Unidentified",
        skinColor = this?.skinColor ?: "Unidentified",
        birthYear = this?.birthYear ?: "Unidentified",
        vehicles = this?.vehicleConnection?.vehicles?.map { vehicle ->
            vehicle?.name ?: "Unidentified"
        } ?: listOf()
    )
}
