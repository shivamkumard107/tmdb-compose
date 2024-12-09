package com.dev.sk.compose.repository.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val posterPath: String,
    val voteAverage: Int,
    val voteCount: Int,
    val genres: List<Genre>,
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: String,
    val budget: Int,
    val homepage: String,
    val imdbId: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalTitle: String,
    val popularity: Double,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountry>,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val video: Boolean
)

@Serializable
data class Genre(val id: Int, val name: String)

@Serializable
data class ProductionCompany(val id: String, val name: String)

@Serializable
data class ProductionCountry(val iso_3166_1: String?, val name: String)

@Serializable
data class SpokenLanguage(val iso_639_1: String, val name: String)