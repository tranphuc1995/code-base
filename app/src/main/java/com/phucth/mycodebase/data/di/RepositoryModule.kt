package com.phucth.mycodebase.data.di

import com.phucth.mycodebase.data.FilmRepositoryImpl
import com.phucth.mycodebase.data.api.FilmApi
import com.phucth.mycodebase.domain.repository.FilmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@InstallIn(ActivityRetainedComponent::class)
@Module
class RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideUsNationalRepository(filmApi: FilmApi): FilmRepository {
        return FilmRepositoryImpl(filmApi)
    }
}