package com.dev.sk.compose.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _userQuery = MutableStateFlow("")
    private val _trendingList: MutableStateFlow<MoviesUiState> =
        MutableStateFlow(value = MoviesUiState())
    val trendingList: StateFlow<MoviesUiState> = _trendingList

    init {
        fetchTrendingNews()
    }

    private fun fetchTrendingNews() {
        // fetch News
    }

    fun searchQuery(query: String) {
        _userQuery.value = query
    }


    private fun handleUserQueryDebounce() {

    }
}