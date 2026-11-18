package com.sopt.meemong.presentation.home

import com.sopt.meemong.R
import com.sopt.meemong.core.base.BaseUiEffect
import com.sopt.meemong.core.base.BaseUiState
import com.sopt.meemong.core.designsystem.component.MeemongPostCostType
import com.sopt.meemong.presentation.home.component.DesignerPriceType
import com.sopt.meemong.presentation.home.model.HomeConsultingItem
import com.sopt.meemong.presentation.home.model.HomeDesignerItem
import com.sopt.meemong.presentation.home.model.HomeDesignerSectionUiModel
import com.sopt.meemong.presentation.home.model.HomeMatchingPostItem
import com.sopt.meemong.presentation.home.model.HomeProductItem

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
        items = listOf(
            HomeDesignerItem(
                portfolioImageResIds = listOf(R.drawable.img_designer_hanul_1, R.drawable.img_designer_hanul_2, R.drawable.img_designer_hanul_3),
                profileImageResId = R.drawable.img_designer_hanul_profile,
                name = "한울",
                shopName = "준오헤어 동탄카림에비뉴점",
                priceType = DesignerPriceType.FREE,
                location = "경기 화성시 4.7km",
            ),
            HomeDesignerItem(
                portfolioImageResIds = listOf(R.drawable.img_designer_jihyun_1, R.drawable.img_designer_jihyun_2, R.drawable.img_designer_jihyun_3),
                profileImageResId = R.drawable.img_designer_jihyun_profile,
                name = "지현 디자이너",
                shopName = "이가자헤어비스 분당이마트점",
                priceType = DesignerPriceType.MATERIAL,
                location = "경기 성남시 분당구 13.0km",
                materialCost = "2만원~",
            ),
            HomeDesignerItem(
                portfolioImageResIds = listOf(R.drawable.img_designer_haewon_1, R.drawable.img_designer_haewon_2, R.drawable.img_designer_haewon_3),
                profileImageResId = R.drawable.img_designer_haewon_profile,
                name = "해원",
                shopName = "이철헤어커커 서현점",
                priceType = DesignerPriceType.FREE,
                location = "경기 성남시 분당구 15.8km",
            ),
        ),
    ),
    HomeDesignerSectionUiModel(
        title = "세령님을 위한 추천 디자이너",
        items = listOf(
            HomeDesignerItem(
                portfolioImageResIds = listOf(R.drawable.img_designer_seula_1, R.drawable.img_designer_seula_2, R.drawable.img_designer_seula_3),
                profileImageResId = R.drawable.img_designer_seula_profile,
                name = "슬아",
                shopName = "에이치플레이스 정자역점",
                priceType = DesignerPriceType.MATERIAL,
                location = "경기 성남시 분당구 13.4km",
                materialCost = "10만원~",
            ),
            HomeDesignerItem(
                portfolioImageResIds = listOf(R.drawable.img_designer_iyu_1, R.drawable.img_designer_iyu_2, R.drawable.img_designer_iyu_3),
                profileImageResId = R.drawable.img_designer_iyu_profile,
                name = "이유수석실장",
                shopName = "헤어다이아 수원역 타임점",
                priceType = DesignerPriceType.FREE,
                location = "경기도 수원시 팔달구 10.8km",
            ),
            HomeDesignerItem(
                portfolioImageResIds = listOf(R.drawable.img_designer_minseo_1, R.drawable.img_designer_minseo_2, R.drawable.img_designer_minseo_3),
                profileImageResId = R.drawable.img_designer_minseo_profile,
                name = "민서 수석디자이너",
                shopName = "헤어다이아 수원역점",
                priceType = DesignerPriceType.FREE,
                location = "경기도 수원시 팔달구 10.9km",
            ),
        ),
    ),
    HomeDesignerSectionUiModel(
        title = "무료시술 디자이너",
        items = listOf(
            HomeDesignerItem(
                portfolioImageResIds = listOf(R.drawable.img_designer_haru_1, R.drawable.img_designer_haru_2, R.drawable.img_designer_haru_3),
                profileImageResId = R.drawable.img_designer_haru_profile,
                name = "하루",
                shopName = "하루",
                priceType = DesignerPriceType.FREE,
                location = "경기도 수원시 권선구 7.9km",
            ),
            HomeDesignerItem(
                portfolioImageResIds = listOf(R.drawable.img_designer_seungyeon_1, R.drawable.img_designer_seungyeon_2, R.drawable.img_designer_seungyeon_3),
                profileImageResId = R.drawable.img_designer_seungyeon_profile,
                name = "hd승연",
                shopName = "차홍룸광교점",
                priceType = DesignerPriceType.FREE,
                location = "경기도 수원시 영통구 7.9km",
            ),
            HomeDesignerItem(
                portfolioImageResIds = listOf(R.drawable.img_designer_seonga_1, R.drawable.img_designer_seonga_2, R.drawable.img_designer_seonga_3),
                profileImageResId = R.drawable.img_designer_seonga_profile,
                name = "성아",
                shopName = "아이디헤어 동탄 솔빛나루점",
                priceType = DesignerPriceType.FREE,
                location = "경기도 화성시 동탄구 6.6km",
            ),
        ),
    ),
    HomeDesignerSectionUiModel(
        title = "뷰티시술 디자이너",
        items = listOf(
            HomeDesignerItem(
                portfolioImageResIds = listOf(R.drawable.img_designer_offu_1, R.drawable.img_designer_offu_2, R.drawable.img_designer_offu_3),
                profileImageResId = R.drawable.img_designer_offu_profile,
                name = "오프유 브로우",
                shopName = "오프유브로우",
                priceType = DesignerPriceType.FREE,
                location = "경기도 수원시 권선구 8.3km",
            ),
            HomeDesignerItem(
                portfolioImageResIds = listOf(R.drawable.img_designer_haneul_1, R.drawable.img_designer_haneul_2, R.drawable.img_designer_haneul_3),
                profileImageResId = R.drawable.img_designer_haneul_profile,
                name = "하늘",
                shopName = "모도아티스트리 수우너",
                priceType = DesignerPriceType.FREE,
                location = "경기도 수원시 영통구 7.0km",
            ),
            HomeDesignerItem(
                portfolioImageResIds = listOf(R.drawable.img_designer_rosy_1, R.drawable.img_designer_rosy_2, R.drawable.img_designer_rosy_3),
                profileImageResId = R.drawable.img_designer_rosy_profile,
                name = "Rosy",
                shopName = "프리랜서",
                priceType = DesignerPriceType.FREE,
                location = "경기도 수원시 권선구 8.2km",
            ),
        ),
    ),
)

private val dummyMatchingPosts = listOf(
    HomeMatchingPostItem(
        postId = 1L,
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
        postId = 2L,
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
        postId = 3L,
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
        postId = 4L,
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
        imageResId = R.drawable.img_home_product_scalp,
        tag = "두피보호",
        name = "셀프염색 전 필수 두피 보호제",
        originalPrice = 28000,
        discountRate = 68,
        salePrice = 8960,
    ),
    HomeProductItem(
        imageResId = R.drawable.img_home_product_shampoo,
        tag = "기름제거",
        name = "떡지고 냄새나는 두피 해결 샴푸",
        originalPrice = 33000,
        discountRate = 30,
        salePrice = 23100,
    ),
)

private val dummyConsultings = listOf(
    HomeConsultingItem(
        title = "예쁜 브라운/베이지 염색 받고 싶어요",
        description = "10만원대 이내로 쿨톤 브라운 염색하고 싶습니다!!",
        timeAgo = "2일 전",
        commentCount = 12,
    ),
    HomeConsultingItem(
        title = "손상모 커트&블랙염색 시술 흠흠",
        description = "3개월 전에 탈색 후 염색을 했는데 색이 잘 안빠져서 3~4번은 했더니 관리를 흠흠",
        timeAgo = "3일 전",
        commentCount = 9,
    ),
    HomeConsultingItem(
        title = "단발하고 싶어요",
        description = "단발하고 싶어요!(태슬컷, c컬펌, 완전 뽀글 머리도 좋아요 다 상관 없습니다)",
        timeAgo = "2일 전",
        commentCount = 12,
    ),
    HomeConsultingItem(
        title = "제발도와주세요저를",
        description = "매일 고데기를 할 자신이 없어서 최대한 손질이 편한 스타일을 원해요!",
        timeAgo = "2일 전",
        commentCount = 10,
    ),
    HomeConsultingItem(
        title = "단발을 하고 싶은데 잘 어울릴지 모르겠어요",
        description = "제가 어릴때 단발을 했었는데 그냥 무작정 싹뚝 자르기만 해서 최양락이 되어버렸거든요",
        timeAgo = "2일 전",
        commentCount = 10,
    ),
)
