package com.phucth.mycodebase.data.model_api

import com.google.gson.annotations.SerializedName

data class PopulationUsModelApi(@SerializedName("data") val data: List<Data>?) {
    data class Data(
        @SerializedName("Population") val population: String? = "",
        @SerializedName("ID Year") val year: String = ""
    )
}