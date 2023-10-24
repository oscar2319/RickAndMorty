package com.example.rickandmorty.presentation.charactersList

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmorty.presentation.model.CharactersDetails

@Composable
fun CharacterRecyclerView(characterList: List<CharactersDetails>){
    //pasarle por parametro la lista
    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {

        items(characterList){
            item: CharactersDetails -> ItemCharacter(item)
        }
    }
}
@Composable
fun ItemCharacter(charactersDetails: CharactersDetails){
    Card(border = BorderStroke(2.dp, Color.Blue), modifier = Modifier.fillMaxWidth().height(160.dp)) {
        Row {
            Image(
                painter = painterResource(id = charactersDetails.imageUrl),
                contentDescription = "Character image",
                modifier = Modifier.fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.fillMaxHeight()) {
                Text(
                    text = "Name: " + charactersDetails.name,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp),
                    fontSize = 24.sp

                )
                Text(
                    text = "Specie: " + charactersDetails.species,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = "Status: " + charactersDetails.status,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}
