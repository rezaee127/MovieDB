package com.example.hw17.ui.popular

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.hw17.Repository
import com.example.hw17.models.Movie
import kotlinx.coroutines.launch

class MovieListViewModel(app:Application):AndroidViewModel(app) {
    var value=""
    var listMovie=MutableLiveData<List<Movie>>()

    init {
        getPopularList()
    }

    fun getPopularList() {

        viewModelScope.launch() {
            try {
                listMovie.value = Repository.getPopularList().movieList
                value = "Success: ${listMovie.value!!.size} Movie retrieved"
            } catch (e: Exception) {
                value = "Failure: ${e.message}"
            }

        }
    }

}