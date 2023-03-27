package com.example.themovieapp.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.themovieapp.core.ResourceMovies
import com.example.themovieapp.domain.GetPopularMoviesUsesCase
import com.example.themovieapp.domain.GetTopRatingMoviesUsesCase
import com.example.themovieapp.domain.GetUpComingMoviesUsesCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getUpComingMoviesUsesCase: GetUpComingMoviesUsesCase,
    private val getPopularMoviesUsesCase: GetPopularMoviesUsesCase,
    private val getTopRatingMoviesUsesCase: GetTopRatingMoviesUsesCase
) : ViewModel() {

    fun fetchUpcomingMovies()= liveData(viewModelScope.coroutineContext + Dispatchers.Main){
        emit(ResourceMovies.Loading())
        try {
            emit(ResourceMovies.Success(Triple(getUpComingMoviesUsesCase(),getPopularMoviesUsesCase(),getTopRatingMoviesUsesCase())))
        }catch (e:java.lang.Exception){
            emit(ResourceMovies.Failure("ERROR CODE: ${e.message!!}"))
        }
    }
}