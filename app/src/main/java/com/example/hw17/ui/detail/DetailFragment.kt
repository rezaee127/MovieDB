package com.example.hw17.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.hw17.R
import com.example.hw17.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    val vModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
        val movieId = requireArguments().getInt("id")

        vModel.getMovieDetail(movieId).observe(viewLifecycleOwner) {
            binding.tvTitle.text = it.title
            var str = ""
            for (genre in it.genres)
                str += "${genre.name},"
            binding.tvGenre.text = str
            binding.tvHomePage.text = it.homepage
            binding.tv.text="Overview"
            binding.tvOverview.text = it.overview
            binding.tvReleaseDate.text = it.releaseDate
            binding.tvTagline.text = it.tagline

            Glide.with(requireContext())
                .load("https://image.tmdb.org/t/p/w500/${it.posterPath}")
                .fitCenter()
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .into(binding.ivDetail)
        }


    }


}


