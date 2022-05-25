package com.example.hw17.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hw17.models.ComingSoonMovie

@Dao
interface ComingSoonMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(comingSoonMovies: List<ComingSoonMovie>)


    @Query("SELECT * FROM ComingSoonMovie")
    fun getComingSoonMovieList(): List<ComingSoonMovie>
}