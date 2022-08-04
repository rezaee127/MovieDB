package com.example.hw17.ui.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.hw17.R
import com.example.hw17.databinding.FragmentComingSoonBinding
import com.example.hw17.ui.adapter.ComingSoonMovieAdapter
import com.example.hw17.ui.popular.MovieListViewModel
import com.example.hw17.ui.popular.goToDetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComingSoonFragment : Fragment() {
    private lateinit var binding:FragmentComingSoonBinding
    private val vModel: ComingSoonViewModel by viewModels()

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
        requireActivity().title="Coming Soon"
        val movieListViewModel:MovieListViewModel by viewModels()
        val adapter= ComingSoonMovieAdapter { id ->
            goToDetailFragment(id, R.id.action_comingSoonFragment_to_detailFragment, movieListViewModel)
        }

        binding.rvComingSoon.adapter=adapter
        vModel.listOfComingSoon.observe(requireActivity()){
            adapter.submitList(it)
        }
    }


}