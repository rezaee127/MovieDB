package com.example.hw17.data

import com.example.hw17.models.ComingSoon
import com.example.hw17.models.Detail
import com.example.hw17.models.Popular
import com.example.hw17.models.Trailer
import com.example.hw17.network.MovieApi

object Repository {

    suspend fun getPopularList():Popular{
        return MovieApi.retrofitService.getPopularList()
    }



    suspend fun getComingSoonList():ComingSoon{
        return MovieApi.retrofitService.getComingSoonList()
    }


    suspend fun getSearchedMovie(movieName:String):Popular{
        return MovieApi.retrofitService.getSearchedMovie(movieName)
    }

    suspend fun getMovieDetail(movieId:Int): Detail{
        return MovieApi.retrofitService.getMovieDetail(movieId)
    }

    suspend fun getVideo(id:Int):Trailer{
        return MovieApi.retrofitService.getVideo(id)
    }
}
