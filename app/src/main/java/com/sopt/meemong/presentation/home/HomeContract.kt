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
    val designerSections: List<HomeDesignerSectionUiModel> = emptyList(),
    val matchingPosts: List<HomeMatchingPostItem> = emptyList(),
    val productTitle: String = "",
    val productDescription: String = "",
    val products: List<HomeProductItem> = emptyList(),
    val consultings: List<HomeConsultingItem> = emptyList(),
) : BaseUiState {
    companion object {
        // 서버 연결 전까지 쓰는 예시 데이터
        val dummy = HomeUiState(
            designerSections = dummyDesignerSections,
            matchingPosts = dummyMatchingPosts,
            productTitle = "긴 곱슬머리에 딱 맞는 헤어템",
            productDescription = "모발 특성과 길이에 맞는 헤어템을 모아봤어요!",
            products = dummyProducts,
            consultings = dummyConsultings,
        )
    }
}

sealed interface HomeUiEffect : BaseUiEffect {
    data object NavigateToQuickMatching : HomeUiEffect

    data object NavigateToMatchingDetail : HomeUiEffect
}

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
        title = "세령님을 위한 추천 디자이너",
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
        thumbnailUrl = "https://github.com/user-attachments/assets/e4cf2f44-7d7c-4491-beca-e56b9b47ec08",
        title = "롱머리 헤어모델 구합니다❤️",
        priceType = MeemongPostCostType.FREE,
        displayPrice = 0,
        region = "서울 강남구",
        availableTimes = listOf("시간 상관없음"),
        treatmentTypes = listOf("컷트", "펌", "염색"),
        createdAtMillis = 1795600800000, // 2026-11-25 19:00
        isLiked = true,
    ),
    HomeMatchingPostItem(
        thumbnailUrl = "https://github.com/user-attachments/assets/5d4faaab-0b0e-44c8-a973-3a12bac77d7d",
        title = "중단발 펌 모델 구해요:)",
        priceType = MeemongPostCostType.MATERIAL_FEE,
        displayPrice = 27000,
        region = "서울 강남구",
        availableTimes = listOf("평일 오전", "평일 오후"),
        treatmentTypes = listOf("펌"),
        createdAtMillis = 1795602600000, // 2026-11-25 19:30
        isLiked = true,
    ),
    HomeMatchingPostItem(
        thumbnailUrl = "https://github.com/user-attachments/assets/d086ced8-a099-46fe-b8d6-c3cf4cc4639d",
        title = "긴머리 염색 커트 헤어모델 모집합니다😊",
        priceType = MeemongPostCostType.MATERIAL_FEE,
        displayPrice = 10000,
        region = "서울 관악구",
        availableTimes = listOf("시간 상관없음"),
        treatmentTypes = listOf("컷트", "염색"),
        createdAtMillis = 1795605000000, // 2026-11-25 20:10
        isLiked = true,
    ),
    HomeMatchingPostItem(
        thumbnailUrl = "https://github.com/user-attachments/assets/6a3db738-2ff4-4eec-82f2-ec5e77b1d774",
        title = "C컬, S컬펌 모델 받고 있습니다!💛",
        priceType = MeemongPostCostType.MATERIAL_FEE,
        displayPrice = 15000,
        region = "서울 서초구",
        availableTimes = listOf("평일 오전", "평일 오후"),
        treatmentTypes = listOf("컷트", "펌", "매직"),
        createdAtMillis = 1795695000000, // 2026-11-26 21:10
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
