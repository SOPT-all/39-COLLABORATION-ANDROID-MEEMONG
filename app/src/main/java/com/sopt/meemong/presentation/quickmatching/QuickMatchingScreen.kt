package com.sopt.meemong.presentation.quickmatching

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.component.MeemongFloatingMenu
import com.sopt.meemong.core.designsystem.component.MeemongFloatingMenuType
import com.sopt.meemong.core.designsystem.component.MeemongPostCostType
import com.sopt.meemong.core.designsystem.component.MeemongTopBar
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.presentation.quickmatching.component.MatchingCategory
import com.sopt.meemong.presentation.quickmatching.component.QuickMatchingBanner
import com.sopt.meemong.presentation.quickmatching.component.QuickMatchingGeneralSection
import com.sopt.meemong.presentation.quickmatching.component.QuickMatchingRecommendedSection
import com.sopt.meemong.presentation.quickmatching.component.SegmentControlRow
import com.sopt.meemong.presentation.quickmatching.model.GeneralPostUiModel
import com.sopt.meemong.presentation.quickmatching.model.RecommendedPostUiModel

@Composable
fun QuickMatchingRoute(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
) {
    QuickMatchingScreen(
        uiState = QuickMatchingUiState(),
        onBackClick = onBackClick,
        onCategoryClick = {},
        onPostClick = {},
        onLikeChange = { _, _ -> },
        onMoreClick = {},
        modifier = modifier,
    )
}

@Composable
private fun QuickMatchingScreen(
    uiState: QuickMatchingUiState,
    onBackClick: () -> Unit,
    onCategoryClick: (MatchingCategory) -> Unit,
    onPostClick: (Long) -> Unit,
    onLikeChange: (Long, Boolean) -> Unit,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isFloatingMenuExpanded by rememberSaveable { mutableStateOf(false) }

    val (recommendedPosts, generalPosts) = when (uiState.selectedCategory) {
        MatchingCategory.DESIGNER ->
            uiState.designerRecommendedPosts to uiState.designerGeneralPosts

        MatchingCategory.MODEL ->
            uiState.modelRecommendedPosts to uiState.modelGeneralPosts
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MeemongTheme.colors.white),
    ) {
        MeemongTopBar(
            title = "빠른 매칭",
            onBackClick = onBackClick,
        )

        SegmentControlRow(
            currentCategory = uiState.selectedCategory,
            onClick = onCategoryClick,
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(MeemongTheme.colors.gray100),
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(top = 12.dp, bottom = 96.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    QuickMatchingRecommendedSection(
                        posts = recommendedPosts,
                        onPostClick = onPostClick,
                        onLikeChange = onLikeChange,
                        onMoreClick = onMoreClick,
                        modifier = Modifier.padding(horizontal = 20.dp),
                    )
                }

                item {
                    QuickMatchingBanner()
                }

                item {
                    QuickMatchingGeneralSection(
                        posts = generalPosts,
                        onPostClick = onPostClick,
                        onLikeChange = onLikeChange,
                        modifier = Modifier.padding(horizontal = 20.dp),
                    )
                }
            }

            MeemongFloatingMenu(
                type = MeemongFloatingMenuType.QUICK_MATCHING,
                isExpanded = isFloatingMenuExpanded,
                onExpandedChange = { isFloatingMenuExpanded = it },
                onItemClick = {},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 20.dp, bottom = 20.dp),
            )
        }
    }
}

@Preview(name = "디자이너 탭", showBackground = true, widthDp = 375, heightDp = 812)
@Composable
private fun QuickMatchingDesignerPreview() {
    QuickMatchingPreview(category = MatchingCategory.DESIGNER)
}

@Preview(name = "모델 탭", showBackground = true, widthDp = 375, heightDp = 812)
@Composable
private fun QuickMatchingModelPreview() {
    QuickMatchingPreview(category = MatchingCategory.MODEL)
}

@Composable
private fun QuickMatchingPreview(category: MatchingCategory) {
    MeemongTheme {
        QuickMatchingScreen(
            uiState = quickMatchingPreviewState(category),
            onBackClick = {},
            onCategoryClick = {},
            onPostClick = {},
            onLikeChange = { _, _ -> },
            onMoreClick = {},
        )
    }
}

private fun quickMatchingPreviewState(
    category: MatchingCategory,
): QuickMatchingUiState {
    val now = System.currentTimeMillis()

    val recommendedPost = RecommendedPostUiModel(
        postId = 1L,
        thumbnailUrl = "",
        title = "롱헤어 펌 모델 모집합니다",
        priceType = MeemongPostCostType.REVIEW_SPECIAL,
        displayPrice = 5_000,
        region = "서울시 성동구",
        availableTimes = listOf("평일 오전"),
        treatmentTypes = listOf("펌"),
        createdAtMillis = now,
        isLiked = true,
    )

    val generalPost = GeneralPostUiModel(
        postId = 11L,
        designerProfileImageUrl = "",
        designerName = "수아디자이너",
        createdAtMillis = now,
        region = "서울시 서초구",
        title = "단발 커트 모델 모집합니다",
        priceType = MeemongPostCostType.FREE,
        displayPrice = null,
        availableTimes = listOf("평일 오후"),
        treatmentTypes = listOf("커트"),
        isLiked = false,
    )

    return QuickMatchingUiState(
        selectedCategory = category,
        designerRecommendedPosts = listOf(
            recommendedPost,
            recommendedPost.copy(postId = 2L, title = "애쉬 브라운 염색 모델 구해요"),
            recommendedPost.copy(postId = 3L, title = "레이어드 커트 모델 구해요"),
        ),
        designerGeneralPosts = listOf(
            generalPost,
            generalPost.copy(postId = 12L, title = "숏컷 모델 구해요"),
            generalPost.copy(postId = 13L, title = "톤다운 염색 모델 구해요"),
            generalPost.copy(postId = 14L, title = "빈티지 펌 모델 구해요"),
        ),
        modelRecommendedPosts = listOf(
            recommendedPost.copy(
                postId = 21L,
                title = "단발펌 받고 싶어요",
                priceType = MeemongPostCostType.MODEL_FEE,
                displayPrice = 45_000,
            ),
            recommendedPost.copy(postId = 22L, title = "긴 머리 염색 받고 싶어요"),
            recommendedPost.copy(postId = 23L, title = "볼륨매직 받고 싶어요"),
        ),
        modelGeneralPosts = listOf(
            generalPost.copy(postId = 31L, title = "레이어드컷 받고 싶어요"),
            generalPost.copy(postId = 32L, title = "주말에 염색 가능해요"),
            generalPost.copy(postId = 33L, title = "앞머리 펌 받고 싶어요"),
            generalPost.copy(postId = 34L, title = "긴 머리 다듬고 싶어요"),
        ),
    )
}