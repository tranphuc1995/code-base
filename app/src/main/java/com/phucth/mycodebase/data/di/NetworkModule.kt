package com.phucth.mycodebase.data.di

import com.phucth.base.service.ClientBase
import com.phucth.mycodebase.BuildConfig
import com.phucth.mycodebase.data.api.FilmApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import okhttp3.OkHttpClient

@InstallIn(ActivityRetainedComponent::class)
@Module
class NetworkModule {

    @Provides
    @ActivityRetainedScoped
    fun provideOkHttpClient(headerInterceptor: HeaderInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(headerInterceptor).build()
    }

    @Provides
    @ActivityRetainedScoped
    fun provideFilmApi(okHttpClient: OkHttpClient): FilmApi {
        return ClientBase(BuildConfig.BASE_URL, FilmApi::class.java).createClientApi(okHttpClient)
    }
}