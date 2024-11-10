package com.phucth.mycodebase.data.di

import com.phucth.mycodebase.Config
import com.phucth.mycodebase.data.api.UsApi
import com.phucth.service.ClientBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideUsApi(): UsApi {
        return ClientBase(Config.BASE_URL, UsApi::class.java).createClientApi()
    }
}