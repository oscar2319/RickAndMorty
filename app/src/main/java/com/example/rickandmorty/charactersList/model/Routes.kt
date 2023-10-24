package com.example.rickandmorty.charactersList.model

sealed class Routes(val routes: String) {
    object CharactersRV: Routes("charactersRV")
    object InfoCharacters: Routes("infoCharacters")
}