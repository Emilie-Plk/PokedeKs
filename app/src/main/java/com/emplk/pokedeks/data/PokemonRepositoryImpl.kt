package com.emplk.pokedeks.data

import com.emplk.pokedeks.data.model.PokemonResponse
import com.emplk.pokedeks.domain.CoroutineDispatcherProvider
import com.emplk.pokedeks.domain.PokemonEntity
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
    override fun getRandomPokemon(randomStringId: String): Flow<PokemonEntity> = flow {
        try {
            val response = pokemonApi.getPokemonById(randomStringId)
            emit(mapResponseToEntity(response))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }.flowOn(coroutineDispatcherProvider.io)

    private fun mapResponseToEntity(response: PokemonResponse?): PokemonEntity {
        return PokemonEntity(
            id = response?.id.toString(),
            name = response?.name.orEmpty(),
            imageUrl = response?.sprites?.frontDefault.orEmpty(),
        )
    }
}


