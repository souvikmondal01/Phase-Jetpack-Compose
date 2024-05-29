package com.kivous.phasemovie.presentation.state

import com.kivous.phasemovie.domain.model.SliderMovie

data class SliderMovieListState(
    val isLoading: Boolean = false,
    val data: List<SliderMovie> = emptyList(),
    val error: String = ""
)