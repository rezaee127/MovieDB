package com.example.hw17.ui.popular

import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hw17.R
import com.example.hw17.databinding.FragmentMovieListBinding
import com.example.hw17.ui.adapter.MovieAdapter


class MovieListFragment : Fragment() {
    lateinit var binding: FragmentMovieListBinding
    val vModel: MovieListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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

        initAdapter()
    }

    private fun initAdapter() {

       val adapter= MovieAdapter({id->
           vModel.getMovieDetail(id).observe(viewLifecycleOwner) {
              // if(it!=null){
                   val bundle=bundleOf("id" to id)
                   findNavController().navigate(R.id.action_movieListFragment_to_detailFragment,bundle)
//               }else
//                   Toast.makeText(requireContext(),"There are no details for this movie",Toast.LENGTH_SHORT).show()
           }
       },{ movieId->
           vModel.getVideo(movieId).observe(requireActivity()) {
               var videoKey = it[0].key
               val videoUrl = "https://www.youtube.com/watch?v=${videoKey}"
               val bundle = bundleOf("url" to videoUrl)
               findNavController().navigate(R.id.action_movieListFragment_to_showVideoFragment, bundle)
           }

       })
       binding.rvMovie.adapter=adapter
       vModel.listMovie.observe(viewLifecycleOwner){
           adapter.submitList(it)
       }


    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.action_bar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.coming_soon_menu_item  -> {
                findNavController().navigate(R.id.action_movieListFragment_to_comingSoonFragment)
                true
            }
            R.id.search_menu_item -> {
                findNavController().navigate(R.id.action_movieListFragment_to_searchFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}