package com.sopt.meemong.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object MeemongTheme {
    val colors: MeemongColors
        @Composable
        @ReadOnlyComposable
        get() = LocalMeemongColors.current

    val typography: MeemongTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalMeemongTypography.current
}

@Composable
fun ProvideMeemongColorsAndTypography(
    colors: MeemongColors,
    typography: MeemongTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalMeemongColors provides colors,
        LocalMeemongTypography provides typography,
        content = content,
    )
}

@Composable
fun MeemongTheme(
    content: @Composable () -> Unit,
) {
    ProvideMeemongColorsAndTypography(
        colors = defaultMeemongColors,
        typography = defaultMeemongTypography,
    ) {
        MaterialTheme(
            content = content,
        )
    }
}
