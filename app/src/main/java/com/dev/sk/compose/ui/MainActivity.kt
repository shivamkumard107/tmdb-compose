package com.dev.sk.compose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.dev.sk.compose.repository.model.Movie
import com.dev.sk.compose.ui.base.CustomNavType
import com.dev.sk.compose.ui.base.moviedetails.MovieDetailsScreen
import com.dev.sk.compose.ui.base.movielist.MoviesListScreen
import com.dev.sk.compose.ui.base.theme.MovieDetailsRoute
import com.dev.sk.compose.ui.base.theme.MoviesListRoute
import com.dev.sk.compose.ui.base.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.typeOf

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                Surface(color = Color.White) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = MoviesListRoute
                    ) {
                        composable<MoviesListRoute> {
                            MoviesListScreen(
                                onMovieClick = { movie ->
                                    navController.navigate(
                                        MovieDetailsRoute(movieDetails = movie)
                                    )
                                }
                            )
                        }

                        composable<MovieDetailsRoute> (
                            typeMap = mapOf(
                                typeOf<Movie>() to CustomNavType.MovieType
                            )
                        ) {
                            val arguments = it.toRoute<MovieDetailsRoute>()
                            MovieDetailsScreen(
                                navController = navController,
                                movie = arguments.movieDetails
                            )
                        }
                    }
                }
            }
        }
    }
}