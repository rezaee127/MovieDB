package com.example.hw17.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Trailer(
    @Json(name = "id")
    val id: Int,
    @Json(name = "results")
    val videos: List<Video>
)