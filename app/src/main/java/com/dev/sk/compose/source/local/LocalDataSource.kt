package com.dev.sk.compose.source.local

import com.dev.sk.compose.data.model.MovieResponse


interface MovieDataSource {
    // get trending movie
    suspend fun searchMovie(query: String): Result<MovieResponse>

    suspend fun getTrendingMovies(timeWindow: String): Result<MovieResponse>

    suspend fun getMovieDetails(movieId: Int):
}

class LocalDataSource : MovieDataSource {
    override suspend fun searchMovie(query: String): Result<MovieResponse> {
        TODO()
    }

    override suspend fun getTrendingMovies(timeWindow: String): Result<MovieResponse> {
        TODO()
    }
}