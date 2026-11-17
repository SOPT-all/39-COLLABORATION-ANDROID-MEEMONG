package com.sopt.meemong.data.matchingdetail.model

import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.core.model.ShootingRangeType
import com.sopt.meemong.core.model.TreatmentType

data class ServiceInfo(
    val title: String,
    val isLiked: Boolean,
    val priceType: PriceType,
    val discountRate: Float,
    val originalPrice: Int?,
    val displayPrice: Int?,
    val treatmentTypes: List<TreatmentType>,
    val signatures: List<TreatmentType>,
    val shootingRanges: List<ShootingRangeType>,
    val shopName: String,
)
