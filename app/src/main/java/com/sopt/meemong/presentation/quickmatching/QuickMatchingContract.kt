package com.sopt.meemong.presentation.quickmatching

import com.sopt.meemong.core.base.BaseUiEffect
import com.sopt.meemong.core.base.BaseUiState
import com.sopt.meemong.core.model.AvailableTime
import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.presentation.quickmatching.component.MatchingCategory
import com.sopt.meemong.presentation.quickmatching.model.GeneralPostUiModel
import com.sopt.meemong.presentation.quickmatching.model.RecommendedPostUiModel

data class QuickMatchingUiState(
    val selectedCategory: MatchingCategory = MatchingCategory.DESIGNER,
    val designerRecommendedPosts: List<RecommendedPostUiModel> = emptyList(),
    val designerGeneralPosts: List<GeneralPostUiModel> = emptyList(),
    val modelRecommendedPosts: List<RecommendedPostUiModel> = emptyList(),
    val modelGeneralPosts: List<GeneralPostUiModel> = emptyList(),
) : BaseUiState {
    companion object {
        val dummy: QuickMatchingUiState
            get() = quickMatchingDummyState()
    }
}

sealed interface QuickMatchingUiEffect : BaseUiEffect

private fun quickMatchingDummyState(): QuickMatchingUiState {
    val now = System.currentTimeMillis()

    val recommendedPost = RecommendedPostUiModel(
        postId = 1L,
        thumbnailUrl = "",
        title = "롱헤어 펌 모델 모집합니다",
        priceType = PriceType.REVIEW,
        displayPrice = 5_000,
        region = "서울시 성동구",
        availableTimes = listOf(AvailableTime.WEEKDAY_MORNING),
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
        priceType = PriceType.FREE,
        displayPrice = null,
        availableTimes = listOf(AvailableTime.WEEKDAY_AFTERNOON),
        treatmentTypes = listOf("커트"),
        isLiked = false,
    )

    return QuickMatchingUiState(
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
                priceType = PriceType.MODEL_FEE,
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
