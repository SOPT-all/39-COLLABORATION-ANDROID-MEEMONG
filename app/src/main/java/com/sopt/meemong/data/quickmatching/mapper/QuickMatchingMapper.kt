package com.sopt.meemong.data.quickmatching.mapper

import com.sopt.meemong.core.common.extensions.toAvailableTimeOrNull
import com.sopt.meemong.core.common.extensions.toEpochMillis
import com.sopt.meemong.core.common.extensions.toPriceType
import com.sopt.meemong.core.common.extensions.toTreatmentTypeOrNull
import com.sopt.meemong.core.model.AvailableTime
import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.core.model.TreatmentType
import com.sopt.meemong.data.quickmatching.model.GeneralPost
import com.sopt.meemong.data.quickmatching.remote.dto.GeneralPostResponse
import com.sopt.meemong.data.quickmatching.remote.dto.RecommendedPostResponse
import com.sopt.meemong.presentation.quickmatching.model.RecommendedPostUiModel

fun RecommendedPostResponse.toRecommendedPostUiModel(): RecommendedPostUiModel =
    RecommendedPostUiModel(
        postId = postId,
        thumbnailUrl = thumbnailUrl,
        title = title,
        priceType = PriceType.valueOf(priceType),
        displayPrice = displayPrice,
        region = region,
        availableTimes = availableTimes.map { AvailableTime.valueOf(it) },
        treatmentTypes = treatmentTypes.map { TreatmentType.valueOf(it) },
        createdAtMillis = createdAt.toEpochMillis(),
        isLiked = isLiked,
    )

fun GeneralPostResponse.toGeneralPost(): GeneralPost =
    GeneralPost(
        postId = postId,
        designerProfileImageUrl = designerProfileImageUrl,
        designerName = designerName,
        createdAtMillis = createdAt.toEpochMillis(),
        region = region,
        title = title,
        priceType = priceType.toPriceType(),
        displayPrice = displayPrice,
        availableTimes = availableTimes.mapNotNull { it.toAvailableTimeOrNull() },
        treatmentTypes = treatmentTypes.mapNotNull { it.toTreatmentTypeOrNull() },
        isLiked = isLiked,
    )
