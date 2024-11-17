package com.phucth.mycodebase.domain.usecases

import com.phucth.base.model.ResultModelUi
import com.phucth.base.usecase.UseCaseBase
import com.phucth.mycodebase.domain.repository.FilmRepository
import com.phucth.mycodebase.presentation.model_ui.FilmModelUi
import kotlinx.coroutines.flow.Flow

class GetListFilmUseCase(private val filmRepository: FilmRepository) :
    UseCaseBase<Any, List<FilmModelUi>> {
    override suspend fun execute(paramRequest: Any?): Flow<ResultModelUi<List<FilmModelUi>>> {
        return filmRepository.getListFilm()
    }
}