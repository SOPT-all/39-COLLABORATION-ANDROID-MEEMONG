package com.sopt.meemong.presentation.quickmatching.model

import com.sopt.meemong.core.model.AvailableTime
import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.core.model.TreatmentType

data class RecommendedPostUiModel(
    val postId: Long,
    val thumbnailUrl: String,
    val title: String,
    val priceType: PriceType,
    val displayPrice: Int?,
    val region: String,
    val availableTimes: List<AvailableTime>,
    val treatmentTypes: List<TreatmentType>,
    val createdAtMillis: Long,
    val isLiked: Boolean,
)
