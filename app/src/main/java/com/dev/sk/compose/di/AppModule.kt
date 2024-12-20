package com.dev.sk.compose.di

import com.dev.sk.compose.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @ApiBaseUrl
    fun getBaseUrl(): String {
        return "https://api.themoviedb.org/3/"
    }

    @Provides
    @ApiKey
    fun getApiKey(): String {
        return BuildConfig.API_KEY
    }
}
