package com.example.hw17.data

import com.example.hw17.database.AppDatabase
import com.example.hw17.models.ComingSoonMovie
import com.example.hw17.models.Movie
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val db: AppDatabase) {

    suspend fun deleteAllMovie(){
        db.movieDao().deleteAll()
    }

    suspend fun insertAllMovie(listOfMovie:List<Movie>){
        db.movieDao().insertAll(listOfMovie)
    }

    suspend fun getMovieList(): List<Movie>{
        return db.movieDao().getMovieList()
    }

    suspend fun deleteAllComingSoonMovie(){
        db.comingSoonMovieDao().deleteAll()
    }

    suspend fun insertAllComingSoonMovie(listOfComingSoonMovie:List<ComingSoonMovie>){
        db.comingSoonMovieDao().insertAll(listOfComingSoonMovie)
    }

    suspend fun getComingSoonMovieList(): List<ComingSoonMovie>{
        return db.comingSoonMovieDao().getComingSoonMovieList()
    }
}