package com.phucth.mycodebase.data.model_api

import com.google.gson.annotations.SerializedName

data class FilmModelApi(@SerializedName("results") val results: List<Result>?) {
    data class Result(
        @SerializedName("backdrop_path") val backdropPath: String? = "",
        @SerializedName("original_title") val originalTitle: String? = "",
        @SerializedName("overview") val overview: String? = ""
    )
}