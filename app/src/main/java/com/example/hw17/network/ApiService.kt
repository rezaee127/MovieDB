package com.example.hw17.network


import com.example.hw17.models.Movies
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3/movie/"
private const val API_KEY="2a7f94a255b840a7645d6759994986d6"



private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory .create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface ApiService {

    @GET("popular")
    suspend fun getPopularList(
        @Query("api_key")api:String=API_KEY
    ): Movies

}


object MovieApi {
    val RETROFIT_SERVICE : ApiService by lazy {
        retrofit.create(ApiService::class.java) }
}