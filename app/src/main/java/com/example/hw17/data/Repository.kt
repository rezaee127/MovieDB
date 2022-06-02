package com.example.hw17.data

import com.example.hw17.database.AppDatabase
import com.example.hw17.models.*
import com.example.hw17.network.ApiService
import javax.inject.Inject

class Repository @Inject constructor(private val db: AppDatabase,private val apiService: ApiService) {



    suspend fun getPopularList(): List<Movie> {
        var listOfMovie: List<Movie>
        try {
            listOfMovie =apiService.getPopularList().movieList
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
            listOfMovie = apiService.getComingSoonList().movies
            db.comingSoonMovieDao().deleteAll()
            db.comingSoonMovieDao().insertAll(listOfMovie)
        } catch (e: Exception) {
            listOfMovie = db.comingSoonMovieDao().getComingSoonMovieList()
        }
        return listOfMovie
    }


    suspend fun getSearchedMovie(movieName: String): Popular {
        return apiService.getSearchedMovie(movieName)
    }

    suspend fun getMovieDetail(movieId: Int): Detail {
        return apiService.getMovieDetail(movieId)
    }

    suspend fun getVideo(id: Int): Trailer {
        return apiService.getVideo(id)
    }
}
