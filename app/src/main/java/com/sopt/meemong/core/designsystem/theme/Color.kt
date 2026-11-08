package com.sopt.meemong.core.designsystem.theme

import android.R.attr.name
import android.graphics.Color.blue
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

private val GradientIcon =
    Brush.verticalGradient(colors = listOf(Color(0xFF3779FD), Color(0xFF5A44C9)))
private val GradientHero =
    Brush.verticalGradient(colors = listOf(Black.copy(alpha = 0.6f), Black.copy(alpha = 0.0f)))

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

@Preview(showBackground = true)
@Composable
private fun MeemongColorsPreview() {
    MeemongTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF262626))
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = "primary",
                color = MeemongTheme.colors.white,
                style = MeemongTheme.typography.headline.sb18,
            )
            Column {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(MeemongTheme.colors.meemongBlue),
                )
                Text(text = "meemong_blue", color = Color.White, fontSize = 8.sp)

            }

            Text(
                text = "secondary",
                color = MeemongTheme.colors.white,
                style = MeemongTheme.typography.headline.sb18,
            )
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                listOf(
                    "red" to MeemongTheme.colors.red,
                    "green" to MeemongTheme.colors.green,
                    "dark_blue" to MeemongTheme.colors.darkBlue,
                ).forEach { (name, color) ->
                    Column {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(color),
                        )
                        Text(text = name, color = Color.White, fontSize = 8.sp)
                    }
                }
            }

            Text(
                text = "gray",
                color = MeemongTheme.colors.white,
                style = MeemongTheme.typography.headline.sb18,
            )
            FlowRow(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                listOf(
                    "black" to MeemongTheme.colors.black,
                    "gray950" to MeemongTheme.colors.gray950,
                    "gray900" to MeemongTheme.colors.gray900,
                    "gray800" to MeemongTheme.colors.gray800,
                    "gray700" to MeemongTheme.colors.gray700,
                    "gray600" to MeemongTheme.colors.gray600,
                    "gray500" to MeemongTheme.colors.gray500,
                    "gray400" to MeemongTheme.colors.gray400,
                    "gray300" to MeemongTheme.colors.gray300,
                    "gray200" to MeemongTheme.colors.gray200,
                    "gray100" to MeemongTheme.colors.gray100,
                    "gray50" to MeemongTheme.colors.gray50,
                    "white" to MeemongTheme.colors.white,
                ).forEach { (name, color) ->
                    Column {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(color),
                        )
                        Text(text = name, color = Color.White, fontSize = 8.sp)
                    }
                }
            }

            Text(
                text = "background",
                color = MeemongTheme.colors.white,
                style = MeemongTheme.typography.headline.sb18,
            )
            Row {
                Column {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .background(MeemongTheme.colors.background),
                    )
                    Text(text = "bg/blue", color = Color.White, fontSize = 8.sp)

                }
            }

            Text(
                text = "gradient",
                color = MeemongTheme.colors.white,
                style = MeemongTheme.typography.headline.sb18,
            )
            Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                listOf(
                    "gradient/icon" to MeemongTheme.colors.gradientIcon,
                    "gradient/hero" to MeemongTheme.colors.gradientHero,
                ).forEach { (name, brush) ->
                    Column {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(brush),
                        )
                        Text(text = name, color = Color.White, fontSize = 8.sp)
                    }
                }
            }
        }
    }
}
