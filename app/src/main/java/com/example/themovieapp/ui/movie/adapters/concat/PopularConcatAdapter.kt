package com.example.themovieapp.ui.movie.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.core.BaseViewHolder
import com.example.themovieapp.databinding.PopularMoviesRowBinding

class PopularConcatAdapter(private val movieAdapter: MovieAdapter) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): BaseViewHolder<*> {
        val itemBinding = PopularMoviesRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ConcatPopularViewHolder(itemBinding)
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is ConcatPopularViewHolder -> holder.bind(movieAdapter)
        }
    }
}