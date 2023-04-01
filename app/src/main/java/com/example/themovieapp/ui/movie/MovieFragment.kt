package com.example.themovieapp.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.themovieapp.R
import com.example.themovieapp.core.ResourceMovies
import com.example.themovieapp.data.network.response.Results
import com.example.themovieapp.databinding.FragmentMovieBinding
import com.example.themovieapp.ui.movie.adapters.concat.MovieAdapter
import com.example.themovieapp.ui.movie.adapters.concat.PopularConcatAdapter
import com.example.themovieapp.ui.movie.adapters.concat.TopRatedConcatAdapter
import com.example.themovieapp.ui.movie.adapters.concat.UpComingConcatAdapter
import com.example.themovieapp.ui.movie.adapters.onMovieClickListener
import com.example.themovieapp.ui.presentation.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie), onMovieClickListener {

    private lateinit var binding: FragmentMovieBinding
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var concatAdapter: ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        concatAdapter = ConcatAdapter()


        viewModel.fetchMovies().observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResourceMovies.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("livedata", it.exception)
                }
                is ResourceMovies.Loading -> binding.progressBar.visibility = View.VISIBLE
                is ResourceMovies.Success -> {
                    binding.progressBar.visibility = View.GONE
                    concatAdapter.apply {
                        addAdapter(
                            0, UpComingConcatAdapter(
                                MovieAdapter(
                                    it.data.first.results, this@MovieFragment
                                )
                            )
                        )
                        addAdapter(
                            1, TopRatedConcatAdapter(
                                MovieAdapter(
                                    it.data.second.results, this@MovieFragment
                                )
                            )
                        )
                        addAdapter(
                            2, PopularConcatAdapter(
                                MovieAdapter(
                                    it.data.third.results, this@MovieFragment
                                )
                            )
                        )

                    }
                    binding.rvMovies.adapter = concatAdapter
                }
            }
        })


    }

    override fun onMovieClick(movie: Results) {
        val action = MovieFragmentDirections.actionMovieFragmentToMovieDetailFragment(
            movie.posterPath.toString(),
            movie.backdropPath.toString(),
            movie.voteAverage?.toFloat() ?: 0.0f,
            movie.voteCount ?: 0,
            movie.overview.toString(),
            movie.title.toString(),
            movie.originalLanguage.toString(),
            movie.releaseDate.toString()
        )
        findNavController().navigate(action)
    }
}