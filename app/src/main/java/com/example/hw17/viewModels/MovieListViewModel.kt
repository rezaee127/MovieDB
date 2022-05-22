package com.example.hw17.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.hw17.models.Popular
import com.example.hw17.network.MovieApi
import kotlinx.coroutines.launch

class MovieListViewModel(app:Application):AndroidViewModel(app) {
    var value=""
    var listMovie=MutableLiveData<List<Popular>>()

    init {
        getPopularList()
    }

    fun getPopularList() {

        viewModelScope.launch() {
            try {
                listMovie.value = MovieApi.RETROFIT_SERVICE.getPopularList().movieList
                value = "Success: ${listMovie.value!!.size} Movie retrieved"
            } catch (e: Exception) {
                value = "Failure: ${e.message}"
            }

        }
    }

}