package com.example.themovieapp.data

import com.example.themovieapp.data.network.MovieDataSource
import javax.inject.Inject

class MovieRepository @Inject constructor (private val dataSource: MovieDataSource) {

     suspend fun getUpComingMovies() = dataSource.getUpcomingMovies()
     suspend fun getTopRatingMovies() = dataSource.getTopRatingMovies()
     suspend fun getPopularMovies() = dataSource.getPopularMovies()
}