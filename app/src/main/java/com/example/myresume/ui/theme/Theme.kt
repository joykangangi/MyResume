package com.example.myresume.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Blackish,
    primaryVariant = DarkPink,
    secondary = Teal200,
    onPrimary = Color.White,
    background = Color.Black,
    onBackground = Color.White,
    surface = DarkPink,
    onSurface = Color.White
)

private val LightColorPalette = lightColors(
    primary = Pink,
    primaryVariant = DarkPink,
    secondary = Teal200,
    onPrimary = Blackish,
    background = Greyish,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Blackish
)

@Composable
fun MyResumeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}