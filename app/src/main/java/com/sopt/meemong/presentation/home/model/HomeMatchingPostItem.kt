package com.sopt.meemong.presentation.home.model

import com.sopt.meemong.core.model.AvailableTime
import com.sopt.meemong.core.model.PriceType


data class HomeMatchingPostItem(
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
