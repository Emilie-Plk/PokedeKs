package com.emplk.pokedeks.data

import com.emplk.pokedeks.data.model.PokemonResponse
import com.emplk.pokedeks.domain.CoroutineDispatcherProvider
import com.emplk.pokedeks.domain.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider,
) : PokemonRepository {
    override fun getRandomPokemon(): Flow<PokemonResponse> = flow {
        val randomStringId = (1..898).random().toString()
        val response = pokemonApi.getPokemonById(randomStringId)
        emit(response)
    }.flowOn(coroutineDispatcherProvider.io)
}