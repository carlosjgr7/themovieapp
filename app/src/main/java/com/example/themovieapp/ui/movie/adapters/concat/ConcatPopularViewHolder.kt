package com.example.themovieapp.ui.movie.adapters.concat

import com.example.themovieapp.core.BaseViewHolder
import com.example.themovieapp.databinding.PopularMoviesRowBinding

class ConcatPopularViewHolder(private val binding:PopularMoviesRowBinding): BaseViewHolder<MovieAdapter>(binding.root) {
    override fun bind(adapter: MovieAdapter) {
        binding.rvPopularMovies.adapter = adapter
    }
}