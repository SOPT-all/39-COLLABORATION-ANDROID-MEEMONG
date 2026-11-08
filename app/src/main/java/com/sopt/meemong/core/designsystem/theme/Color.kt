package com.sopt.meemong.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private val MeemongBlue = Color(0XFF4674FF)

private val Red = Color(0XFFFF004A)
private val Green = Color(0XFF2CB36D)
private val DarkBlue = Color(0XFF443DA6)

private val Black = Color(0XFF000000)
private val Gray950 = Color(0XFF1B2024)
private val Gray900 = Color(0XFF2F343C)
private val Gray800 = Color(0XFF3F4651)
private val Gray700 = Color(0XFF525A66)
private val Gray600 = Color(0XFF757E8C)
private val Gray500 = Color(0XFFA3ACB6)
private val Gray400 = Color(0XFFD2D7DF)
private val Gray300 = Color(0XFFDFE2E7)
private val Gray200 = Color(0XFFE5E8EC)
private val Gray100 = Color(0XFFEFF1F4)
private val Gray50 = Color(0XFFF8F9FB)
private val White = Color(0XFFFFFFFF)

private val Background = Color(0XFFE6F2FF)

private val GradientIcon = Brush.verticalGradient(colors = listOf(Color(0xFF3779FD), Color(0xFF5A44C9)))
private val GradientHero = Brush.verticalGradient(colors = listOf(Black.copy(alpha = 0.6f), Black.copy(alpha = 0.0f)))

@Immutable
data class MeemongColors(
    val meemongBlue: Color,

    val red: Color,
    val green: Color,
    val darkBlue: Color,

    val black: Color,
    val gray950: Color,
    val gray900: Color,
    val gray800: Color,
    val gray700: Color,
    val gray600: Color,
    val gray500: Color,
    val gray400: Color,
    val gray300: Color,
    val gray200: Color,
    val gray100: Color,
    val gray50: Color,
    val white: Color,

    val background: Color,

    val gradientIcon: Brush,
    val gradientHero: Brush,
)

val defaultMeemongColors = MeemongColors(
    meemongBlue = MeemongBlue,

    red = Red,
    green = Green,
    darkBlue = DarkBlue,

    black = Black,
    gray950 = Gray950,
    gray900 = Gray900,
    gray800 = Gray800,
    gray700 = Gray700,
    gray600 = Gray600,
    gray500 = Gray500,
    gray400 = Gray400,
    gray300 = Gray300,
    gray200 = Gray200,
    gray100 = Gray100,
    gray50 = Gray50,
    white = White,

    background = Background,

    gradientIcon = GradientIcon,
    gradientHero = GradientHero,
)

val LocalMeemongColors = staticCompositionLocalOf { defaultMeemongColors }
