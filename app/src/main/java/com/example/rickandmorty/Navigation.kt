package com.example.rickandmorty

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.rickandmorty.presentation.CharacterRecyclerView
import com.example.rickandmorty.presentation.model.CharactersDetails
import com.example.rickandmorty.presentation.model.Routes

@Composable
fun CharactersRecyclerScreen(navController: NavController){

   Box(modifier = Modifier
       .fillMaxSize()
       .background(color = Color.Cyan)
   ){

       val myListOfCharacters = getCharacters()
       CharacterRecyclerView(characterList = myListOfCharacters)
   }
}
@Composable
fun InfoScreen(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Cyan)
    )
}

fun getCharacters(): List<CharactersDetails>{
    return listOf(
        CharactersDetails(R.drawable.rick, "Rick", "human", "Alive"),
        CharactersDetails(R.drawable.rick, "Morty", "ijcbqai", "Alive")
    )
}