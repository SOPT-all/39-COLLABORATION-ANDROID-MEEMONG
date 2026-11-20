package com.sopt.meemong.presentation.home.model

import com.sopt.meemong.core.model.AvailableTime
import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.presentation.quickmatching.model.RecommendedPostUiModel


data class HomeMatchingPostItem(
    val postId: Long,
    val thumbnailUrl: String,
    val title: String,
    val priceType: PriceType,
    val displayPrice: Int?,
    val region: String,
    val availableTimes: List<AvailableTime>,
    val treatmentTypes: List<String>,
    val createdAtMillis: Long,
    val isLiked: Boolean,
)

fun RecommendedPostUiModel.toHomeMatchingPostItem(): HomeMatchingPostItem =
    HomeMatchingPostItem(
        postId = postId,
        thumbnailUrl = thumbnailUrl,
        title = title,
        priceType = priceType,
        displayPrice = displayPrice,
        region = region,
        availableTimes = availableTimes,
        treatmentTypes = treatmentTypes.map { it.label },
        createdAtMillis = createdAtMillis,
        isLiked = isLiked,
    )
