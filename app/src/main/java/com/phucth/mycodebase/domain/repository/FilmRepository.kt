package com.phucth.mycodebase.domain.repository

import com.phucth.base.model.ResultModelUi
import com.phucth.mycodebase.presentation.model_ui.FilmModelUi
import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    suspend fun getListFilm(): Flow<ResultModelUi<List<FilmModelUi>>>
}