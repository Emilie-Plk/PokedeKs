package com.emplk.pokedeks.data.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(

    @field:SerializedName("types")
    val types: List<TypesItem?>? = emptyList(),

    @field:SerializedName("sprites")
    val sprites: Sprites? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("height")
    val height: Int? = null,

    @field:SerializedName("order")
    val order: Int? = null
)