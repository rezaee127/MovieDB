package com.example.hw17.data

import com.example.hw17.database.AppDatabase
import com.example.hw17.models.*
import com.example.hw17.network.MovieApi
import javax.inject.Inject

class Repository @Inject constructor(private val db: AppDatabase) {



    suspend fun getPopularList(): List<Movie> {
        var listOfMovie: List<Movie>
        try {
            listOfMovie = MovieApi.retrofitService.getPopularList().movieList
            db.movieDao().deleteAll()
            db.movieDao().insertAll(listOfMovie)
        } catch (e: Exception) {
            listOfMovie = db.movieDao().getMovieList()
        }
        return listOfMovie
    }

    suspend fun getComingSoonList(): List<ComingSoonMovie> {
        var listOfMovie: List<ComingSoonMovie>
        try {
            listOfMovie = MovieApi.retrofitService.getComingSoonList().movies
            db.comingSoonMovieDao().deleteAll()
            db.comingSoonMovieDao().insertAll(listOfMovie)
        } catch (e: Exception) {
            listOfMovie = db.comingSoonMovieDao().getComingSoonMovieList()
        }
        return listOfMovie
    }


    suspend fun getSearchedMovie(movieName: String): Popular {
        return MovieApi.retrofitService.getSearchedMovie(movieName)
    }

    suspend fun getMovieDetail(movieId: Int): Detail {
        return MovieApi.retrofitService.getMovieDetail(movieId)
    }

    suspend fun getVideo(id: Int): Trailer {
        return MovieApi.retrofitService.getVideo(id)
    }
}
