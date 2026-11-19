package com.sopt.meemong.presentation.quickmatching

import com.sopt.meemong.core.base.BaseUiEffect
import com.sopt.meemong.core.base.BaseUiState
import com.sopt.meemong.core.model.AvailableTime
import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.presentation.quickmatching.component.MatchingCategory
import com.sopt.meemong.presentation.quickmatching.model.GeneralPostUiModel
import com.sopt.meemong.presentation.quickmatching.model.RecommendedPostUiModel
import java.util.Calendar
import java.util.TimeZone

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

    return QuickMatchingUiState(
        designerRecommendedPosts = listOf(
            RecommendedPostUiModel(
                postId = 1L,
                thumbnailUrl = "",
                title = "뭘 해야 될지 모르겠다면 ?",
                priceType = PriceType.REVIEW,
                displayPrice = 5_000,
                region = "서울시 성동구",
                availableTimes = listOf(AvailableTime.WEEKDAY_MORNING),
                treatmentTypes = listOf("컷트", "펌"),
                createdAtMillis = dummyPostTime(14, 52),
                isLiked = true,
            ),
            RecommendedPostUiModel(
                postId = 2L,
                thumbnailUrl = "",
                title = "펌ㆍ염색모델 모집중입니다",
                priceType = PriceType.FREE,
                displayPrice = 0,
                region = "서울시 관악구",
                availableTimes = listOf(AvailableTime.ANYTIME),
                treatmentTypes = listOf("펌"),
                createdAtMillis = dummyPostTime(14, 52),
                isLiked = true,
            ),
            RecommendedPostUiModel(
                postId = 3L,
                thumbnailUrl = "",
                title = "이미지 체인지 해보고싶은신분 어떤",
                priceType = PriceType.FREE,
                displayPrice = 0,
                region = "서울시 성동구",
                availableTimes = listOf(AvailableTime.WEEKDAY_MORNING),
                treatmentTypes = listOf("컷트", "펌", "염색", "클리닉"),
                createdAtMillis = dummyPostTime(14, 52),
                isLiked = true,
            ),
            RecommendedPostUiModel(
                postId = 4L,
                thumbnailUrl = "",
                title = "C컬 레이어드컷 헤어모델 구해요!",
                priceType = PriceType.FREE,
                displayPrice = 0,
                region = "서울시 마포구",
                availableTimes = listOf(
                    AvailableTime.WEEKDAY_MORNING,
                    AvailableTime.WEEKDAY_AFTERNOON,
                ),
                treatmentTypes = listOf("컷트", "클리닉", "염색"),
                createdAtMillis = dummyPostTime(12, 0, daysAgo = 1),
                isLiked = true,
            ),
        ),
        designerGeneralPosts = listOf(
            GeneralPostUiModel(
                postId = 11L,
                designerProfileImageUrl = "",
                designerName = "메이봄수아",
                createdAtMillis = dummyPostTime(19, 49),
                region = "서울시 서초구",
                title = "11/2 오전 11시 단발컷+펌 모델구해요",
                priceType = PriceType.NEGOTIABLE,
                displayPrice = 40_000,
                availableTimes = listOf(AvailableTime.WEEKDAY_MORNING),
                treatmentTypes = listOf("컷트", "펌"),
                isLiked = false,
            ),
            GeneralPostUiModel(
                postId = 12L,
                designerProfileImageUrl = "",
                designerName = "권영준 디자이너",
                createdAtMillis = dummyPostTime(19, 31),
                region = "서울시 송파구",
                title = "📌잠실 송파 석촌 헤어 모델 모집📌",
                priceType = PriceType.NEGOTIABLE,
                displayPrice = 10_000,
                availableTimes = listOf(AvailableTime.ANYTIME),
                treatmentTypes = listOf("컷트", "펌", "매직", "염색"),
                isLiked = false,
            ),
            GeneralPostUiModel(
                postId = 13L,
                designerProfileImageUrl = "",
                designerName = "yubin",
                createdAtMillis = dummyPostTime(19, 28),
                region = "서울시 관악구",
                title = "브라운컬러 염색모델 모집",
                priceType = PriceType.NEGOTIABLE,
                displayPrice = 45_000,
                availableTimes = listOf(AvailableTime.ANYTIME),
                treatmentTypes = listOf("염색"),
                isLiked = false,
            ),
            GeneralPostUiModel(
                postId = 14L,
                designerProfileImageUrl = "",
                designerName = "수아디자이너",
                createdAtMillis = dummyPostTime(16, 17),
                region = "서울시 관악구",
                title = "월, 화 롱헤어모델 모집 합니다",
                priceType = PriceType.FREE,
                displayPrice = null,
                availableTimes = listOf(AvailableTime.WEEKDAY_MORNING),
                treatmentTypes = listOf("컷트", "염색"),
                isLiked = false,
            ),
        ),
        modelRecommendedPosts = listOf(
            RecommendedPostUiModel(
                postId = 21L,
                thumbnailUrl = "",
                title = "펌ㆍ염색모델 모집중입니다",
                priceType = PriceType.FREE,
                displayPrice = 0,
                region = "김포시",
                availableTimes = listOf(AvailableTime.ANYTIME),
                treatmentTypes = listOf("펌"),
                createdAtMillis = dummyPostTime(12, 5),
                isLiked = true,
            ),
            RecommendedPostUiModel(
                postId = 22L,
                thumbnailUrl = "",
                title = "염색 해 주실 디자이너분 찾습니다!!",
                priceType = PriceType.FREE,
                displayPrice = 0,
                region = "광주시",
                availableTimes = listOf(AvailableTime.ANYTIME),
                treatmentTypes = listOf("염색"),
                createdAtMillis = dummyPostTime(12, 0),
                isLiked = true,
            ),
            RecommendedPostUiModel(
                postId = 23L,
                thumbnailUrl = "",
                title = "샤기하고 중성적인 단발 컷트 원해요",
                priceType = PriceType.NEGOTIABLE,
                displayPrice = 10_000,
                region = "서울시 마포구",
                availableTimes = listOf(AvailableTime.ANYTIME),
                treatmentTypes = listOf("컷트"),
                createdAtMillis = dummyPostTime(12, 0, daysAgo = 1),
                isLiked = true,
            ),
            RecommendedPostUiModel(
                postId = 24L,
                thumbnailUrl = "",
                title = "긴 기장 붙임머리 희망해요",
                priceType = PriceType.NEGOTIABLE,
                displayPrice = 200_000,
                region = "고양시 덕양구",
                availableTimes = listOf(
                    AvailableTime.WEEKDAY_MORNING,
                    AvailableTime.WEEKDAY_AFTERNOON,
                ),
                treatmentTypes = listOf("붙임머리"),
                createdAtMillis = dummyPostTime(12, 0, daysAgo = 1),
                isLiked = true,
            ),
        ),
        modelGeneralPosts = listOf(
            GeneralPostUiModel(
                postId = 31L,
                designerProfileImageUrl = "",
                designerName = "민간인",
                createdAtMillis = dummyPostTime(19, 49),
                region = "서울시 서초구",
                title = "남자 머리 자르고싶습니다!",
                priceType = PriceType.FREE,
                displayPrice = null,
                availableTimes = listOf(AvailableTime.ANYTIME),
                treatmentTypes = listOf("컷트"),
                isLiked = false,
            ),
            GeneralPostUiModel(
                postId = 32L,
                designerProfileImageUrl = "",
                designerName = "몽몽",
                createdAtMillis = dummyPostTime(17, 48),
                region = "서울시 중랑구",
                title = "펌 원해요",
                priceType = PriceType.NEGOTIABLE,
                displayPrice = null,
                availableTimes = listOf(
                    AvailableTime.WEEKDAY_AFTERNOON,
                    AvailableTime.WEEKEND_MORNING,
                ),
                treatmentTypes = listOf("펌"),
                isLiked = false,
            ),
            GeneralPostUiModel(
                postId = 33L,
                designerProfileImageUrl = "",
                designerName = "먕무헤비",
                createdAtMillis = dummyPostTime(17, 44),
                region = "서울시 강서구",
                title = "히피 시스루쉐도우 빈티지 남자펌",
                priceType = PriceType.MODEL_FEE,
                displayPrice = 45_000,
                availableTimes = listOf(AvailableTime.ANYTIME),
                treatmentTypes = listOf("펌"),
                isLiked = false,
            ),
            GeneralPostUiModel(
                postId = 34L,
                designerProfileImageUrl = "",
                designerName = "민",
                createdAtMillis = dummyPostTime(14, 52),
                region = "서울시 도봉구",
                title = "오늘!!펌 가능하신분 찾습니다",
                priceType = PriceType.NEGOTIABLE,
                displayPrice = 50_000,
                availableTimes = listOf(AvailableTime.ANYTIME),
                treatmentTypes = listOf("펌"),
                isLiked = false,
            ),
        ),
    )
}

// 시안의 시각과 '어제' 표시를 유지하기 위한 더미 데이터용 시간입니다.
private fun dummyPostTime(hour: Int, minute: Int, daysAgo: Int = 0): Long =
    Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul")).apply {
        add(Calendar.DAY_OF_YEAR, -daysAgo)
        set(Calendar.HOUR_OF_DAY, hour)
        set(Calendar.MINUTE, minute)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }.timeInMillis
