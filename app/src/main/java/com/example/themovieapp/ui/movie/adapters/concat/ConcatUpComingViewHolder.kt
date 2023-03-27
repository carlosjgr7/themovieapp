package com.example.themovieapp.ui.movie.adapters.concat

import com.example.themovieapp.core.BaseViewHolder
import com.example.themovieapp.databinding.UpcomingMovieRowBinding

class ConcatUpComingViewHolder(private val binding: UpcomingMovieRowBinding): BaseViewHolder<MovieAdapter>(binding.root) {
    override fun bind(adapter: MovieAdapter) {
        binding.rvUpcomingMovies.adapter =adapter
    }

}