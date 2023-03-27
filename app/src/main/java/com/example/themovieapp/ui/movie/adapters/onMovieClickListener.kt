package com.example.themovieapp.ui.movie.adapters

import com.example.themovieapp.data.network.response.Results

interface onMovieClickListener {
    fun onMovieClick(movie:Results)
}