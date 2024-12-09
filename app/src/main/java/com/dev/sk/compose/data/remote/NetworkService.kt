package com.dev.sk.compose.data.remote

import com.dev.sk.compose.data.remote.model.Movie
import com.dev.sk.compose.data.remote.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkService {

    @GET("search/movie")
    suspend fun searchMovie(@Query("query") query: String): MovieResponse

    @GET("trending/movie/{time_window}")
    suspend fun getTrendingMovies(@Path("time_window") timeWindow: String): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") movieId: Int): Movie
}