package com.example.hw17.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.example.hw17.databinding.FragmentSearchBinding
import com.example.hw17.models.Movie
import com.example.hw17.ui.adapter.MovieAdapter


class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    val vModel: SearchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {

        binding.btnSearch.setOnClickListener {
            if (binding.etSearch.text.isNullOrBlank())
                binding.etSearch.error="Enter a name"
            else{
                //lifecycleScope.async { vModel.getSearchedMovie(binding.etSearch.text.toString()) }

                vModel.getSearchedMovie(binding.etSearch.text.toString()).observe(viewLifecycleOwner){
                    if (!it.isNullOrEmpty()){
                        binding.clSearch.visibility=View.GONE
                        binding.rvSearch.isVisible=true
                        binding.btnReturn.isVisible=true
                        val adapter= MovieAdapter({x->},{y->})
                        binding.rvSearch.adapter=adapter
                        adapter.submitList(it)
                    }else
                        Toast.makeText(requireContext(),"This movie does not exist",Toast.LENGTH_SHORT).show()
                }

            }

        }


        binding.btnReturn.setOnClickListener {
            binding.clSearch.visibility=View.VISIBLE
            binding.rvSearch.isVisible=false
            binding.btnReturn.isVisible=false
            vModel.listOfSearchedMovies= MutableLiveData<List<Movie>>()
        }



    }
}