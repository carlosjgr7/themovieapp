package com.example.themovieapp.core
import java.lang.Exception

sealed class ResourceMovies<out T> {
    class Loading<out T>:ResourceMovies<T>()
    data class Success<out T>(val data:T):ResourceMovies<T>()
    data class Failure<out T>(val exception: String):ResourceMovies<T>()
}