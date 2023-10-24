package com.example.rickandmorty.charactersList.data.network.response

import com.google.gson.annotations.SerializedName

data class GeneralInfo(
    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("prev")
    val prev: String?
)
