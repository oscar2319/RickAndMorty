package com.example.rickandmorty.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmorty.charactersList.data.network.response.Location
import com.google.gson.annotations.SerializedName

@Entity(tableName = "characters")
data class CharactersEntity(
    @PrimaryKey()
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "status")
    val status: String,
    @ColumnInfo(name = "species")
    val species: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "created")
    val created: String,
    @ColumnInfo(name = "page")
    val page: Int
)
