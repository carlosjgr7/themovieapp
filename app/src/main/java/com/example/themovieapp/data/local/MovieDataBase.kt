package com.example.themovieapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.themovieapp.data.local.response.MovieEntity

@Database(entities =[MovieEntity::class] , version = 1)
abstract class MovieDataBase:RoomDatabase() {
    abstract fun MovieDao():IMovieDao
}