package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.component.MeemongLoadMoreButton
import com.sopt.meemong.core.designsystem.component.UrlImage
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.presentation.matchingdetail.MatchingDetailUiState

@Composable
fun PortfolioSection(
    imageUrls: List<String>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MeemongTheme.colors.white)
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = "포트폴리오",
            style = MeemongTheme.typography.body1.sb16,
            color = MeemongTheme.colors.black,
            modifier = Modifier.fillMaxWidth(),
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            imageUrls.chunked(3).forEach { rowImages ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    rowImages.forEach { image ->
                        UrlImage(
                            url = image,
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(2.dp)),
                            contentScale = ContentScale.Crop,
                        )
                    }

                    repeat(3 - rowImages.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }

            MeemongLoadMoreButton(
                text = "포트폴리오 더보기",
                onClick = {}, // TODO: 더보기 버튼 클릭 (기능 구현X)
            )
        }
    }
}

@Preview
@Composable
private fun PortfolioSectionPreview() {
    MeemongTheme {
        val dummy = MatchingDetailUiState.dummy.detailInfo
        PortfolioSection(
            imageUrls = dummy.portfolioImageUrls,
        )
    }
}
