package com.example.themovieapp.ui.movie.adapters.concat

import android.content.Context
import com.bumptech.glide.Glide
import com.example.themovieapp.core.BaseViewHolder
import com.example.themovieapp.data.network.response.Results
import com.example.themovieapp.databinding.MovieItemBinding

class MoviesViewHolder(
    private val binding: MovieItemBinding, private val context: Context
) : BaseViewHolder<Results>(binding.root) {
    override fun bind(item: Results) {
        Glide.with(context).load("https://image.tmdb.org/t/p/w500/${item.posterPath}")
            .centerCrop().into(binding.imageMovie)
    }
}