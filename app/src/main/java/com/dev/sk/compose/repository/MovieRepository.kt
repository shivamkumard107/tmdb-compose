package com.dev.sk.compose.repository

import com.dev.sk.compose.data.remote.model.MovieDTO
import com.dev.sk.compose.repository.model.Genre
import com.dev.sk.compose.repository.model.Movie
import com.dev.sk.compose.repository.model.ProductionCompany
import com.dev.sk.compose.repository.model.ProductionCountry
import com.dev.sk.compose.repository.model.SpokenLanguage
import com.dev.sk.compose.source.local.MovieDataSource
import com.dev.sk.compose.source.remote.RemoteDataSource
import com.dev.sk.compose.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


interface MovieRepository {
    suspend fun getTrendingMovies(timeWindow: String = "day"): Flow<DataState<List<Movie>>>

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
                onSuccess = { it -> emit(DataState.Success(it.results.map { it.toMovie() })) },
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
                    emit(DataState.Success(it.toMovie()))
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
                onSuccess = { it -> emit(DataState.Success(it.results.map { it.toMovie() })) },
                onFailure = { emit(DataState.Error(null, it)) }
            )
        }.catch {
            emit(DataState.Error(null, it))
        }
    }


    private fun MovieDTO.toMovie(): Movie {
        return Movie(
            id = this.id,
            title = this.title,
            overview = this.overview,
            releaseDate = this.releaseDate,
            posterPath = this.posterPath,
            voteAverage = this.voteAverage,
            voteCount = this.voteCount,
            genres = this.genres.map { Genre(it.id, it.name) },
            adult = this.adult,
            backdropPath = this.backdropPath,
            belongsToCollection = this.belongsToCollection,
            budget = this.budget,
            homepage = this.homepage,
            imdbId = this.imdbId,
            originCountry = this.originCountry,
            originalLanguage = this.originalLanguage,
            originalTitle = this.originalTitle,
            popularity = this.popularity,
            productionCompanies = this.productionCompanies.map {
                ProductionCompany(
                    it.id,
                    it.name
                )
            },
            productionCountries = this.productionCountries.map {
                ProductionCountry(
                    null,
                    it.name
                )
            },
            revenue = this.revenue,
            runtime = this.runtime,
            spokenLanguages = this.spokenLanguages.map { SpokenLanguage(it.iso6391, it.name) },
            status = this.status,
            tagline = this.tagline,
            video = this.video
        )
    }

}