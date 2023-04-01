package com.example.themovieapp.data

import android.app.Application
import android.content.Context
import androidx.core.content.ContextCompat
import com.example.themovieapp.core.MovieType
import com.example.themovieapp.data.local.MovieLocalDataSource
import com.example.themovieapp.data.local.response.MovieEntity
import com.example.themovieapp.data.network.MovieRemoteDataSource
import com.example.themovieapp.data.network.WebUses
import com.example.themovieapp.data.network.response.Movies
import com.example.themovieapp.data.network.response.Results
import com.example.themovieapp.data.network.response.toMovieEntity
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieLocalDataSource,
    private val context: Context
) {

    suspend fun getUpComingMovies(): Movies {
       if(WebUses.isConnected(context)) {
            remoteDataSource.getUpcomingMovies().results.forEach {
                it.toMovieEntity(MovieType.UpCommingMovie.name).let { movieEntity ->
                    saveLocalMovie(movieEntity)
                }
            }

        }
        return localDataSource.getUpcomingMovies()
    }

    suspend fun getTopRatingMovies(): Movies {
        if(WebUses.isConnected(context)) {
            remoteDataSource.getTopRatingMovies().results.forEach {
                it.toMovieEntity(MovieType.TopRatingMovie.name).let { movieEntity ->
                    saveLocalMovie(movieEntity)
                }
            }
        }
        return localDataSource.getTopRatingMovies()
    }

    suspend fun getPopularMovies(): Movies {
        if(WebUses.isConnected(context)) {
            remoteDataSource.getPopularMovies().results.forEach {
                it.toMovieEntity(MovieType.PopularMovie.name).let { movieEntity ->
                    saveLocalMovie(movieEntity)
                }
            }
        }
        return localDataSource.getPopularMovies()
    }

    suspend fun saveLocalMovie(movie: MovieEntity) {
        localDataSource.saveMovieEntity(movie)
    }


}