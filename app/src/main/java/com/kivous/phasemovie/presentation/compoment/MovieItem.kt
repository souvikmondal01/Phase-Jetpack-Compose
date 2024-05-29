package com.kivous.phasemovie.presentation.compoment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.kivous.phasemovie.domain.model.Movie

@Composable
fun MovieItem(movieList: List<Movie>, index: Int, onMovieCLick: (Movie) -> Unit) {

    val movie = movieList[index]

    val imageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(movie.poster_path)
            .size(Size.ORIGINAL).build()
    ).state

    var paddingStart = 8.dp
    var paddingEnd = 0.dp
    if (index == 0) {
        paddingStart = 16.dp
    }
    if (index == movieList.size - 1) {
        paddingEnd = 16.dp
    }

    Card(modifier = Modifier.padding(start = paddingStart, end = paddingEnd),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color(0xff0a0a0a)),

        onClick = {
            onMovieCLick(movie)
        }) {
        if (imageState is AsyncImagePainter.State.Loading || imageState is AsyncImagePainter.State.Error) {
            Card(
                modifier = Modifier
                    .height(160.dp)
                    .width(106.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(Color(0xff0a0a0a))
            ) {}
        }

        if (imageState is AsyncImagePainter.State.Success) {
            Image(
                contentDescription = "",
                modifier = Modifier
                    .height(160.dp)
                    .width(106.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
                painter = imageState.painter
            )
        }
    }


}
