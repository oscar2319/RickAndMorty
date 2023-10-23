package com.example.rickandmorty.presentation.model

sealed class Routes(val routes: String) {
    object CharactersRV:Routes("charactersRV")
    object InfoCharacters:Routes("infoCharacters")
}