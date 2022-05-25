package com.example.hw17.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw17.data.Repository
import com.example.hw17.models.Movie
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SearchViewModel:ViewModel() {

    var listOfSearchedMovies=MutableLiveData<List<Movie>>()

    fun getSearchedMovie(movieName:String): LiveData<List<Movie>>{
        viewModelScope.async {
            try {
                listOfSearchedMovies.value=Repository.getSearchedMovie(movieName)
            }
            catch (e:Exception){
                //listOfSearchedMovies.value=emptyList()
            }
        }
        return listOfSearchedMovies
    }

}