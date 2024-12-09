package com.dev.sk.compose.repository.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int?,
    val title: String,
    val overview: String,
    val releaseDate: String?,
    val posterPath: String?,
    val voteAverage: Double?,
    val voteCount: Int?,
    val adult: Boolean?,
    val backdropPath: String?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val popularity: Double?,
    val video: Boolean?
)

@Serializable
data class Genre(val id: Int, val name: String)

@Serializable
data class ProductionCompany(val id: String, val name: String)

@Serializable
data class ProductionCountry(val iso_3166_1: String?, val name: String)

@Serializable
data class SpokenLanguage(val iso_639_1: String, val name: String)