package com.sopt.meemong.presentation.home

import com.sopt.meemong.core.base.BaseUiEffect
import com.sopt.meemong.core.base.BaseUiState
import com.sopt.meemong.core.designsystem.component.MeemongPostCostType
import com.sopt.meemong.presentation.home.component.DesignerPriceType
import com.sopt.meemong.presentation.home.component.HomeConsultingItem
import com.sopt.meemong.presentation.home.component.HomeDesignerItem
import com.sopt.meemong.presentation.home.component.HomeMatchingPostItem
import com.sopt.meemong.presentation.home.component.HomeProductItem

data class HomeDesignerSectionUiModel(
    val title: String,
    val items: List<HomeDesignerItem>,
)

data class HomeUiState(
    val designerSections: List<HomeDesignerSectionUiModel> = dummyDesignerSections,
    val matchingPosts: List<HomeMatchingPostItem> = dummyMatchingPosts,
    val productTitle: String = "긴 곱슬머리에 딱 맞는 헤어템",
    val productDescription: String = "모발 특성과 길이에 맞는 헤어템을 모아봤어요 !",
    val products: List<HomeProductItem> = dummyProducts,
    val consultings: List<HomeConsultingItem> = dummyConsultings,
) : BaseUiState

sealed interface HomeUiEffect : BaseUiEffect

//서버 연결 전까지 예시 데이터
private const val ONE_DAY_MILLIS = 24 * 60 * 60 * 1000L

private val dummyDesignerSections = listOf(
    HomeDesignerSectionUiModel(
        title = "내 주변 디자이너",
        items = List(3) {
            HomeDesignerItem(
                portfolioImageUrls = listOf("", "", ""),
                profileImageUrl = "",
                name = "한울",
                shopName = "준오헤어 동탄카림에비뉴점",
                priceType = DesignerPriceType.FREE,
                location = "경기 화성시 4.7km",
            )
        },
    ),
    HomeDesignerSectionUiModel(
        title = "00님을 위한 추천 디자이너",
        items = List(3) {
            HomeDesignerItem(
                portfolioImageUrls = listOf("", "", ""),
                profileImageUrl = "",
                name = "슬아",
                shopName = "에이치플레이스 정자역점",
                priceType = DesignerPriceType.MATERIAL,
                location = "경기 성남시 분당구 13.4km",
                materialCost = "10만원~",
            )
        },
    ),
    HomeDesignerSectionUiModel(
        title = "무료시술 디자이너",
        items = List(3) {
            HomeDesignerItem(
                portfolioImageUrls = listOf("", "", ""),
                profileImageUrl = "",
                name = "하루",
                shopName = "하루",
                priceType = DesignerPriceType.FREE,
                location = "경기도 수원시 권선구 7.9km",
            )
        },
    ),
    HomeDesignerSectionUiModel(
        title = "뷰티시술 디자이너",
        items = List(3) {
            HomeDesignerItem(
                portfolioImageUrls = listOf("", "", ""),
                profileImageUrl = "",
                name = "오프유 브로우",
                shopName = "오프유브로우",
                priceType = DesignerPriceType.FREE,
                location = "경기도 수원시 권선구 8.3km",
            )
        },
    ),
)

private val dummyMatchingPosts = listOf(
    HomeMatchingPostItem(
        thumbnailUrl = "",
        title = "펌ㆍ염색모델 모집중입니다",
        priceType = MeemongPostCostType.FREE,
        displayPrice = 0,
        region = "서울시 관악구",
        availableTimes = listOf("시간 상관없음"),
        treatmentTypes = listOf("컷트", "클리닉", "펌", "염색", "탈색", "드라이", "매직", "셋팅", "다운펌", "두피케어"),
        createdAtMillis = System.currentTimeMillis() - ONE_DAY_MILLIS,
        isLiked = true,
    ),
    HomeMatchingPostItem(
        thumbnailUrl = "",
        title = "여자숏컷/애쉬블루옴브레 모델 구합니다",
        priceType = MeemongPostCostType.MODEL_FEE,
        displayPrice = 100000,
        region = "성남시 분당구",
        availableTimes = listOf("평일 오후", "주말 오후"),
        treatmentTypes = listOf("컷트", "펌", "탈색"),
        createdAtMillis = System.currentTimeMillis() - ONE_DAY_MILLIS,
        isLiked = true,
    ),
    HomeMatchingPostItem(
        thumbnailUrl = "",
        title = "헤어모델 모집합니다",
        priceType = MeemongPostCostType.MATERIAL_FEE,
        displayPrice = 5000,
        region = "서울시 강남구",
        availableTimes = listOf("시간 상관없음"),
        treatmentTypes = listOf("컷트", "클리닉", "펌", "염색", "탈색", "드라이", "매직", "셋팅", "다운펌"),
        createdAtMillis = System.currentTimeMillis(),
        isLiked = true,
    ),
)

private val dummyProducts = listOf(
    HomeProductItem(
        imageUrl = "",
        tag = "두피보호",
        name = "셀프염색 전 필수 두피 보호제",
        originalPrice = 28000,
        discountRate = 68,
        salePrice = 8960,
    ),
    HomeProductItem(
        imageUrl = "",
        tag = "기름제거",
        name = "떡지고 냄새나는 두피 해결 샴푸",
        originalPrice = 33000,
        discountRate = 30,
        salePrice = 23100,
    ),
)

private val dummyConsultings = List(5) {
    HomeConsultingItem(
        title = "예쁜 브라운/베이지 염색 받고 싶어요",
        description = "10만원대 이내로 쿨톤 브라운 염색하고 싶습니다!!",
        timeAgo = "2일 전",
        commentCount = 12,
    )
}
