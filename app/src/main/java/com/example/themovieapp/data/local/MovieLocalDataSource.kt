package com.example.themovieapp.data.local

import com.example.themovieapp.core.MovieType
import com.example.themovieapp.data.local.response.MovieEntity
import com.example.themovieapp.data.local.response.toMovieList
import com.example.themovieapp.data.network.response.Movies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor(private val IMovieDao: IMovieDao) {

    suspend fun getUpcomingMovies(): Movies {
        return withContext(Dispatchers.IO) {
            val response = IMovieDao.getAllMovies()
                .filter { it.movietype == MovieType.UpCommingMovie.name }.toMovieList()
            response
        }
    }

    suspend fun getTopRatingMovies(): Movies {
        return withContext(Dispatchers.IO) {
            val response =IMovieDao.getAllMovies()
                .filter { it.movietype == MovieType.TopRatingMovie.name }.toMovieList()
            response
        }
    }

    suspend fun getPopularMovies(): Movies {
        return withContext(Dispatchers.IO) {
            val response = IMovieDao.getAllMovies()
                    .filter { it.movietype == MovieType.PopularMovie.name }.toMovieList()
            response
        }
    }

    suspend fun saveMovieEntity(movie:MovieEntity) = IMovieDao.insertMovie(movie)







}