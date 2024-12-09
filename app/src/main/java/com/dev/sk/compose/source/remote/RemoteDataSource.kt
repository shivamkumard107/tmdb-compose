package com.dev.sk.compose.source.remote

import com.dev.sk.compose.data.model.Movie
import com.dev.sk.compose.data.model.MovieResponse
import com.dev.sk.compose.data.remote.NetworkService
import com.dev.sk.compose.source.local.MovieDataSource
import com.dev.sk.compose.utils.catchAsync

interface RemoteDataSource : MovieDataSource {
    suspend fun searchMovie(query: String): Result<MovieResponse>
}

class DefaultRemoteDataSource(private val networkService: NetworkService) : RemoteDataSource {

    override suspend fun searchMovie(query: String): Result<MovieResponse> {
        val response = catchAsync { networkService.searchMovie(query) }

        response.fold(
            onSuccess = { movies -> return Result.success(movies) },
            onFailure = { th -> return Result.failure(th) }
        )
    }

    override suspend fun getTrendingMovies(timeWindow: String): Result<MovieResponse> {
        val response = catchAsync { networkService.getTrendingMovies(timeWindow) }

        response.onFailure {
            return Result.failure(it)
        }
        response.onSuccess {
            return Result.success(it)
        }
        return Result.failure(Exception("Server Error"))
    }

    override suspend fun getMovieDetails(movieId: Int): Result<Movie> {
        TODO("Not yet implemented")
    }


}