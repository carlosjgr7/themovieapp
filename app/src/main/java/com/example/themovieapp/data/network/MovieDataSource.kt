package com.example.themovieapp.data.network

import com.example.themovieapp.constants.AppConstants
import com.example.themovieapp.data.network.response.Movies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDataSource @Inject constructor(private val IWebServiceMovie: IWebServiceMovie) {

    suspend fun getUpcomingMovies(): Movies {
        return withContext(Dispatchers.IO) {
            val response = IWebServiceMovie.getUpComingMovies(AppConstants.APIKEY)
            response
        }
    }

    suspend fun getTopRatingMovies(): Movies {
        return withContext(Dispatchers.IO) {
            val response = IWebServiceMovie.getTopRatingMovies(AppConstants.APIKEY)
            response
        }
    }

    suspend fun getPopularMovies(): Movies {
        return withContext(Dispatchers.IO) {
            val response = IWebServiceMovie.getPopularMovies(AppConstants.APIKEY)
            response
        }
    }

}
