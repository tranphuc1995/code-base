package com.phucth.mycodebase.domain.mapper

import com.phucth.mycodebase.data.model_api.FilmModelApi
import com.phucth.mycodebase.presentation.model_ui.FilmModelUi

object MapToListFilmModelUi {
    fun map(filmModelApi: FilmModelApi?): List<FilmModelUi> {
        val result = arrayListOf<FilmModelUi>()
        filmModelApi?.results?.forEach { filmApi ->
            result.add(
                FilmModelUi(
                    posterUrl = filmApi.backdropPath ?: "",
                    title = filmApi.originalTitle ?: "",
                    overview = filmApi.overview ?: ""
                )
            )
        }
        return result
    }
}