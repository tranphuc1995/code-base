package com.phucth.mycodebase.presentation.di

import com.phucth.mycodebase.domain.repository.FilmRepository
import com.phucth.mycodebase.domain.usecases.GetListFilmUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
class UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetPopulationUsUseCase(filmRepository: FilmRepository) =
        GetListFilmUseCase(filmRepository)
}