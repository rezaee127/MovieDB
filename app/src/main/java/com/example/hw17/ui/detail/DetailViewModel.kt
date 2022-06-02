package com.example.hw17.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw17.data.Repository
import com.example.hw17.models.Detail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: Repository):ViewModel() {

    var movie=MutableLiveData<Detail>()

    fun getMovieDetail(movieId:Int): LiveData<Detail> {
        viewModelScope.launch {
            try{
                movie.value=repository.getMovieDetail(movieId)
            }
            catch (e:Exception){

            }
        }
        return movie
    }

}