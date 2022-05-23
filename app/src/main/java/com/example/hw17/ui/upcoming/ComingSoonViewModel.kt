package com.example.hw17.ui.upcoming

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw17.data.Repository
import com.example.hw17.models.Movie
import kotlinx.coroutines.launch
import java.lang.Exception

class ComingSoonViewModel:ViewModel() {

     var listOfComingSoon=MutableLiveData<List<Movie>>()

    init {
        getComingSoonList()
    }

    fun getComingSoonList(){
        viewModelScope.launch {
            try {
                listOfComingSoon.value= Repository.getComingSoonList().movies

            }catch (e:Exception){

            }
        }
    }
}