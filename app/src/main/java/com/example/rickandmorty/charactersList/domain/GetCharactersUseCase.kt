package com.example.rickandmorty.charactersList.domain

import android.util.Log
import com.example.rickandmorty.charactersList.data.network.response.CharacterInfo
import com.example.rickandmorty.charactersList.data.network.response.CharactersResponse
import com.example.rickandmorty.charactersList.data.repository.CharactersRepository
import retrofit2.Response

class GetCharactersUseCase {

    private val repository = CharactersRepository()

    operator fun invoke(currentPage: Int, onResult: (CharactersResponse?) -> Unit){
        repository.getCharacters(currentPage, onResult)
    }

}