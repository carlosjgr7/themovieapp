package com.example.themovieapp.ui.movie.adapters.concat

import com.example.themovieapp.core.BaseViewHolder
import com.example.themovieapp.databinding.TopRatedMoviesRowBinding

class ConcatTopRatedViewHolder (private val binding: TopRatedMoviesRowBinding): BaseViewHolder<MovieAdapter>(binding.root) {
    override fun bind(adapter: MovieAdapter) {
        binding.rvTopRatedMovies.adapter = adapter
    }
}