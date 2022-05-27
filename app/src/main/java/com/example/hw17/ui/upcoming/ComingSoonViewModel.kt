package com.example.hw17.ui.upcoming

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw17.data.Repository
import com.example.hw17.models.ComingSoonMovie
import com.example.hw17.models.Movie
import kotlinx.coroutines.launch
import java.lang.Exception

class ComingSoonViewModel:ViewModel() {

     var listOfComingSoon=MutableLiveData<List<ComingSoonMovie>>()

    init {
        getComingSoonList()
    }

    fun getComingSoonList(){
        viewModelScope.launch {
            try {
                listOfComingSoon.value= Repository.getComingSoonList()

            }catch (e:Exception){

            }
        }
    }
}