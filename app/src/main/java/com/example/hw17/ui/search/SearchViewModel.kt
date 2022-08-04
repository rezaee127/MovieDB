package com.example.hw17.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw17.data.Repository
import com.example.hw17.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import javax.inject.Inject

@HiltViewModel
class SearchViewModel@Inject constructor(private val repository: Repository):ViewModel() {

    var listOfSearchedMovies=MutableLiveData<List<Movie>>()

    fun getSearchedMovie(movieName:String): LiveData<List<Movie>>{
        viewModelScope.async {
            try {
                listOfSearchedMovies.value=repository.getSearchedMovie(movieName).movieList
            }
            catch (e:Exception){
            }
        }
        return listOfSearchedMovies
    }

}