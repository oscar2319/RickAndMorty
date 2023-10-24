package com.example.rickandmorty.charactersList.data.network

import android.util.Log
import com.example.rickandmorty.charactersList.data.network.response.CharactersResponse
import com.example.rickandmorty.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharactersService {

    private val retrofit = RetrofitHelper.getRetrofit()


    //Crear una variable la cual invoca la interfaz
    private val service: CharactersClient = retrofit.create(CharactersClient::class.java)

    fun getCharacters(currentPage: Int, onResult: (CharactersResponse?) -> Unit) {
        //service  userData
        service.getCharacters(currentPage).enqueue(object : Callback<CharactersResponse> {
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



