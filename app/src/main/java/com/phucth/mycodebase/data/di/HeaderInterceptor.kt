package com.phucth.mycodebase.data.di

import com.phucth.mycodebase.Config
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request().newBuilder()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer ${Config.ACCESS_TOKEN}")
                .build()
        )
    }
}