package com.example.rickandmorty.db.di

import android.content.Context
import androidx.room.Room
import com.example.rickandmorty.db.AppDataBase
import com.example.rickandmorty.db.dao.CharactersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideCharactersDao(appDataBase: AppDataBase): CharactersDao{
        return appDataBase.charactersDao()
    }
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context):AppDataBase{
        return Room.databaseBuilder(context, AppDataBase::class.java, "RickAndMortyDataBase").build()
    }
}