package com.sopt.meemong.data.quickmatching.mapper

import com.sopt.meemong.core.common.util.toAvailableTimeOrNull
import com.sopt.meemong.core.common.util.toEpochMillis
import com.sopt.meemong.core.common.util.toPriceType
import com.sopt.meemong.core.common.util.toTreatmentTypeOrNull
import com.sopt.meemong.data.quickmatching.remote.dto.GeneralPostResponse
import com.sopt.meemong.presentation.quickmatching.model.GeneralPostUiModel

fun GeneralPostResponse.toGeneralPostUiModel(): GeneralPostUiModel =
    GeneralPostUiModel(
        postId = postId,
        designerProfileImageUrl = designerProfileImageUrl.orEmpty(),
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
