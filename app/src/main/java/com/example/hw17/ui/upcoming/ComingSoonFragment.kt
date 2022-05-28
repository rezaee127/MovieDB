package com.example.hw17.ui.upcoming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.hw17.R
import com.example.hw17.databinding.FragmentComingSoonBinding
import com.example.hw17.ui.adapter.ComingSoonMovieAdapter
import com.example.hw17.ui.popular.MovieListViewModel
import com.example.hw17.ui.popular.goToDetailFragment
import com.example.hw17.ui.popular.goToShowVideoFragment


class ComingSoonFragment : Fragment() {
    lateinit var binding:FragmentComingSoonBinding
    val vModel: ComingSoonViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentComingSoonBinding.inflate(inflater,container,false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_coming_soon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        val movieListViewModel:MovieListViewModel by viewModels()
        val adapter= ComingSoonMovieAdapter({id->
            goToDetailFragment(id, R.id.action_comingSoonFragment_to_detailFragment,movieListViewModel)
        },{ movieId->
            goToShowVideoFragment(movieId, R.id.action_comingSoonFragment_to_showVideoFragment,movieListViewModel)})
        binding.rvComingSoon.adapter=adapter
        vModel.listOfComingSoon.observe(requireActivity()){
            adapter.submitList(it)
        }
    }


}