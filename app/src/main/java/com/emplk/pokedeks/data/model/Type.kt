package com.emplk.pokedeks.data.model

import com.google.gson.annotations.SerializedName

data class Type(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)