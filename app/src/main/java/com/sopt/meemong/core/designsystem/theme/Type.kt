package com.sopt.meemong.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.sopt.meemong.R

object PretendardFont {
    val Medium = FontFamily(Font(R.font.pretendard_medium))
    val SemiBold = FontFamily(Font(R.font.pretendard_semibold))
    val Regular = FontFamily(Font(R.font.pretendard_regular))
}

sealed interface TypographyTokens {
    @Immutable
    data class Title(
        val sb20: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class Headline(
        val sb18: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class Body1(
        val sb16: TextStyle,
        val r16: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class Body2(
        val sb14: TextStyle,
        val m14: TextStyle,
        val r14: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class Caption1(
        val m12: TextStyle,
        val r12: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class Caption2(
        val sb10: TextStyle,
        val m10: TextStyle,
    ) : TypographyTokens
}

@Immutable
data class MeemongTypography(
    val title: TypographyTokens.Title,
    val headline: TypographyTokens.Headline,
    val body1: TypographyTokens.Body1,
    val body2: TypographyTokens.Body2,
    val caption1: TypographyTokens.Caption1,
    val caption2: TypographyTokens.Caption2,
)

private fun meemongTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    lineHeight: TextUnit,
    letterSpacing: TextUnit = (-0.01).em,
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None,
    ),
)

val defaultMeemongTypography = MeemongTypography(
    title = TypographyTokens.Title(
        sb20 = meemongTextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 20.sp,
            lineHeight = 1.5.em,
            fontWeight = FontWeight.SemiBold,
        ),
    ),
    headline = TypographyTokens.Headline(
        sb18 = meemongTextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 18.sp,
            lineHeight = 1.5.em,
            fontWeight = FontWeight.SemiBold,
        ),
    ),
    body1 = TypographyTokens.Body1(
        sb16 = meemongTextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 16.sp,
            lineHeight = 1.5.em,
            fontWeight = FontWeight.SemiBold,
        ),
        r16 = meemongTextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 16.sp,
            lineHeight = 1.5.em,
            fontWeight = FontWeight.Normal,
        ),
    ),
    body2 = TypographyTokens.Body2(
        sb14 = meemongTextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 14.sp,
            lineHeight = 1.4.em,
            fontWeight = FontWeight.SemiBold,
        ),
        m14 = meemongTextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 14.sp,
            lineHeight = 1.4.em,
            fontWeight = FontWeight.Medium,
        ),
        r14 = meemongTextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 14.sp,
            lineHeight = 1.4.em,
            fontWeight = FontWeight.Normal,
        ),
    ),
    caption1 = TypographyTokens.Caption1(
        m12 = meemongTextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 12.sp,
            lineHeight = 1.5.em,
            fontWeight = FontWeight.Medium,
        ),
        r12 = meemongTextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 12.sp,
            lineHeight = 1.5.em,
            fontWeight = FontWeight.Normal,
        ),
    ),
    caption2 = TypographyTokens.Caption2(
        sb10 = meemongTextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 10.sp,
            lineHeight = 1.6.em,
            fontWeight = FontWeight.SemiBold,
        ),
        m10 = meemongTextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 10.sp,
            lineHeight = 1.6.em,
            fontWeight = FontWeight.Medium,
        ),
    ),
)

val LocalMeemongTypography = staticCompositionLocalOf { defaultMeemongTypography }
