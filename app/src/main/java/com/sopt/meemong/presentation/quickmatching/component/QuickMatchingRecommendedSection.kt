package com.sopt.meemong.presentation.quickmatching.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.component.MeemongLoadMoreButton
import com.sopt.meemong.core.designsystem.component.MeemongRecommendedPostCard
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.presentation.quickmatching.QuickMatchingUiState
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
            key(post.postId) {
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
    MeemongTheme {
        QuickMatchingRecommendedSection(
            posts = QuickMatchingUiState.dummy.designerRecommendedPosts,
            onPostClick = {},
            onLikeChange = { _, _ -> },
            onMoreClick = {},
            modifier = Modifier
                .background(MeemongTheme.colors.gray100)
                .padding(20.dp),
        )
    }
}
