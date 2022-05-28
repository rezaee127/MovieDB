package com.example.hw17.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hw17.models.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(Movies: List<Movie>)

    @Query("DELETE FROM Movie")
    suspend fun deleteAll()


    @Query("SELECT * FROM Movie")
    suspend fun getMovieList(): List<Movie>
}