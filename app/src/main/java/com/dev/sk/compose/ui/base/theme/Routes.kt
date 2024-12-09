package com.dev.sk.compose.ui.base.theme

import com.dev.sk.compose.repository.model.Movie
import kotlinx.serialization.Serializable

@Serializable
data object MoviesListRoute

@Serializable
data class MovieDetailsRoute (
    val movieDetails: Movie
)