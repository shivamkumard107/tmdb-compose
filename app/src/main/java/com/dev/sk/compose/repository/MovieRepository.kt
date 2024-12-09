package com.dev.sk.compose.repository

import com.dev.sk.compose.data.remote.model.Movie
import com.dev.sk.compose.source.local.MovieDataSource
import com.dev.sk.compose.source.remote.RemoteDataSource
import com.dev.sk.compose.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


interface MovieRepository {
    suspend fun getTrendingMovies(timeWindow: String): Flow<DataState<List<Movie>>>

    suspend fun getMovieDetails(id: Int): Flow<DataState<Movie>>

    suspend fun searchMovie(query: String): Flow<DataState<List<Movie>>>
}

class DefaultMovieRepository @Inject constructor(
    private val networkService: RemoteDataSource,
    private val localDataSource: MovieDataSource
) : MovieRepository {


    override suspend fun getTrendingMovies(timeWindow: String): Flow<DataState<List<Movie>>> {
        return flow<DataState<List<Movie>>> {
            emit(DataState.Loading)

            val result = networkService.getTrendingMovies(timeWindow)
            result.fold(
                onSuccess = { emit(DataState.Success(it.results)) },
                onFailure = { th -> emit(DataState.Error(data = emptyList(), th)) }
            )
        }.catch { e -> emit(DataState.Error(null, e)) }
    }

    override suspend fun getMovieDetails(id: Int): Flow<DataState<Movie>> {
        return flow {
            emit(DataState.Loading)

            val result = networkService.getMovieDetails(id)
            result.fold(
                onSuccess = {
                    emit(DataState.Success(it))
                },
                onFailure = { e -> emit(DataState.Error(null, e)) }
            )
        }.catch {
            emit(DataState.Error(null, it))
        }
    }

    override suspend fun searchMovie(query: String): Flow<DataState<List<Movie>>> {
        return flow {
            emit(DataState.Loading)

            val result = networkService.searchMovie(query)
            result.fold(
                onSuccess = { emit(DataState.Success(it.results)) },
                onFailure = { emit(DataState.Error(null, it)) }
            )
        }.catch {
            emit(DataState.Error(null, it))
        }
    }


}