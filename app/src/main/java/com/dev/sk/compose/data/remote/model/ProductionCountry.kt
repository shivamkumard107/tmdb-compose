package com.dev.sk.compose.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductionCountry(@SerialName("name") val name: String)
