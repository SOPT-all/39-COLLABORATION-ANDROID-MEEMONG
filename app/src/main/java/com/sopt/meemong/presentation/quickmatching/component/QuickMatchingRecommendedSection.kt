package com.sopt.meemong.presentation.quickmatching.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.component.MeemongLoadMoreButton
import com.sopt.meemong.core.designsystem.component.MeemongPostCostType
import com.sopt.meemong.core.designsystem.component.MeemongRecommendedPostCard
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.presentation.quickmatching.model.RecommendedPostUiModel

@Composable
fun QuickMatchingRecommendedSection(
    posts: List<RecommendedPostUiModel>,
    onPostClick: (Long) -> Unit,
    onLikeChange: (Long, Boolean) -> Unit,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = "미몽추천 공고",
            style = MeemongTheme.typography.body1.sb16,
            color = MeemongTheme.colors.gray950,
        )

        posts.forEach { post ->
            MeemongRecommendedPostCard(
                thumbnailUrl = post.thumbnailUrl,
                title = post.title,
                priceType = post.priceType,
                displayPrice = post.displayPrice,
                region = post.region,
                availableTimes = post.availableTimes,
                treatmentTypes = post.treatmentTypes,
                createdAtMillis = post.createdAtMillis,
                isLiked = post.isLiked,
                isLikeLoading = false,
                onLikeChange = { isLiked -> onLikeChange(post.postId, isLiked) },
                onClick = { onPostClick(post.postId) },
                modifier = Modifier.fillMaxWidth(),
            )
        }

        MeemongLoadMoreButton(
            text = "미몽추천 공고 더보기",
            onClick = onMoreClick,
        )
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun QuickMatchingRecommendedSectionPreview() {
    val previewPost = RecommendedPostUiModel(
        postId = 1L,
        thumbnailUrl = "",
        title = "뭘 해야 할지 모르겠다면?",
        priceType = MeemongPostCostType.REVIEW_SPECIAL,
        displayPrice = 5_000,
        region = "서울시 성동구",
        availableTimes = listOf("평일 오전"),
        treatmentTypes = listOf("커트", "펌"),
        createdAtMillis = System.currentTimeMillis(),
        isLiked = true,
    )

    MeemongTheme {
        QuickMatchingRecommendedSection(
            posts = listOf(
                previewPost,
                previewPost.copy(
                    postId = 2L,
                    title = "펌·염색 모델 모집합니다",
                    isLiked = false,
                ),
                previewPost.copy(
                    postId = 3L,
                    title = "단발 커트 모델 구해요",
                    priceType = MeemongPostCostType.MATERIAL_FEE,
                    displayPrice = 10_000,
                ),
            ),
            onPostClick = {},
            onLikeChange = { _, _ -> },
            onMoreClick = {},
            modifier = Modifier
                .background(MeemongTheme.colors.gray100)
                .padding(20.dp),
        )
    }
}