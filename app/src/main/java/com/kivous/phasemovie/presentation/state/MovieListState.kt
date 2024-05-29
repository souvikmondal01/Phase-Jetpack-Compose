package com.kivous.phasemovie.presentation.state

import com.kivous.phasemovie.domain.model.Movie

data class MovieListState(
    val isLoadingNowPlaying: Boolean = false,
    val isLoadingPopular: Boolean = false,
    val isLoadingTopRated: Boolean = false,
    val isLoadingUpcoming: Boolean = false,
    val isLoadingSimilar: Boolean = false,

    val nowPlayingMovieListPage: Int = 1,
    val popularMovieListPage: Int = 1,
    val topRatedMovieListPage: Int = 1,
    val upcomingMovieListPage: Int = 1,

    val nowPlayingMovieList: List<Movie> = emptyList(),
    val popularMovieList: List<Movie> = emptyList(),
    val topRatedMovieList: List<Movie> = emptyList(),
    val upcomingMovieList: List<Movie> = emptyList(),
    val similarMovieList: List<Movie> = emptyList(),

    )