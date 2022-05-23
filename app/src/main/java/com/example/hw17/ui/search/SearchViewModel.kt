package com.example.hw17.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw17.data.Repository
import com.example.hw17.models.Movie
import kotlinx.coroutines.launch

class SearchViewModel:ViewModel() {

    var listOfSearchedMovies=MutableLiveData<List<Movie>>()


    fun getSearchedMovie(movieName:String){
        viewModelScope.launch {
            try {
                listOfSearchedMovies.value= Repository.getSearchedMovie(movieName).movieList
            }
            catch (e:Exception){

            }
        }
    }

}