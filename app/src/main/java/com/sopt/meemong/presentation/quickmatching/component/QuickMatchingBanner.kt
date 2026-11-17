package com.sopt.meemong.presentation.quickmatching.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

@Composable
fun QuickMatchingBanner(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(R.drawable.img_quick_matching_banner),
        contentDescription = "미용실에서 쓰던 그 샴푸, 기간 한정 특가",
        contentScale = ContentScale.Fit,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(375f / 68f),
    )
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun QuickMatchingBannerPreview() {
    MeemongTheme {
        QuickMatchingBanner()
    }
}