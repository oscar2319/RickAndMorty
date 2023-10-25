package com.example.rickandmorty.charactersList.data.network

import com.example.rickandmorty.charactersList.data.network.response.CharactersResponse
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersService @Inject constructor(private val charactersClient: CharactersClient){


    fun getCharacters(currentPage: Int, onResult: (CharactersResponse?) -> Unit) {
        //service  userData
        charactersClient.getCharacters(currentPage).enqueue(object : Callback<CharactersResponse> {
            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                onResult(null)
            }

            override fun onResponse(
                call: Call<CharactersResponse>,
                response: Response<CharactersResponse>
            ) {
                val addedUser = response.body()
                if (addedUser != null) {
                    onResult(addedUser)
                } else {
                    onResult(null)
                }
            }
        }
        )
    }
}



