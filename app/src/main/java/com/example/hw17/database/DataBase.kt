package com.example.hw17.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hw17.models.ComingSoonMovie
import com.example.hw17.models.Movie

@Database(entities = [Movie::class, ComingSoonMovie::class], version = 4)
abstract class AppDatabase : RoomDatabase() {
    abstract fun comingSoonMovieDao(): ComingSoonMovieDao
    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getMyDataBase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance

            synchronized(AppDatabase::class) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "MyDB"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }


        fun destroyDataBase() {
            INSTANCE = null
        }

    }
}