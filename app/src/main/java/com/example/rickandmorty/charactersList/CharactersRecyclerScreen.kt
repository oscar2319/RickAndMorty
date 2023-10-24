package com.example.rickandmorty.presentation.charactersList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.rickandmorty.presentation.model.CharactersDetails

@Composable
fun CharactersRecyclerScreen(navController: NavController, charactersViewModel: CharactersViewModel){

    val listOfCharacters: List<CharactersDetails> by charactersViewModel.charactersList.observeAsState(initial = emptyList())


    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Cyan)
    ){

        val myListOfCharacters = charactersViewModel.getCharacters()
        CharacterRecyclerView(characterList = myListOfCharacters)
    }
}

