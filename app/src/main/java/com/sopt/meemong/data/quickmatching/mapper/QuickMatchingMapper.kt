package com.sopt.meemong.data.quickmatching.mapper

import com.sopt.meemong.core.common.extensions.toAvailableTimeOrNull
import com.sopt.meemong.core.common.extensions.toEpochMillis
import com.sopt.meemong.core.common.extensions.toPriceType
import com.sopt.meemong.core.common.extensions.toTreatmentTypeOrNull
import com.sopt.meemong.data.quickmatching.model.GeneralPost
import com.sopt.meemong.data.quickmatching.remote.dto.GeneralPostResponse

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
