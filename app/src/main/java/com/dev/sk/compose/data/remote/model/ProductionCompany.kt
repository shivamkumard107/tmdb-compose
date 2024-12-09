package com.dev.sk.compose.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductionCompany(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String
)