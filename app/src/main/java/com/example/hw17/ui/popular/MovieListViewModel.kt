package com.example.hw17.ui.popular

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.hw17.data.Repository
import com.example.hw17.models.Detail
import com.example.hw17.models.Movie
import com.example.hw17.models.Video
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MovieListViewModel(app:Application):AndroidViewModel(app) {
    var value=""
    var listMovie=MutableLiveData<List<Movie>>()
    var movie=MutableLiveData<Detail>()


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

    fun getMovieDetail(movieId:Int): LiveData<Detail> {
        viewModelScope.async {
            try{
                movie.value=Repository.getMovieDetail(movieId)
            }
            catch (e: java.lang.Exception){

            }
        }
        return movie
    }

    fun getVideo(id:Int):LiveData<List<Video>>{
        var videoList=MutableLiveData<List<Video>>()
        viewModelScope.launch {
            videoList.value=Repository.getVideo(id).videos
        }
        return videoList
    }

}