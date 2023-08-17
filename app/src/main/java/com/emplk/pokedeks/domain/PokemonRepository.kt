package com.emplk.pokedeks.domain

import com.emplk.pokedeks.data.model.PokemonResponse
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getRandomPokemon(): Flow<PokemonResponse>
}