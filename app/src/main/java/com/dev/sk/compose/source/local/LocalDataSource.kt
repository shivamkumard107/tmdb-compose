package com.dev.sk.compose.source.local

import com.dev.sk.compose.data.remote.model.MovieDTO
import com.dev.sk.compose.data.remote.model.MovieResponseDTO
import javax.inject.Inject


interface MovieDataSource {
    suspend fun getTrendingMovies(timeWindow: String): Result<MovieResponseDTO>

    suspend fun getMovieDetails(movieId: Int): Result<MovieDTO>
}

class LocalDataSource @Inject constructor() : MovieDataSource {

    override suspend fun getTrendingMovies(timeWindow: String): Result<MovieResponseDTO> {
        TODO()
    }

    override suspend fun getMovieDetails(movieId: Int): Result<MovieDTO> {
        TODO("Not yet implemented")
    }
}