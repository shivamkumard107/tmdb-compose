package com.dev.sk.compose.di

import com.dev.sk.compose.repository.DefaultMovieRepository
import com.dev.sk.compose.repository.MovieRepository
import com.dev.sk.compose.source.local.LocalDataSource
import com.dev.sk.compose.source.local.MovieDataSource
import com.dev.sk.compose.source.remote.DefaultRemoteDataSource
import com.dev.sk.compose.source.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface HomeModule {

    @Binds
    fun bindLocalDataSource(localDataSource: LocalDataSource): MovieDataSource

    @Binds
    fun bindNetworkDataSource(networkDataSource: DefaultRemoteDataSource): RemoteDataSource

    @Binds
    fun bindCurrencyRepository(currencyRepository: DefaultMovieRepository): MovieRepository


}