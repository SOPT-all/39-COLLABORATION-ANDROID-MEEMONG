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
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.core.model.AvailableTime
import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.core.model.TreatmentType
import com.sopt.meemong.presentation.quickmatching.model.GeneralPostUiModel

@Composable
fun QuickMatchingGeneralSection(
    posts: List<GeneralPostUiModel>,
    onPostClick: (Long) -> Unit,
    onLikeChange: (Long, Boolean) -> Unit,
    modifier: Modifier = Modifier,
    pendingLikePostIds: Set<Long> = emptySet(),
    wrapMetadata: Boolean = false,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = "일반 공고",
            style = MeemongTheme.typography.body1.sb16,
            color = MeemongTheme.colors.gray950,
        )

        posts.forEach { post ->
            key(post.postId) {
                MeemongPostCard(
                    designerProfileImageUrl = post.designerProfileImageUrl,
                    designerName = post.designerName,
                    createdAtMillis = post.createdAtMillis,
                    region = post.region,
                    title = post.title,
                    priceType = post.priceType,
                    displayPrice = post.displayPrice,
                    availableTimes = post.availableTimes,
                    treatmentTypes = post.treatmentTypes.map { it.label },
                    wrapMetadata = wrapMetadata,
                    isLiked = post.isLiked,
                    isLikeLoading = post.postId in pendingLikePostIds,
                    onLikeChange = { isLiked ->
                        onLikeChange(post.postId, isLiked)
                    },
                    onClick = { onPostClick(post.postId) },
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun QuickMatchingGeneralSectionPreview() {
    val previewPost = GeneralPostUiModel(
        postId = 1L,
        designerProfileImageUrl = "",
        designerName = "수아디자이너",
        createdAtMillis = System.currentTimeMillis(),
        region = "서울시 서초구",
        title = "월, 화 롱헤어모델 모집합니다",
        priceType = PriceType.NEGOTIABLE,
        displayPrice = 40_000,
        availableTimes = listOf(AvailableTime.WEEKDAY_MORNING),
        treatmentTypes = listOf(TreatmentType.CUT, TreatmentType.PERM),
        isLiked = false,
    )

    MeemongTheme {
        QuickMatchingGeneralSection(
            posts = listOf(
                previewPost,
                previewPost.copy(
                    postId = 2L,
                    title = "염색 모델 구해요",
                    priceType = PriceType.REVIEW,
                    displayPrice = 5_000,
                    treatmentTypes = listOf(TreatmentType.COLORED),
                    isLiked = true,
                ),
                previewPost.copy(
                    postId = 3L,
                    title = "단발 커트 모델 모집합니다",
                    priceType = PriceType.FREE,
                    displayPrice = null,
                    treatmentTypes = listOf(TreatmentType.CUT),
                ),
                previewPost.copy(
                    postId = 4L,
                    title = "빈티지 펌 모델 구해요",
                    displayPrice = 45_000,
                    availableTimes = listOf(AvailableTime.ANYTIME),
                    treatmentTypes = listOf(TreatmentType.PERM),
                ),
            ),
            onPostClick = {},
            onLikeChange = { _, _ -> },
            modifier = Modifier
                .background(MeemongTheme.colors.gray100)
                .padding(horizontal = 20.dp, vertical = 12.dp),
        )
    }
}
