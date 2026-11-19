package com.sopt.meemong.core.common.util

import com.sopt.meemong.core.model.AvailableTime
import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.core.model.TreatmentType
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * 서버 시간 문자열(예: 2026-11-18T13:00:00+09:00)을 밀리초로 바꿉니다.
 * 변환에 실패하면 0을 반환합니다.
 */
fun String.toEpochMillis(): Long {
    val withoutFraction = replace(Regex("\\.\\d+"), "")
    val patterns = listOf("yyyy-MM-dd'T'HH:mm:ssXXX", "yyyy-MM-dd'T'HH:mm:ss")
    patterns.forEach { pattern ->
        runCatching {
            SimpleDateFormat(pattern, Locale.KOREA).parse(withoutFraction)?.time
        }.getOrNull()?.let { return it }
    }
    return 0L
}

fun String.toPriceType(): PriceType =
    PriceType.entries.find { it.name == this } ?: PriceType.FREE

fun String.toAvailableTimeOrNull(): AvailableTime? =
    AvailableTime.entries.find { it.name == this }

fun String.toTreatmentTypeOrNull(): TreatmentType? =
    TreatmentType.entries.find { it.name == this }

