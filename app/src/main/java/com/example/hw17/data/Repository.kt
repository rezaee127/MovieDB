package com.example.hw17.data

import android.content.Context
import com.example.hw17.database.AppDatabase
import com.example.hw17.database.ComingSoonMovieDao
import com.example.hw17.database.MovieDao
import com.example.hw17.models.*
import com.example.hw17.network.MovieApi
import java.lang.Exception

object Repository {
    lateinit var db: AppDatabase
    lateinit var comingSoonMovieDao: ComingSoonMovieDao
    lateinit var movieDao: MovieDao


    fun initDB(context: Context): AppDatabase {
        db = AppDatabase.getMyDataBase(context)
        comingSoonMovieDao = db.comingSoonMovieDao()
        movieDao = db.movieDao()
        return db
    }

    suspend fun getPopularList():List<Movie>{
        var listOfMovie: List<Movie>
        try {
            listOfMovie=MovieApi.retrofitService.getPopularList().movieList
            movieDao.insertAll(listOfMovie)
        }catch (e:Exception){
            listOfMovie= movieDao.getMovieList()
        }
        return listOfMovie
    }

    suspend fun getComingSoonList():List<ComingSoonMovie>{
        var listOfMovie: List<ComingSoonMovie>
        try {
            listOfMovie=MovieApi.retrofitService.getComingSoonList().movies
            comingSoonMovieDao.insertAll(listOfMovie)
        }catch (e:Exception){
            listOfMovie= comingSoonMovieDao.getComingSoonMovieList()
        }
        return listOfMovie
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
