package com.example.hw17

import com.example.hw17.models.Popular
import com.example.hw17.network.MovieApi

object Repository {

    suspend fun getPopularList():Popular{
        return MovieApi.retrofitService.getPopularList()
    }

}
