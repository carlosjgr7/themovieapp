package com.example.themovieapp.ui.movie.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.core.BaseViewHolder
import com.example.themovieapp.data.network.response.Results
import com.example.themovieapp.databinding.MovieItemBinding
import com.example.themovieapp.ui.movie.adapters.onMovieClickListener

class MovieAdapter(
    private val movie_list: List<Results>,
    private val item_clickListener: onMovieClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = MoviesViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            item_clickListener.onMovieClick(movie_list[position])
        }
        return holder
    }

    override fun getItemCount() =movie_list.count()

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
       when(holder){
           is MoviesViewHolder -> holder.bind(movie_list[position])
       }
    }
}