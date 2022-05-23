package com.example.hw17.network


import com.example.hw17.models.ComingSoon
import com.example.hw17.models.Popular
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val API_KEY="2a7f94a255b840a7645d6759994986d6"



private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory .create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularList(@Query("api_key")api:String=API_KEY): Popular


    @GET("movie/upcoming")
    suspend fun getComingSoonList(@Query("api_key")key:String= API_KEY):ComingSoon

    @GET("search/movie")
    suspend fun getSearchedMovie(
        @Query("query")movieName:String,
        @Query("api_key")key:String= API_KEY
    ):Popular
}


object MovieApi {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java) }
}