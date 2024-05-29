package com.kivous.phasemovie.presentation.compoment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kivous.phasemovie.domain.model.Movie
import com.kivous.phasemovie.ui.theme.NunitoBold
import com.kivous.phasemovie.util.Category

@Composable
fun MovieRowSection(
    category: Category,
    movieList: List<Movie>,
    onMoreClick: (Category) -> Unit,
    onMovieClick: (Movie) -> Unit,
    more: Boolean? = true
) {

    val lazyListState = rememberLazyListState()

    if (movieList.isNotEmpty()) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable(indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                        // to disable ripple effect
                    ) {
                        onMoreClick(category)
                    },
            ) {
                Text(
                    text = category.title,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterStart),
                    fontSize = 18.sp,
                    color = Color(0xffF0E1E1),
                    fontFamily = NunitoBold
                )

                if (more == true) {
                    if (lazyListState.firstVisibleItemIndex >= 1) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                            contentDescription = "",
                            modifier = Modifier.align(Alignment.CenterEnd)
                        )
                    }
                }

            }

            LazyRow(
                state = lazyListState
            ) {
                items(movieList.size) { index ->
                    MovieItem(movieList = movieList, index = index, onMovieCLick = {
                        onMovieClick(it)
                    })
                }
            }

        }

    }
}