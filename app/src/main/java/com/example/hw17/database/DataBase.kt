package com.example.hw17.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw17.models.ComingSoonMovie
import com.example.hw17.models.Movie

@Database(entities = [Movie::class, ComingSoonMovie::class], version = 4)
abstract class AppDatabase : RoomDatabase() {
    abstract fun comingSoonMovieDao(): ComingSoonMovieDao
    abstract fun movieDao(): MovieDao

    companion object {

        const val DATABASE_NAME="MyDB"

    }
}