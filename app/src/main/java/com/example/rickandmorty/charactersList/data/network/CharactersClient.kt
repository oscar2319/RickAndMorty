package com.example.rickandmorty.charactersList.data.network

import com.example.rickandmorty.charactersList.data.network.response.CharactersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersClient {

    @GET("/api/character")
    fun getCharacters(@Query("page") pageNumber: Int):Call<CharactersResponse>

}