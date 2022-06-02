package com.example.hw17.di

import android.content.Context
import androidx.room.Room
import com.example.hw17.database.AppDatabase
import com.example.hw17.database.AppDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Module {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context):AppDatabase{
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, DATABASE_NAME
        )
            //.allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

}