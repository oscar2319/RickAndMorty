package com.example.rickandmorty.charactersList.domain

import com.example.rickandmorty.charactersList.data.network.response.CharacterInfo
import com.example.rickandmorty.charactersList.data.repository.CharactersRepository
import javax.inject.Inject

class AddCharactersUseCase  @Inject constructor(private val repository: CharactersRepository) {
    suspend operator fun invoke(page: Int, characterInfo: List<CharacterInfo>){
        repository.addCharacters(page,characterInfo)
    }
}