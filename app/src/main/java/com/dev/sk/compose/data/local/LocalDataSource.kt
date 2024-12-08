package com.dev.sk.compose.data.local

import com.dev.sk.compose.data.model.MovieResponse


interface MovieDataSource {
    // get trending movie
    suspend fun searchMovie(query: String): Result<MovieResponse>

    suspend fun getTrendingMovies(timeWindow: String): Result<MovieResponse>
}

class LocalDataSource : MovieDataSource {
    override suspend fun searchMovie(query: String): Result<MovieResponse> {

    }

    override suspend fun getTrendingMovies(timeWindow: String): Result<MovieResponse> {

    }
}