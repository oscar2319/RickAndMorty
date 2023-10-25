package com.example.rickandmorty.charactersList.data.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.rickandmorty.charactersList.data.network.CharactersService
import com.example.rickandmorty.charactersList.data.network.response.CharacterInfo
import com.example.rickandmorty.charactersList.data.network.response.CharactersResponse
import com.example.rickandmorty.db.dao.CharactersDao
import com.example.rickandmorty.db.entities.CharactersEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersRepository @Inject constructor(
    private val apiService: CharactersService,
    private val charactersDao: CharactersDao) {

    fun getCharacters(currentPage: Int, onResult: (CharactersResponse?) -> Unit){
        apiService.getCharacters(currentPage,onResult)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getCharactersFromDB():List<CharactersEntity>{
        return charactersDao.getResults()
    }
    suspend fun addCharacters(page: Int, characterInfo: List<CharacterInfo>){
        Log.d("TAG-1", "characterInfo $characterInfo")
        charactersDao.insertAll(characterInfo.map {
            CharactersEntity(
                it.id,
                it.name,
                it.status,
                it.species,
                it.type,
                it.gender,
                it.image,
                it.url,
                it.created,
                page
            )
        })
    }


}