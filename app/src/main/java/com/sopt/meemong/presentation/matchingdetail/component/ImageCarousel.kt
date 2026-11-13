package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.component.UrlImage
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

@Composable
fun ImageCarousel(
    urlList: List<String>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    if (urlList.isEmpty()) return

    val pagerState = rememberPagerState(pageCount = { urlList.size })

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(MeemongTheme.colors.white),
        contentAlignment = Alignment.Center,
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
        ) { page ->
            UrlImage(
                url = urlList[page],
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(375f / 92f)
                .background(
                    brush = MeemongTheme.colors.gradientHero,
                )
                .align(Alignment.TopCenter),
        )

        IconButton(
            onClick = onClick,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 6.dp, top = 64.dp),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_back_24),
                contentDescription = "뒤로가기",
                tint = MeemongTheme.colors.white,
                modifier = Modifier
                    .padding(10.dp)
                    .size(24.dp),
            )
        }

        if (urlList.size > 1) {
            PageIndicator(
                currentPage = pagerState.currentPage + 1,
                pageCount = pagerState.pageCount,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 9.dp, end = 15.dp),
            )
        }
    }
}

@Composable
private fun PageIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "$currentPage/$pageCount",
        style = MeemongTheme.typography.body2.m14,
        color = MeemongTheme.colors.white,
        modifier = modifier
            .background(
                color = MeemongTheme.colors.black.copy(alpha = 0.5f),
                shape = CircleShape,
            )
            .padding(vertical = 4.dp, horizontal = 14.dp),
    )
}

@Preview
@Composable
private fun ImageCarouselPreview() {
    MeemongTheme {
        ImageCarousel(
            urlList = listOf(
                "https://github.com/user-attachments/assets/e4cf2f44-7d7c-4491-beca-e56b9b47ec08",
                "https://github.com/user-attachments/assets/5c86fe24-2a30-48c7-a512-1183719312ee",
                "https://github.com/user-attachments/assets/b7730c3e-9ee0-4ffc-9ff6-219166f67849",
                "https://github.com/user-attachments/assets/7fda5c4e-4f33-4f51-b1cf-46e4da45a3a2",
                "https://github.com/user-attachments/assets/06607efa-1ce1-4b0b-815c-026e7aaa522b",
            ),
            onClick = {},
        )
    }
}
