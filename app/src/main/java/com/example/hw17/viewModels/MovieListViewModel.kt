package com.example.hw17.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.hw17.models.Result
import com.example.hw17.network.MovieApi
import kotlinx.coroutines.launch

class MovieListViewModel(app:Application):AndroidViewModel(app) {
    var value=""


    init {
       // getMarsPhotos()
    }

    fun getMovieList() : LiveData<List<Result>> {
        var listMovie=MutableLiveData<List<Result>>()
        viewModelScope.launch {
            try {

                listMovie.value = MovieApi.RETROFIT_SERVICE.getMovieList()
                val listResult = MovieApi.RETROFIT_SERVICE.getPhotos()
               value = "Success: ${listMovie.value!!.size} Mars photos retrieved"
            } catch (e: Exception) {
                value = "Failure: ${e.message}"
            }

        }
        return listMovie
    }
}