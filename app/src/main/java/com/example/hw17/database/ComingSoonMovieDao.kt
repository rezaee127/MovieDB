package com.example.hw17.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hw17.models.ComingSoonMovie

@Dao
interface ComingSoonMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(comingSoonMovies: List<ComingSoonMovie>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(comingSoonMovies: List<ComingSoonMovie>)


    @Query("SELECT * FROM ComingSoonMovie")
    fun getComingSoonMovieList(): List<ComingSoonMovie>
}