package com.kivous.phasemovie.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.kivous.phasemovie.presentation.screen.FavouriteScreen
import com.kivous.phasemovie.presentation.screen.HomeScreen
import com.kivous.phasemovie.ui.theme.PhaseTheme
import com.kivous.phasemovie.ui.theme.Red
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()

        setContent {
            PhaseTheme {

                TabNavigator(
                    tab = HomeTab
                ) {
                    Scaffold(bottomBar = {
                        NavigationBar(
                            containerColor = Color(0xff0a0a0a),
                        ) {
                            TabNavigationItems(tab = HomeTab)
                            TabNavigationItems(tab = SavedTab)
                        }
                    }) {
                        Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
                            CurrentTab()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RowScope.TabNavigationItems(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = {
            tabNavigator.current = tab
        },
        icon = {
            Icon(painter = tab.options.icon!!, contentDescription = tab.options.title)
        },
        colors = NavigationBarItemColors(
            selectedIconColor = Red,
            unselectedIconColor = Color(0xFF7D7D7D),
            selectedIndicatorColor = Color(0xff180E0E),
            selectedTextColor = Color(0xffFF4040),
            unselectedTextColor = Color(0xFF7D7D7D),
            disabledIconColor = Color.Transparent,
            disabledTextColor = Color.Transparent,
        ),
    )
}

object HomeTab : Tab {
    private fun readResolve(): Any = HomeTab
    override val options: TabOptions
        @Composable get() = TabOptions(
            index = 0u, title = "Home",
            icon = rememberVectorPainter(Icons.Rounded.Home)
        )

    @Composable
    override fun Content() {
        Navigator(screen = HomeScreen())
//        {
//            FadeTransition(navigator = it)
//        }
    }

}


object SavedTab : Tab {
    private fun readResolve(): Any = SavedTab
    override val options: TabOptions
        @Composable get() = TabOptions(
            index = 1u, title = "Favourite",
            icon = rememberVectorPainter(Icons.Rounded.Bookmark)
        )

    @Composable
    override fun Content() {
        Navigator(FavouriteScreen())
    }

}