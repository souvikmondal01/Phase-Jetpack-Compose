package com.kivous.phasemovie.data.mapper

import com.kivous.phasemovie.data.remote.MovieApi.Companion.IMAGE_BASE_URL
import com.kivous.phasemovie.data.remote.model.MovieDto
import com.kivous.phasemovie.domain.model.Movie

fun MovieDto.toMovie(
    category: String
): Movie =
    Movie(
        adult = adult ?: false,
        backdrop_path = IMAGE_BASE_URL + backdrop_path,
        original_language = original_language ?: "",
        overview = overview ?: "",
        poster_path = IMAGE_BASE_URL + poster_path,
        release_date = release_date ?: "0000-00-00",
        title = title ?: "",
        vote_average = vote_average ?: 0.0,
        popularity = popularity ?: 0.0,
        vote_count = vote_count ?: 0,
        id = id ?: -1,
        original_title = original_title ?: "",
        video = video ?: false,
        category = category,
        genre_ids = genre_ids ?: listOf(-1, -2)
    )

