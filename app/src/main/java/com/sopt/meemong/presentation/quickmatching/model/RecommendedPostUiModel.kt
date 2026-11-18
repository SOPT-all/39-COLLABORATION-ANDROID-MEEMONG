package com.sopt.meemong.presentation.quickmatching.model

import com.sopt.meemong.core.model.AvailableTime
import com.sopt.meemong.core.model.PriceType

data class RecommendedPostUiModel(
    val postId: Long,
    val thumbnailUrl: String,
    val title: String,
    val priceType: PriceType,
    val displayPrice: Int,
    val region: String,
    val availableTimes: List<AvailableTime>,
    val treatmentTypes: List<String>,
    val createdAtMillis: Long,
    val isLiked: Boolean,
)
