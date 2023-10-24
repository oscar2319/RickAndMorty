package com.example.rickandmorty.utils

import com.example.rickandmorty.charactersList.data.network.response.CharacterInfo
import com.example.rickandmorty.charactersList.model.CharactersDetails

object Mapper {
    fun characterInfoToCharacterDetails(characterInfo: List<CharacterInfo>): List<CharactersDetails> {

        val listCharactersDetails = mutableListOf<CharactersDetails>()
        for(character in characterInfo){
            val character = CharactersDetails(
                character.image,
                character.name,
                character.species,
                character.status,
            )
            listCharactersDetails.add(character)
        }
        return listCharactersDetails
    }
}