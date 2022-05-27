package com.example.hw17.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hw17.models.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(Movies: List<Movie>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(Movies: List<Movie>)


    @Query("SELECT * FROM Movie")
    fun getMovieList(): List<Movie>
}