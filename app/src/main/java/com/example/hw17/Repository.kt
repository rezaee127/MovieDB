package com.example.hw17

import com.example.hw17.models.Movies
import com.example.hw17.models.Popular
import com.example.hw17.network.ApiService
import com.example.hw17.network.MovieApi

object Repository {

    suspend fun getPopularList():Movies{
        return MovieApi.retrofitService.getPopularList()
    }

}
