package com.dev.sk.compose.ui

import com.dev.sk.compose.repository.model.Movie

sealed class UiState {
    data object Loading : UiState()
    data object Success : UiState()
    data class Error(val message: String) : UiState()
}

data class MoviesUiState(
    val uiState: UiState = UiState.Loading,
    val list: List<Movie>? = null
)