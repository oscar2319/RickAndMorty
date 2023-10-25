package com.example.rickandmorty.charactersList.domain

import android.util.Log
import com.example.rickandmorty.charactersList.data.network.response.CharacterInfo
import com.example.rickandmorty.charactersList.data.network.response.CharactersResponse
import com.example.rickandmorty.charactersList.data.repository.CharactersRepository
import javax.inject.Inject
import retrofit2.Response

class GetCharactersUseCase @Inject constructor(private val repository: CharactersRepository) {
    operator fun invoke(currentPage: Int, onResult: (CharactersResponse?) -> Unit){
        repository.getCharacters(currentPage, onResult)
    }

}