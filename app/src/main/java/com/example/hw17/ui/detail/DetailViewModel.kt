package com.example.hw17.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw17.data.Repository
import com.example.hw17.models.Detail
import com.example.hw17.models.Video
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailViewModel:ViewModel() {

    var movie=MutableLiveData<Detail>()

    fun getMovieDetail(movieId:Int): LiveData<Detail> {
        viewModelScope.launch {
            try{
                movie.value=Repository.getMovieDetail(movieId)
            }
            catch (e:Exception){

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