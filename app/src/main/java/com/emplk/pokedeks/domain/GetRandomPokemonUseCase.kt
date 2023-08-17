package com.emplk.pokedeks.domain

import android.util.Log
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRandomPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    fun invoke(randomId: String): Flow<PokemonEntity> = pokemonRepository.getRandomPokemon(randomId)
}