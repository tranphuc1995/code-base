package com.phucth.mycodebase.data.api

import com.phucth.mycodebase.data.model_api.PopulationUsModelApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UsApi {
    @GET("/api/data")
    suspend fun getPopulationFromUs(
        @Query("drilldowns") drilldowns: String,
        @Query("measures") measures: String
    ): Response<PopulationUsModelApi>
}