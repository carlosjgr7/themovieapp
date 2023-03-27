package com.example.themovieapp.ui.moviedetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.themovieapp.R
import com.example.themovieapp.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private lateinit var binding: FragmentMovieDetailBinding
    private val args by navArgs<MovieDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailBinding.bind(view)

        Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/${args.posterimageurl}")
            .centerCrop().into(binding.imgMovie)
        Glide.with(requireContext())
            .load("https://image.tmdb.org/t/p/w500/${args.backgroundimageurl}").centerCrop()
            .into(binding.imgBackground)
        binding.txtDescriptions.text = args.overview
        binding.txtTitle.text = args.title
        binding.txtLanguaje.text = args.language
        binding.txtRating.text = "${ args.voteaverage } de ${args.votecount} Reviews"
        binding.txtRealese.text = args.release


    }
}