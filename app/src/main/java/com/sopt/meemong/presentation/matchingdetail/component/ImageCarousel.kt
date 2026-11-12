package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

@Composable
fun ImageCarousel(
    modifier: Modifier = Modifier,
) {

}

@Composable
private fun PageIndicator(
    currentPage: Int,
    maxPage: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "$currentPage/$maxPage",
        style = MeemongTheme.typography.body2.m14,
        color = MeemongTheme.colors.white,
        modifier = modifier
            .background(
                color = MeemongTheme.colors.black.copy(
                    alpha = 0.5f,
                ),
                shape = CircleShape,
            )
            .padding(vertical = 4.dp, horizontal = 14.dp),
    )
}

@Preview
@Composable
private fun ImageCarouselPreview() {
    MeemongTheme {
        ImageCarousel()
    }
}
