package com.example.hw17.network


import com.example.hw17.models.ComingSoon
import com.example.hw17.models.Detail
import com.example.hw17.models.Popular
import com.example.hw17.models.Trailer
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


private const val API_KEY="2a7f94a255b840a7645d6759994986d6"
const val BASE_URL = "https://api.themoviedb.org/3/"





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


    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id")movieId:Int,
        @Query("api_key")key:String= API_KEY
    ): Detail


    @GET("movie/{movie_id}/videos")
    suspend fun getVideo(
        @Path("movie_id")id:Int,
        @Query("api_key")key:String= API_KEY
    ):Trailer
}

