package com.emplk.pokedeks.domain

data class PokemonEntity(
    val id: String,
    val name: String,
    val imageUrl: String,
    val isResponseReceived: Boolean = false,
)