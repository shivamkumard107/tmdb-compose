package com.dev.sk.compose.repository.model

import kotlinx.serialization.Serializable

@Serializable
data class TrendingMovies(val movies: List<Movie>)