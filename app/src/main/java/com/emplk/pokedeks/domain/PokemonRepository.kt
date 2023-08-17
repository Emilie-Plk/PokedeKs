package com.emplk.pokedeks.domain

import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getRandomPokemon(randomStringId: String): Flow<PokemonEntity>
}