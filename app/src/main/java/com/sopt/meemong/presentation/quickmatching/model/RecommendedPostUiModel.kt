package com.sopt.meemong.presentation.quickmatching.model

import com.sopt.meemong.core.designsystem.component.MeemongPostCostType

data class RecommendedPostUiModel(
    val postId: Long,
    val thumbnailUrl: String,
    val title: String,
    val priceType: MeemongPostCostType,
    val displayPrice: Int,
    val region: String,
    val availableTimes: List<String>,
    val treatmentTypes: List<String>,
    val createdAtMillis: Long,
    val isLiked: Boolean,
)