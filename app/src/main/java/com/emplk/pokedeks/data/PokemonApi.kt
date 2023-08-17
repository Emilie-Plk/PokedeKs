package com.emplk.pokedeks.data

import com.emplk.pokedeks.data.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon/{id}/")
    suspend fun getPokemonById(@Path("id") id: String): PokemonResponse
}