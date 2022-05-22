package com.example.hw17.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movies(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val movieList: List<Popular>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)