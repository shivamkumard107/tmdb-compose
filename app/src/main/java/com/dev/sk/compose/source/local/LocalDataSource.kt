package com.dev.sk.compose.source.local

import com.dev.sk.compose.data.model.Movie
import com.dev.sk.compose.data.model.MovieResponse


interface MovieDataSource {
    suspend fun getTrendingMovies(timeWindow: String): Result<MovieResponse>

    suspend fun getMovieDetails(movieId: Int): Result<Movie>
}

class LocalDataSource : MovieDataSource {

    override suspend fun getTrendingMovies(timeWindow: String): Result<MovieResponse> {
        TODO()
    }

    override suspend fun getMovieDetails(movieId: Int): Result<Movie> {
        TODO("Not yet implemented")
    }
}