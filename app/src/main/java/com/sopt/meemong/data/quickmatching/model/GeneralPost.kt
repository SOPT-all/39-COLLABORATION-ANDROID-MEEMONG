package com.sopt.meemong.data.quickmatching.model

import com.sopt.meemong.core.model.AvailableTime
import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.core.model.TreatmentType

data class GeneralPost(
    val postId: Long,
    val designerProfileImageUrl: String,
    val designerName: String,
    val createdAtMillis: Long,
    val region: String,
    val title: String,
    val priceType: PriceType,
    val displayPrice: Int?,
    val availableTimes: List<AvailableTime>,
    val treatmentTypes: List<TreatmentType>,
    val isLiked: Boolean,
)
