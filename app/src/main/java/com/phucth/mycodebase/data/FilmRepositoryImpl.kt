package com.phucth.mycodebase.data

import com.phucth.base.mapper.mapToModelUi
import com.phucth.base.model.ResultModelUi
import com.phucth.base.service.RepositoryBase
import com.phucth.mycodebase.data.api.FilmApi
import com.phucth.mycodebase.domain.mapper.MapToListFilmModelUi
import com.phucth.mycodebase.domain.repository.FilmRepository
import com.phucth.mycodebase.presentation.model_ui.FilmModelUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class FilmRepositoryImpl(private val filmApi: FilmApi) : FilmRepository, RepositoryBase() {
    override suspend fun getListFilm(): Flow<ResultModelUi<List<FilmModelUi>>> {
        return safeApiCall { filmApi.getListFilm() }.map { resultFromApi ->
            resultFromApi.mapToModelUi(
                functionMap = MapToListFilmModelUi::map
            )
        }
    }
}