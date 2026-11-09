package com.sopt.meemong.core.common.extensions

import java.text.NumberFormat
import java.util.Locale

/**
 * Int형 수를 천 단위로 포맷팅합니다.
 * */
fun Int.toPriceFormat(): String =
    "${NumberFormat.getNumberInstance(Locale.KOREA).format(this)}"

/**
 * Long형 수를 천 단위로 포맷팅합니다.
 * */
fun Long.toPriceFormat(): String =
    "${NumberFormat.getNumberInstance(Locale.KOREA).format(this)}"
