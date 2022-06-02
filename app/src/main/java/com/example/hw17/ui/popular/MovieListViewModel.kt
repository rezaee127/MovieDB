package com.example.hw17.ui.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw17.data.Repository
import com.example.hw17.models.Detail
import com.example.hw17.models.Movie
import com.example.hw17.models.Video
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieListViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    var value=""
    var listMovie=MutableLiveData<List<Movie>>()
    var movie=MutableLiveData<Detail>()


    init {
        getPopularList()
    }

    fun getPopularList() {

        viewModelScope.launch() {
            try {
                listMovie.value = repository.getPopularList()
                value = "Success: ${listMovie.value!!.size} Movie retrieved"
            } catch (e: Exception) {
                value = "Failure: ${e.message}"
                //Toast.makeText(app.applicationContext,e.message,Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun getMovieDetail(movieId:Int): LiveData<Detail> {
        viewModelScope.launch {
            try{
                movie.value=repository.getMovieDetail(movieId)
            }
            catch (e:Exception){
                //Toast.makeText(app.applicationContext,e.message,Toast.LENGTH_LONG).show()
            }
        }
        return movie
    }

    fun getVideo(id:Int):LiveData<List<Video>>{
        var videoList=MutableLiveData<List<Video>>()
        viewModelScope.launch {
            try {
                videoList.value = repository.getVideo(id).videos
            }
            catch (e: Exception) {
                //Toast.makeText(app.applicationContext, e.message, Toast.LENGTH_SHORT).show()
            }
        }
        return videoList
    }

}