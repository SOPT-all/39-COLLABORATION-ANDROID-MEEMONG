package com.sopt.meemong.data.matchingdetail.mapper

import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.core.model.ShootingRangeType
import com.sopt.meemong.core.model.TreatmentType
import com.sopt.meemong.data.matchingdetail.model.DesignerProfileInfo
import com.sopt.meemong.data.matchingdetail.model.DetailInfo
import com.sopt.meemong.data.matchingdetail.model.MatchingDetail
import com.sopt.meemong.data.matchingdetail.model.ServiceInfo
import com.sopt.meemong.data.matchingdetail.remote.dto.MatchingDetailResponse

fun MatchingDetailResponse.toModel(): MatchingDetail =
    MatchingDetail(
        postId = postId,
        postImageUrls = postImageUrls,
        designerProfileInfo = DesignerProfileInfo(
            designerId = designerId,
            designerName = designerName,
            designerProfileImageUrl = designerProfileImageUrl,
            region = region,
            completedTreatmentCount = completedTreatmentCount,
        ),
        serviceInfo = ServiceInfo(
            title = title,
            isLiked = isLiked,
            priceType = enumValueOf<PriceType>(priceType),
            discountRate = discountRate,
            originalPrice = originalPrice,
            displayPrice = displayPrice,
            treatmentTypes = treatmentTypes.map { enumValueOf<TreatmentType>(it) },
            signatures = signatures.map { enumValueOf<TreatmentType>(it) },
            shootingRanges = shootingRanges.map { enumValueOf<ShootingRangeType>(it) },
            shopName = shopName,
        ),
        detailInfo = DetailInfo(
            // TODO: 디자이너 정보 API 연결
            content = content,
            portfolioImageUrls = emptyList(),
            shopAddress = "",
            shopImageUrls = emptyList(),
        ),
    )
