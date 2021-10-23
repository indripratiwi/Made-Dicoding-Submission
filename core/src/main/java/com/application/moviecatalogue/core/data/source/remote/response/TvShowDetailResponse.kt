package com.application.moviecatalogue.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowDetailResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val title: String,

    @field:SerializedName("vote_average")
    val score: Double,

    @field:SerializedName("first_air_date")
    val release: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("backdrop_path")
    val backdrop: String,

    @field:SerializedName("poster_path")
    val poster: String
)
