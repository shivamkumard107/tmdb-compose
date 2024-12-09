package com.dev.sk.compose.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponseDTO(
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val results: List<MovieDTO>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
)