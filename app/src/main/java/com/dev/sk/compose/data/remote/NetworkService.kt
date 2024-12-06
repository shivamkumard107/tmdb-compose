package com.dev.sk.compose.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkService {

    @GET("search/movie")
    fun searchMovie(@Query("query") query: String)

    @GET("trending/movie/{time_window}")
    fun getTrendingMovies(@Path("time_window") timeWindow: String);
}