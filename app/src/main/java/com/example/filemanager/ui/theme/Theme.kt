package com.example.filemanager.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
//    primary = Purple200,
//    primaryVariant = Purple700,
//    secondary = Teal200
)

private val LightColorPalette = lightColors(

    background = BrightBlue,

    onBackground = LightOrange,

    primary = Orange,

    onPrimary = LightOrange,

    secondary = GrayBlue,

    surface = LightPurple,

//    primaryVariant = Purple700,

    /* Other default colors to override
    onSecondary = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun FileManagerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
//    val colors = if (darkTheme) {
//        DarkColorPalette
//    } else {
//        LightColorPalette
//    }

    val colors = LightColorPalette //There is no dark theme for now.

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(colors.onBackground)

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}