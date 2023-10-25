package com.example.rickandmorty.network.di

import com.example.rickandmorty.charactersList.data.network.CharactersClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    //Se utiliza  Interceptor para mostrar los resultados de la peticion
    private val loggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    private val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor)
        // Se añaden las cabeceras
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
            //    .addHeader("Authorization", "Basic ${global.keyApi}")
            chain.proceed(request.build())
        }
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideCharactersClient(retrofit: Retrofit): CharactersClient {
        return  retrofit.create(CharactersClient::class.java)
    }
}