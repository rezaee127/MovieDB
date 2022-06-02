package com.example.hw17.data

import com.example.hw17.models.ComingSoon
import com.example.hw17.models.Detail
import com.example.hw17.models.Popular
import com.example.hw17.models.Trailer
import com.example.hw17.network.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService){

    suspend fun getPopularList(): Popular{
        return apiService.getPopularList()
    }

    suspend fun getComingSoonList(): ComingSoon{
        return apiService.getComingSoonList()
    }

    suspend fun getSearchedMovie(movieName:String): Popular{
        return apiService.getSearchedMovie(movieName)
    }

    suspend fun getMovieDetail(movieId:Int): Detail{
        return apiService.getMovieDetail(movieId)
    }


    suspend fun getVideo(id:Int): Trailer{
        return apiService.getVideo(id)
    }
}