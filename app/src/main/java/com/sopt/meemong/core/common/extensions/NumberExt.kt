package com.sopt.meemong.core.common.extensions

import java.text.NumberFormat
import java.util.Locale

/**
 * Int형 수를 천 단위로 포맷팅합니다.
 * null일 경우 빈 문자열을 반환합니다.
 * */
fun Int?.toPriceFormat(): String =
    this?.let { NumberFormat.getNumberInstance(Locale.KOREA).format(it) } ?: ""

/**
 * Long형 수를 천 단위로 포맷팅합니다.
 * null일 경우 빈 문자열을 반환합니다.
 * */
fun Long?.toPriceFormat(): String =
    this?.let { NumberFormat.getNumberInstance(Locale.KOREA).format(it) } ?: ""
