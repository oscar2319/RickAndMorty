package com.example.rickandmorty.charactersList

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.rickandmorty.charactersList.data.network.CharactersService
import com.example.rickandmorty.charactersList.model.CharactersDetails

@Composable
fun CharactersRecyclerScreen(navController: NavController, charactersViewModel: CharactersViewModel, context: Context){

    charactersViewModel.showCharacters(context = context)
    val listOfCharacters: List<CharactersDetails> by charactersViewModel.charactersList.observeAsState(initial = emptyList())

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Cyan)
    ){

        CharacterRecyclerView(characterList = listOfCharacters, charactersViewModel)
    }
}

