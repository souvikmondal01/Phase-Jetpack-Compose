package com.kivous.phasemovie.presentation.compoment

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.kivous.phasemovie.ui.theme.NunitoSemiBold

@Composable
fun Premium(
    modifier: Modifier,
) {
    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Premium",
            fontSize = 14.sp,
            color = Color(0xFFF1C174),
            fontFamily = NunitoSemiBold
        )
    }
}
