package com.example.themovieapp.domain

import com.example.themovieapp.data.MovieRepository
import com.example.themovieapp.data.network.response.Movies
import javax.inject.Inject

class GetPopularMoviesUsesCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke():Movies = movieRepository.getPopularMovies()

}