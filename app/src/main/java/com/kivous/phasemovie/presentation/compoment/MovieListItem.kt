package com.kivous.phasemovie.presentation.compoment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
fun MovieListItem(
    movie: Movie,
    onMovieCLick: (Movie) -> Unit
) {
    val imageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(movie.poster_path)
            .size(Size.ORIGINAL).build()
    ).state

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(176.dp)
            .padding(end = 8.dp, top = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color(0xff0a0a0a)),
        onClick = {
            onMovieCLick(movie)
        }
    ) {
        if (imageState is AsyncImagePainter.State.Loading || imageState is AsyncImagePainter.State.Error) {

        }

        if (imageState is AsyncImagePainter.State.Success) {
            Image(
                painter = imageState.painter,
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
        }

    }

}