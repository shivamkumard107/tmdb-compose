package com.dev.sk.compose.ui.base.movielist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.sk.compose.R
import com.dev.sk.compose.repository.model.Movie
import com.dev.sk.compose.ui.MainViewModel
import com.dev.sk.compose.ui.UiState
import com.dev.sk.compose.ui.base.movielist.components.MovieListItem

@Composable
fun MoviesListScreen(
    onMovieClick: (Movie) -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    val queryString = viewModel.userQuery.collectAsState()
    val isSearching = viewModel.isSearching.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = queryString.value,
            onValueChange = viewModel::onSearchQueryChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.LightGray,
                errorBorderColor = Color.LightGray,
                disabledBorderColor = Color.LightGray,
                cursorColor = Color.Black
            ),
            placeholder = {
                Text(
                    text = "Search Movies"
                )
            },

            leadingIcon = {
                Image(
                    painter = painterResource(
                        id = R.drawable.baseline_search_24
                    ),
                    contentDescription = null
                )
            }
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        if (state.value.uiState is UiState.Error) {
            Text(
                text = (state.value.uiState as UiState.Error).message,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

        if (state.value.uiState == UiState.Loading || isSearching.value) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Black
                )
            }
        }

        if (!isSearching.value) {
            if (state.value.list.isNullOrEmpty() && queryString.value.isNotBlank()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Image(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            painter = painterResource(
                                id = R.drawable.img_not_available_200
                            ),
                            contentDescription = null
                        )

                        Text(
                            text = "No movies found",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                }
            } else {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    columns = GridCells.Fixed(2)
                ) {
                    items(state.value.list.orEmpty()) { movie ->
                        MovieListItem(
                            movie = movie,
                            onItemClick = {
                                onMovieClick(movie)
                            }
                        )
                    }
                }
            }
        }
    }
}