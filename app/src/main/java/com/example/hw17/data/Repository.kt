package com.example.hw17.data

import com.example.hw17.models.*
import com.example.hw17.network.MovieApi

object Repository {

    suspend fun getPopularList():Popular{
        return MovieApi.retrofitService.getPopularList()
    }



    suspend fun getComingSoonList():List<Movie>{
        return MovieApi.retrofitService.getComingSoonList().movies
    }


    suspend fun getSearchedMovie(movieName:String):List<Movie>{
        return MovieApi.retrofitService.getSearchedMovie(movieName).movieList
    }

    suspend fun getMovieDetail(movieId:Int): Detail{
        return MovieApi.retrofitService.getMovieDetail(movieId)
    }

    suspend fun getVideo(id:Int):Trailer{
        return MovieApi.retrofitService.getVideo(id)
    }
}
