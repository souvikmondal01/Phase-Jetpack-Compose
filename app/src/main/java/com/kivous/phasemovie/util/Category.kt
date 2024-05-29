package com.kivous.phasemovie.util

enum class Category(val category: String, val title: String) {
    NOW_PLAYING("now_playing", "Now Playing"),
    POPULAR("popular", "Popular"),
    TOP_RATED("top_rated", "Top Rated"),
    UPCOMING("upcoming", "Upcoming"),
    SIMILAR("similar", "More Like This"),
}