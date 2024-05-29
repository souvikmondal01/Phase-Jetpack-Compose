package com.kivous.phasemovie.presentation.compoment

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.kivous.phasemovie.domain.model.SliderMovie

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(
    sliderMovieList: List<SliderMovie>,
) {
    val pagerState = rememberPagerState(pageCount = { sliderMovieList.size })
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.height(240.dp)
        ) {
            // Background image
            val imageState = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(sliderMovieList[pagerState.currentPage].bgUrl).size(Size.ORIGINAL).build()
            ).state

            if (imageState is AsyncImagePainter.State.Loading
                || imageState is AsyncImagePainter.State.Error
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xff0a0a0a))
                ) {
                }
            }

            if (imageState is AsyncImagePainter.State.Success) {
                Image(
                    painter = imageState.painter,
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            // Shadow effect
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            0.0f to Color.Black,
                            0.3f to Color.Transparent,
                            0.5f to Color.Transparent,
                            0.9f to Color.Black.copy(alpha = .85f),
                            0.97f to Color.Black.copy(alpha = .95f),
                            1f to Color.Black,
                            start = Offset(0.0f, 20.0f),
                            end = Offset(0.0f, 640.0f)
                        )
                    )
            )

            // Slider
            HorizontalPager(
                state = pagerState, modifier = Modifier.fillMaxSize()
            ) { page ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter,
                ) {
                    // Foreground image
                    val imageStateFG = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(sliderMovieList[page].fgUrl)
                            .size(Size.ORIGINAL).build()
                    ).state

                    if (imageStateFG is AsyncImagePainter.State.Success) {
                        Image(
                            painter = imageStateFG.painter,
                            contentDescription = "",
                            modifier = Modifier
                                .width(192.dp)
                                .padding(bottom = 24.dp)
                        )
                    }

                }
            }

            // Premium box
            Premium(
                modifier = Modifier
                    .statusBarsPadding()
                    .align(Alignment.TopEnd)
                    .padding(end = 16.dp, top = 8.dp)
                    .height(24.dp)
                    .width(104.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .border(
                        width = 1.dp,
                        brush = Brush.horizontalGradient(
                            0f to Color(0xffC38F3B),
                            0.5f to Color(0xFFF1C174),
                            1f to Color(0xffC38F3B),
                        ),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .background(color = Color.Black.copy(alpha = .4f))
                    .shimmerEffect(),
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Indicator
        PagerIndicator(size = pagerState.pageCount, currentPage = pagerState.currentPage)
    }

}