package com.sopt.meemong.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.component.MeemongPostCostType
import com.sopt.meemong.core.designsystem.component.MeemongRecommendedPostCard
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

data class HomeMatchingPostItem(
    val thumbnailUrl: String,
    val title: String,
    val priceType: MeemongPostCostType,
    val displayPrice: Int,
    val region: String,
    val availableTimes: List<String>,
    val treatmentTypes: List<String>,
    val createdAtMillis: Long,
    val isLiked: Boolean,
)

@Composable
fun HomeMatchingPostSection(
    items: List<HomeMatchingPostItem>,
    onItemClick: (HomeMatchingPostItem) -> Unit,
    onLikeChange: (HomeMatchingPostItem, Boolean) -> Unit,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        HomeSectionHeader(
            title = "미몽추천 빠른매칭글",
            onMoreClick = onMoreClick,
            modifier = Modifier.padding(horizontal = 20.dp),
        )

        BoxWithConstraints(
            modifier = Modifier.fillMaxWidth(),
        ) {
            //375-69 = 306
            val cardWidth = maxWidth - 69.dp

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(items) { item ->
                    MeemongRecommendedPostCard(
                        thumbnailUrl = item.thumbnailUrl,
                        title = item.title,
                        priceType = item.priceType,
                        displayPrice = item.displayPrice,
                        region = item.region,
                        availableTimes = item.availableTimes,
                        treatmentTypes = item.treatmentTypes,
                        createdAtMillis = item.createdAtMillis,
                        isLiked = item.isLiked,
                        isLikeLoading = false,
                        onLikeChange = { isLiked -> onLikeChange(item, isLiked) },
                        onClick = { onItemClick(item) },
                        modifier = Modifier.width(cardWidth),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun HomeMatchingPostSectionPreview() {
    MeemongTheme {
        HomeMatchingPostSection(
            items = List(3) {
                HomeMatchingPostItem(
                    thumbnailUrl = "",
                    title = "펌ㆍ염색모델 모집중입니다",
                    priceType = MeemongPostCostType.FREE,
                    displayPrice = 0,
                    region = "서울시 관악구",
                    availableTimes = listOf("시간 상관 없음"),
                    treatmentTypes = listOf("컷트", "클리닉", "펌", "염색"),
                    createdAtMillis = System.currentTimeMillis(),
                    isLiked = true,
                )
            },
            onItemClick = {},
            onLikeChange = { _, _ -> },
            onMoreClick = {},
        )
    }
}
