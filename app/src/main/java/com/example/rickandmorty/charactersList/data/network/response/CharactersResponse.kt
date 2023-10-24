package com.example.rickandmorty.charactersList.data.network.response

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info")
    val info: GeneralInfo,
    @SerializedName("results")
    val results: List<CharacterInfo>
)
