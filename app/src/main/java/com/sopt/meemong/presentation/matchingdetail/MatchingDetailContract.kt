package com.sopt.meemong.presentation.matchingdetail

import com.sopt.meemong.core.base.BaseUiEffect
import com.sopt.meemong.core.base.BaseUiState
import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.core.model.ShootingRangeType
import com.sopt.meemong.core.model.TreatmentType
import com.sopt.meemong.data.matchingdetail.model.DesignerProfileInfo
import com.sopt.meemong.data.matchingdetail.model.DetailInfo
import com.sopt.meemong.data.matchingdetail.model.ServiceInfo
import com.sopt.meemong.data.matchingdetail.model.TabType

data class MatchingDetailUiState(
    val postId: Long = 0L,
    val isLoading: Boolean = false,
    val postImageUrls: List<String> = emptyList(),
    val currentTab: TabType = TabType.CONTENT_DETAIL,
    val designerProfileInfo: DesignerProfileInfo = DesignerProfileInfo(
        designerId = 0L,
        designerName = "",
        designerProfileImageUrl = "",
        region = "",
        completedTreatmentCount = 0,
    ),
    val serviceInfo: ServiceInfo = ServiceInfo(
        title = "",
        isLiked = false,
        priceType = PriceType.REVIEW,
        discountRate = 0.0,
        originalPrice = null,
        displayPrice = null,
        treatmentTypes = emptyList(),
        signatures = emptyList(),
        shootingRanges = emptyList(),
        shopName = "",
    ),
    val detailInfo: DetailInfo = DetailInfo(
        content = "",
        portfolioImageUrls = emptyList(),
        shopAddress = "",
        shopImageUrls = emptyList(),
    ),
) : BaseUiState {
    companion object {
        val dummy = MatchingDetailUiState(
            postId = 1L,
            postImageUrls = listOf(
                "https://github.com/user-attachments/assets/e4cf2f44-7d7c-4491-beca-e56b9b47ec08",
                "https://github.com/user-attachments/assets/5c86fe24-2a30-48c7-a512-1183719312ee",
                "https://github.com/user-attachments/assets/b7730c3e-9ee0-4ffc-9ff6-219166f67849",
                "https://github.com/user-attachments/assets/7fda5c4e-4f33-4f51-b1cf-46e4da45a3a2",
                "https://github.com/user-attachments/assets/06607efa-1ce1-4b0b-815c-026e7aaa522b",
            ),
            designerProfileInfo = DesignerProfileInfo(
                designerId = 1L,
                designerName = "도화",
                designerProfileImageUrl = "https://github.com/user-attachments/assets/4b564df4-ed6f-4592-b194-53203b227243",
                region = "서울 강남구",
                completedTreatmentCount = 3,
            ),
            serviceInfo = ServiceInfo(
                title = "롱머리 헤어모델 구합니다❤\uFE0F",
                isLiked = false,
                priceType = PriceType.FREE,
                discountRate = 50.0,
                originalPrice = 35_000,
                displayPrice = 17_500,
                treatmentTypes = listOf(
                    TreatmentType.CUT,
                    TreatmentType.PERM,
                    TreatmentType.COLORED,
                ),
                signatures = listOf(TreatmentType.CUT, TreatmentType.PERM),
                shootingRanges = listOf(ShootingRangeType.FACE_EXPOSURE, ShootingRangeType.VIDEO),
                shopName = "토니앤가이 대치점",
            ),
            detailInfo = DetailInfo(
                content = " 안녕하세요 토니앤 가이 도화입니다. 포트폴리오 작업을 위해 헤어모델 모집중입니다! 커트, 펌, 염색 등 모든 시술 가능합니다. *소정의 약값만 받고 진행합니다 . *커트는 필수입니다! 시술 Before&After 촬영 및 SNS, 블로그 업로드할 예정입니다. 얼굴공개 및 촬영 가능하신 분 모집합니다! 날짜/시간 협의가능 1:1 상담원하시는 분들은 편하게 DM으로 연락 부탁드립니다.",
                portfolioImageUrls = listOf(
                    "https://github.com/user-attachments/assets/6565f997-2f89-4809-8607-452912ec1afd",
                    "https://github.com/user-attachments/assets/ff7c89fd-c78f-407d-a4fc-de97a1bf6a2e",
                    "https://github.com/user-attachments/assets/01557a56-a5b3-4583-976b-794f7b03eb90",
                    "https://github.com/user-attachments/assets/3d316688-ee03-4cdb-8a60-0475ca6ba131",
                    "https://github.com/user-attachments/assets/e944b218-b377-4f20-9e6d-ed79f338b2a5",
                    "https://github.com/user-attachments/assets/6460bb4a-faff-45fc-a455-6defda83f9a0",
                    "https://github.com/user-attachments/assets/885b90ee-673d-4d37-bb56-dad68c878873",
                    "https://github.com/user-attachments/assets/4f7ec779-4ada-47e5-9b83-5bf80ea4f80d",
                    "https://github.com/user-attachments/assets/28842475-36af-450b-a587-c067a208ba85",
                ),
                shopAddress = "서울 강남구 선릉로64길 9 6층 토니앤가이",
                shopImageUrls = listOf(
                    "https://github.com/user-attachments/assets/3f63f49b-88e2-4369-8f99-dd32ae2a919f",
                    "https://github.com/user-attachments/assets/9c01f7db-d875-48fc-bbbf-4b57e0d78626",
                    "https://github.com/user-attachments/assets/c43af1f8-1ee2-44a6-8c1d-f64d393634eb",
                ),
            )
        )
    }
}

sealed interface MatchingDetailUiEffect : BaseUiEffect
