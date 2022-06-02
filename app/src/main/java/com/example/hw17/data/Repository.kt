package com.example.hw17.data

import com.example.hw17.models.*
import javax.inject.Inject

class Repository @Inject constructor(private val localDataSource: LocalDataSource,private val remoteDataSource: RemoteDataSource) {

    suspend fun getPopularList(): List<Movie> {
        var listOfMovie: List<Movie>
        try {
            listOfMovie =remoteDataSource.getPopularList().movieList
            localDataSource.deleteAllMovie()
            localDataSource.insertAllMovie(listOfMovie)
        } catch (e: Exception) {
            listOfMovie = localDataSource.getMovieList()
        }
        return listOfMovie
    }

    suspend fun getComingSoonList(): List<ComingSoonMovie> {
        var listOfMovie: List<ComingSoonMovie>
        try {
            listOfMovie = remoteDataSource.getComingSoonList().movies
            localDataSource.deleteAllComingSoonMovie()
            localDataSource.insertAllComingSoonMovie(listOfMovie)
        } catch (e: Exception) {
            listOfMovie = localDataSource.getComingSoonMovieList()
        }
        return listOfMovie
    }


    suspend fun getSearchedMovie(movieName: String): Popular {
        return remoteDataSource.getSearchedMovie(movieName)
    }

    suspend fun getMovieDetail(movieId: Int): Detail {
        return remoteDataSource.getMovieDetail(movieId)
    }

    suspend fun getVideo(id: Int): Trailer {
        return remoteDataSource.getVideo(id)
    }
}
