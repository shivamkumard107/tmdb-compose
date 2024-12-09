package com.dev.sk.compose.source.local

import com.dev.sk.compose.data.remote.model.MovieDTO
import com.dev.sk.compose.data.remote.model.MovieResponseDTO


interface MovieDataSource {
    suspend fun getTrendingMovies(timeWindow: String): Result<MovieResponseDTO>

    suspend fun getMovieDetails(movieId: Int): Result<MovieDTO>
}

class LocalDataSource : MovieDataSource {

    override suspend fun getTrendingMovies(timeWindow: String): Result<MovieResponseDTO> {
        TODO()
    }

    override suspend fun getMovieDetails(movieId: Int): Result<MovieDTO> {
        TODO("Not yet implemented")
    }
}