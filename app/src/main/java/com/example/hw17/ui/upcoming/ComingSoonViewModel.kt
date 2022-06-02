package com.example.hw17.ui.upcoming

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw17.data.Repository
import com.example.hw17.models.ComingSoonMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComingSoonViewModel @Inject constructor(private val repository: Repository): ViewModel() {

     var listOfComingSoon=MutableLiveData<List<ComingSoonMovie>>()

    init {
        getComingSoonList()
    }

    fun getComingSoonList(){
        viewModelScope.launch {
            try {
                listOfComingSoon.value= repository.getComingSoonList()

            }catch (e:Exception){

            }
        }
    }
}