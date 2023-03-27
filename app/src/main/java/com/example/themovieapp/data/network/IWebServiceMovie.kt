package com.example.themovieapp.data.network
import com.example.themovieapp.data.network.response.Movies
import retrofit2.http.GET
import retrofit2.http.Query

interface IWebServiceMovie {
    @GET("movie/upcoming")
    suspend fun getUpComingMovies(@Query("api_key") api_key: String): Movies

    @GET("movie/top_rated")
    suspend fun getTopRatingMovies(@Query("api_key") api_key: String): Movies

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") api_key: String): Movies
}
