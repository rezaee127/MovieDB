package com.example.hw17.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.hw17.R
import com.example.hw17.databinding.FragmentDetailBinding
import com.example.hw17.ui.popular.MovieListViewModel
import com.example.hw17.ui.popular.goToShowVideoFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val vModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        requireActivity().title = "Detail"
        val movieId = requireArguments().getInt("id")

        binding.apply {

            vModel.getMovieDetail(movieId).observe(viewLifecycleOwner) {

                tvTitle.text = it.title
                var str = ""
                for (genre in it.genres)
                    str += "${genre.name},"
                btnFavorite.text = it.popularity.toInt().toString()
                btnAverageRating.text = it.voteAverage.toInt().toString()
                btnRatingCount.text = it.voteCount.toString()
                tvDescription.text = "Genre :  $str \n\nOverview : \n${it.overview}"

                Glide.with(requireContext())
                    .load("https://image.tmdb.org/t/p/w500/${it.posterPath}")
                    .fitCenter()
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(ivDetail)
            }

            btnPlay.setOnClickListener {
                val movieListViewModel: MovieListViewModel by viewModels()
                goToShowVideoFragment(movieId, R.id.action_detailFragment_to_showVideoFragment, movieListViewModel)
            }
        }

    }

}





