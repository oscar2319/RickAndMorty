package com.example.rickandmorty.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmorty.db.dao.CharactersDao
import com.example.rickandmorty.db.entities.CharactersEntity

@Database(entities = [CharactersEntity::class] , version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun charactersDao(): CharactersDao
}