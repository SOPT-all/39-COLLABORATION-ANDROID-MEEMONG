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
import com.sopt.meemong.core.designsystem.component.MeemongRecommendedPostCard
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.core.model.AvailableTime
import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.presentation.home.model.HomeMatchingPostItem

@Composable
fun HomeMatchingPostSection(
    items: List<HomeMatchingPostItem>,
    onItemClick: (HomeMatchingPostItem) -> Unit,
    onLikeChange: (HomeMatchingPostItem, Boolean) -> Unit,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier,
    pendingLikePostIds: Set<Long> = emptySet(),
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
            // 375 기준: 좌우 여백 20 + 카드 간격 8 + 다음 카드가 보이는 너비 41 = 69 → 카드 306
            val horizontalPadding = 20.dp
            val cardSpacing = 8.dp
            val nextCardPeekWidth = 41.dp
            val cardWidth = maxWidth - horizontalPadding - cardSpacing - nextCardPeekWidth

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = horizontalPadding),
                horizontalArrangement = Arrangement.spacedBy(cardSpacing),
            ) {
                items(items, key = { it.postId }) { item ->
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
                        isLikeLoading = item.postId in pendingLikePostIds,
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
                    postId = it.toLong(),
                    thumbnailUrl = "",
                    title = "펌ㆍ염색모델 모집중입니다",
                    priceType = PriceType.FREE,
                    displayPrice = null,
                    region = "서울시 관악구",
                    availableTimes = listOf(AvailableTime.ANYTIME),
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
