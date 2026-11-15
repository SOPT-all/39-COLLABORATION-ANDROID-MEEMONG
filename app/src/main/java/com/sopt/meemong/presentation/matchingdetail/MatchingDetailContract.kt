package com.sopt.meemong.presentation.matchingdetail

import com.sopt.meemong.core.base.BaseUiEffect
import com.sopt.meemong.core.base.BaseUiState
import com.sopt.meemong.core.model.TreatmentType
import com.sopt.meemong.data.matchingdetail.model.DesignerProfileInfo
import com.sopt.meemong.data.matchingdetail.model.DetailInfo
import com.sopt.meemong.data.matchingdetail.model.ServiceInfo
import com.sopt.meemong.presentation.matchingdetail.component.PriceType

data class MatchingDetailUiState(
    val postId: Long = 0,
    val postImageUrls: List<String> = emptyList(),
    val designerProfileInfo: DesignerProfileInfo = DesignerProfileInfo(
            designerId = 0,
            designerName = "",
            designerProfileImageUrl = "",
            region = "",
            completedTreatmentCount = 0,
        ),
    val serviceInfo: ServiceInfo = ServiceInfo(
            title = "",
            isLiked = false,
            priceType = PriceType.REVIEW,
            discountRate = 0f,
            originalPrice = 0,
            displayPrice = 0,
            treatmentTypes = listOf(TreatmentType.STRAIGHT),
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
): BaseUiState

sealed interface MatchingDetailUiEffect : BaseUiEffect
