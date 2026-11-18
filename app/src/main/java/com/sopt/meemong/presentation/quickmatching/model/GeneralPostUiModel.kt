package com.sopt.meemong.presentation.quickmatching.model

import com.sopt.meemong.core.model.AvailableTime
import com.sopt.meemong.core.model.PriceType

data class GeneralPostUiModel(
    val postId: Long,
    val designerProfileImageUrl: String,
    val designerName: String,
    val createdAtMillis: Long,
    val region: String,
    val title: String,
    val priceType: PriceType,
    val displayPrice: Int?,
    val availableTimes: List<AvailableTime>,
    val treatmentTypes: List<String>,
    val isLiked: Boolean,
)
