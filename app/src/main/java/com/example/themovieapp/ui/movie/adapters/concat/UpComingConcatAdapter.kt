package com.example.themovieapp.ui.movie.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.core.BaseViewHolder
import com.example.themovieapp.databinding.UpcomingMovieRowBinding

class UpComingConcatAdapter(private val movieAdapter: MovieAdapter) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): BaseViewHolder<*> {
        val itemBinding = UpcomingMovieRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ConcatUpComingViewHolder(itemBinding)
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is ConcatUpComingViewHolder -> holder.bind(movieAdapter)
        }
    }
}