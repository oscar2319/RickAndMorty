package com.example.rickandmorty.presentation.charactersList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.rickandmorty.ui.theme.RickAndMortyTheme

@Composable
fun InfoScreen(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Cyan)
    )
}