package com.kivous.phasemovie.domain.repository

import com.kivous.phasemovie.domain.model.Movie
import com.kivous.phasemovie.domain.model.SliderMovie
import com.kivous.phasemovie.util.Response
import kotlinx.coroutines.flow.Flow


interface MovieListRepository {
    suspend fun getMovieList(
        category: String,
        page: Int
    ): Flow<Response<List<Movie>>>

    suspend fun getSimilarMovies(id: String): Flow<Response<List<Movie>>>

    suspend fun getSliderMovieList(): Flow<Response<List<SliderMovie>>>

}