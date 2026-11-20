package com.sopt.meemong.data.quickmatching.mapper

import com.sopt.meemong.core.model.AvailableTime
import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.core.model.TreatmentType
import com.sopt.meemong.data.quickmatching.remote.dto.RecommendedPostResponse
import com.sopt.meemong.presentation.quickmatching.model.RecommendedPostUiModel
import java.text.SimpleDateFormat
import java.util.Locale

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
        createdAtMillis = createdAt.toPostEpochMillis(),
        isLiked = isLiked,
    )

private fun String.toPostEpochMillis(): Long {
    val normalized = replace(Regex("\\.\\d+(?=Z|[+-]\\d{2}:\\d{2}$)"), "")

    return requireNotNull(
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.KOREA).apply {
            isLenient = false
        }.parse(normalized),
    ) {
        "공고 작성 시간을 변환할 수 없습니다: $this"
    }.time
}
