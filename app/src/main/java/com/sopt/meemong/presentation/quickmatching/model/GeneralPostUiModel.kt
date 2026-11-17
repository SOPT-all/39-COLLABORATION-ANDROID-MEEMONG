package com.sopt.meemong.presentation.quickmatching.model

import com.sopt.meemong.core.designsystem.component.MeemongPostCostType

data class GeneralPostUiModel(
    val postId: Long,
    val designerProfileImageUrl: String,
    val designerName: String,
    val createdAtMillis: Long,
    val region: String,
    val title: String,
    val priceType: MeemongPostCostType,
    val displayPrice: Int?,
    val availableTimes: List<String>,
    val treatmentTypes: List<String>,
    val isLiked: Boolean,
)