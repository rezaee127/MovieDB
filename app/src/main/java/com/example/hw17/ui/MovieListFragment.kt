package com.example.hw17.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.hw17.databinding.FragmentMovieListBinding
import com.example.hw17.viewModels.MovieListViewModel


class MovieListFragment : Fragment() {
    lateinit var binding: FragmentMovieListBinding
    val vModel:MovieListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMovieListBinding.inflate(inflater,container,false)
        return binding.root
        //return inflater.inflate(R.layout.fragment_film_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
       var adapter=ResultAdapter({})
       binding.rvMovie.adapter=adapter
       vModel.getMovieList().observe(viewLifecycleOwner){
           adapter.submitList(it)
       }


    }
}