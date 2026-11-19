package com.sopt.meemong.presentation.quickmatching.model

import com.sopt.meemong.core.model.AvailableTime
import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.core.model.TreatmentType
import com.sopt.meemong.data.quickmatching.model.GeneralPost

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
    val treatmentTypes: List<TreatmentType>,
    val isLiked: Boolean,
)


fun GeneralPost.toUiModel(): GeneralPostUiModel =
    GeneralPostUiModel(
        postId = postId,
        designerProfileImageUrl = designerProfileImageUrl,
        designerName = designerName,
        createdAtMillis = createdAtMillis,
        region = region,
        title = title,
        priceType = priceType,
        displayPrice = displayPrice,
        availableTimes = availableTimes,
        treatmentTypes = treatmentTypes,
        isLiked = isLiked,
    )
