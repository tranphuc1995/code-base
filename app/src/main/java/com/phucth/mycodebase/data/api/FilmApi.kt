package com.phucth.mycodebase.data.api

import com.phucth.mycodebase.data.model_api.FilmModelApi
import retrofit2.Response
import retrofit2.http.GET

interface FilmApi {
    @GET("/3/discover/movie")
    suspend fun getListFilm(): Response<FilmModelApi>
}