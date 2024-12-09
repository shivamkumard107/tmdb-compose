package com.dev.sk.compose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.sk.compose.repository.MovieRepository
import com.dev.sk.compose.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class MainViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {

    private val _userQuery = MutableStateFlow("")
    val userQuery = _userQuery.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _state = MutableStateFlow(MoviesUiState())
    val state = _state.asStateFlow()

    init {
        userQuery
            .debounce(DEBOUNCE_TIMEOUT)
            .onEach { query ->
                if (query.isBlank()) {
                    getMovies()
                } else {
                    searchMovies(query)
                }
            }
            .launchIn(viewModelScope)
    }

    fun onSearchQueryChange(query: String) {
        _userQuery.value = query
    }

    private fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.getTrendingMovies()
                .onEach { result ->
                    when (result) {
                        is DataState.Error -> _state.update {
                            it.copy(
                                uiState = UiState.Error(
                                    "${STATE_ERROR_MESSAGE}\n" +
                                            "${result.throwable}"
                                ),
                                list = emptyList()
                            )
                        }

                        DataState.Loading -> _state.update { it.copy(uiState = UiState.Loading) }

                        is DataState.Success -> _state.update {
                            it.copy(
                                list = result.data,
                                uiState = UiState.Success,
                            )
                        }
                    }
                }
        }
    }

    private fun searchMovies(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.searchMovie(query)
                .onEach { result ->
                    _isSearching.update { result is DataState.Loading }
                    when (result) {
                        is DataState.Error -> _state.update {
                            it.copy(
                                list = result.data ?: emptyList(),
                                uiState = UiState.Error("$STATE_ERROR_MESSAGE ${result.throwable}"),
                            )
                        }

                        DataState.Loading -> _state.update {
                            it.copy(uiState = UiState.Loading)
                        }

                        is DataState.Success -> _state.update {
                            it.copy(
                                uiState = UiState.Success,
                                list = result.data
                            )
                        }
                    }
                }
        }
    }

    companion object {
        private const val DEBOUNCE_TIMEOUT: Long = 500L
        private const val STATE_ERROR_MESSAGE = "An unexpected error occurred."
    }
}