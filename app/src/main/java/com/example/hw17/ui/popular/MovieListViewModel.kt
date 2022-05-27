package com.example.hw17.ui.popular

import android.app.Application
import android.widget.Toast
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

class MovieListViewModel(var app:Application):AndroidViewModel(app) {
    var db = Repository.initDB(app.applicationContext)
    var value=""
    var listMovie=MutableLiveData<List<Movie>>()
    var movie=MutableLiveData<Detail>()


    init {
        getPopularList()
    }

    fun getPopularList() {

        viewModelScope.launch() {
            try {
                listMovie.value = Repository.getPopularList()
                value = "Success: ${listMovie.value!!.size} Movie retrieved"
            } catch (e: Exception) {
                value = "Failure: ${e.message}"
                Toast.makeText(app.applicationContext,e.message,Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun getMovieDetail(movieId:Int): LiveData<Detail> {
        viewModelScope.launch {
            try{
                movie.value=Repository.getMovieDetail(movieId)
            }
            catch (e:Exception){
                Toast.makeText(app.applicationContext,e.message,Toast.LENGTH_LONG).show()
            }
        }
        return movie
    }

    fun getVideo(id:Int):LiveData<List<Video>>{
        var videoList=MutableLiveData<List<Video>>()
        try{
            viewModelScope.launch {
                videoList.value=Repository.getVideo(id).videos
            }
        }
        catch (e:Exception){
            Toast.makeText(app.applicationContext,e.message,Toast.LENGTH_SHORT).show()
        }

        return videoList
    }

}