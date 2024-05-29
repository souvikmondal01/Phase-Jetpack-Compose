package com.kivous.phasemovie.presentation.compoment

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ChangeStatusBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color)
}

@Composable
fun ChangeStatusBarColor(scrollState: Int) {
    val systemUiController = rememberSystemUiController()

    if (scrollState > 200) {
        systemUiController.setSystemBarsColor(Color.Black.copy(alpha = .9f))
    } else {
        systemUiController.setSystemBarsColor(Color.Transparent)
    }
}

@Composable
fun ChangeStatusBarColor(scrollState: Int, color: Color) {
    val systemUiController = rememberSystemUiController()

    if (scrollState > 200) {
        systemUiController.setSystemBarsColor(color.copy(alpha = .9f))
    } else {
        systemUiController.setSystemBarsColor(Color.Transparent)
    }
}
