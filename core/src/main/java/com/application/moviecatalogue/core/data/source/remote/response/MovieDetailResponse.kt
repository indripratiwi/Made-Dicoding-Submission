package com.application.moviecatalogue.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("vote_average")
    val score: Double,

    @field:SerializedName("release_date")
    val release: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("backdrop_path")
    val backdrop: String,

    @field:SerializedName("poster_path")
    val poster: String
)