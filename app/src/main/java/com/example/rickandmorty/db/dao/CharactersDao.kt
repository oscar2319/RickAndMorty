package com.example.rickandmorty.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.rickandmorty.db.entities.CharactersEntity

@Dao
interface CharactersDao {
    @Query("SELECT * FROM characters")
    fun getResults(): List<CharactersEntity>

    @Query("SELECT * FROM characters WHERE id=:id LIMIT 1")
    fun getResult(id: Int): CharactersEntity

//    @Query("SELECT * FROM AutResponseEntity WHERE id like:data or rrn like:data ")
//    fun getTransaccionFilter( data:String): List<AutResponseEntity>

    @Insert
    fun addResult(autResponseEntity: CharactersEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(characterList: List<CharactersEntity>)

    @Update
    fun updateResult(autResponseEntity: CharactersEntity)

    @Delete
    fun deleteResult(autResponseEntity: CharactersEntity)
}
