package com.example.hw17.di

import android.content.Context
import androidx.room.Room
import com.example.hw17.database.AppDatabase
import com.example.hw17.database.AppDatabase.Companion.DATABASE_NAME
import com.example.hw17.network.ApiService
import com.example.hw17.network.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
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


    @Singleton
    @Provides
    fun provideApiService(): ApiService {


        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(client)
            .build()

        return retrofit.create(ApiService::class.java)
    }


}