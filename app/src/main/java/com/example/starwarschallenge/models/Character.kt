package com.example.starwarschallenge.models

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
