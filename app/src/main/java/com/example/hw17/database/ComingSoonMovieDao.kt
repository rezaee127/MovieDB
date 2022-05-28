package com.example.hw17.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hw17.models.ComingSoonMovie

@Dao
interface ComingSoonMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertAll(comingSoonMovies: List<ComingSoonMovie>)

   @Query("DELETE FROM ComingSoonMovie")
   suspend fun deleteAll()

    @Query("SELECT * FROM ComingSoonMovie")
    suspend fun getComingSoonMovieList(): List<ComingSoonMovie>
}