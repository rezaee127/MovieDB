package com.example.hw17.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.hw17.models.Movie

interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(Movies: List<Movie>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(Movies: List<Movie>)


    @Query("SELECT * FROM Movie")
    fun getMovieList(): List<Movie>
}