package com.example.hw17.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://api.themoviedb.org/3/movie/popular?api_key=2a7f94a255b840a7645d6759994986d6"
   // "https://android-kotlin-fun-mars-server.appspot.com"
//"https://api.themoviedb.org/3/movie/popular?api_key=2a7f94a255b840a7645d6759994986d6"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory .create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface MovieApiService {

    @GET()
    suspend fun getMovieList(): List<com.example.hw17.models.Result>


    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}


object MovieApi {
    val RETROFIT_SERVICE : MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java) }
}