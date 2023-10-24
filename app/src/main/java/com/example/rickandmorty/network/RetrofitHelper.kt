package com.example.rickandmorty.network

import com.example.rickandmorty.charactersList.data.network.CharactersClient
import com.example.rickandmorty.charactersList.data.network.CharactersService
import com.example.rickandmorty.charactersList.data.network.response.CharactersResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    //Se utiliza  Interceptor para mostrar los resultados de la peticion
    private val loggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

// var global = DatosGlobales()
//Asociamos el interceptor a las peticiones

    private val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor)
        // Se añaden las cabeceras
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
            //    .addHeader("Authorization", "Basic ${global.keyApi}")
            chain.proceed(request.build())
        }
        .build()


    //Creacion de Retrofid
    private val retrofid = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com") //
        .addConverterFactory(GsonConverterFactory.create())

        .build()

    //Crear una variable la cual invoca la interfaz
    //val service = retrofid.create(CharactersClient::class.java)

    fun getRetrofit(): Retrofit{
           return Retrofit.Builder()
               .baseUrl("https://rickandmortyapi.com/")
               .addConverterFactory(GsonConverterFactory.create())
               .client(client)
               .build()
       }


}
