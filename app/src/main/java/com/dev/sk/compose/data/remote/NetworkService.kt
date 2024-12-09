package com.dev.sk.compose.data.remote

import com.dev.sk.compose.data.remote.model.MovieDTO
import com.dev.sk.compose.data.remote.model.MovieResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkService {

    @GET("search/movie")
    suspend fun searchMovie(@Query("query") query: String): MovieResponseDTO

    @GET("trending/movie/{time_window}")
    suspend fun getTrendingMovies(@Path("time_window") timeWindow: String): MovieResponseDTO

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") movieId: Int): MovieDTO
}