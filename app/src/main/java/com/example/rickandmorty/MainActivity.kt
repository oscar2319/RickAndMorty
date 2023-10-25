package com.example.rickandmorty

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmorty.charactersList.CharactersRecyclerScreen
import com.example.rickandmorty.charactersList.CharactersViewModel
import com.example.rickandmorty.charactersList.InfoScreen
import com.example.rickandmorty.charactersList.model.Routes
import com.example.rickandmorty.ui.theme.RickAndMortyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val charactersViewModel: CharactersViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.CharactersRV.routes
                    ) {
                        composable(Routes.CharactersRV.routes) {
                            CharactersRecyclerScreen(navController = navController, charactersViewModel, applicationContext)
                        }
                        composable(
                            Routes.InfoCharacters.routes,
                            arguments = listOf(navArgument("characterDetail") {
                                type = NavType.IntType
                            }
                            )
                        ) {
                            InfoScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
