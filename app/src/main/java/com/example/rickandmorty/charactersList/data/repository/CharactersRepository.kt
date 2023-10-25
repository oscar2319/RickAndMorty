package com.example.rickandmorty.charactersList.data.repository

import android.util.Log
import com.example.rickandmorty.charactersList.data.network.CharactersService
import com.example.rickandmorty.charactersList.data.network.response.CharacterInfo
import com.example.rickandmorty.charactersList.data.network.response.CharactersResponse
import com.example.rickandmorty.utils.Mapper
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val apiService: CharactersService) {

    fun getCharacters(currentPage: Int, onResult: (CharactersResponse?) -> Unit){
        apiService.getCharacters(currentPage,onResult)
    }
}