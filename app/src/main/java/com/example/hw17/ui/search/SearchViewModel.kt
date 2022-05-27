package com.example.hw17.ui.search

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.*
import com.example.hw17.data.Repository
import com.example.hw17.models.Movie
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SearchViewModel(var app: Application): AndroidViewModel(app) {

    var listOfSearchedMovies=MutableLiveData<List<Movie>>()

    fun getSearchedMovie(movieName:String): LiveData<List<Movie>>{
        viewModelScope.async {
            try {
                listOfSearchedMovies.value=Repository.getSearchedMovie(movieName).movieList
            }
            catch (e:Exception){
                Toast.makeText(app.applicationContext,e.message, Toast.LENGTH_SHORT).show()
            }
        }
        return listOfSearchedMovies
    }

}