package com.kivous.phasemovie.presentation.compoment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.kivous.phasemovie.ui.theme.Grey
import com.kivous.phasemovie.ui.theme.Red

@Composable
fun PagerIndicator(
    size: Int, currentPage: Int
) {
    Row {
        repeat(size) {
            Indicator(
                isSelected = it == currentPage,
            )
        }
    }

}

@Composable
fun Indicator(
    isSelected: Boolean,
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(8.dp)
            .clip(CircleShape)
            .background(
                if (isSelected) Red else Grey
            )
    )
}