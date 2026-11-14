package com.sopt.meemong.core.common.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun formatPostTime(
    postedAtMillis: Long,
    nowMillis: Long = System.currentTimeMillis(),
) : String {
    val timeZone = TimeZone.getTimeZone("Asia/Seoul")

    val postedCalendar = Calendar.getInstance(timeZone).apply {
        timeInMillis = postedAtMillis
    }

    val todayCalendar = Calendar.getInstance(timeZone).apply {
        timeInMillis = nowMillis
    }

    val yesterdayCalendar = (todayCalendar.clone() as Calendar).apply {
        add(Calendar.DAY_OF_YEAR, -1)
    }

    return when {
        postedCalendar.isSameDate(todayCalendar) -> {
            formatDate(postedAtMillis, "a hh:mm", timeZone)
        }

        postedCalendar.isSameDate(yesterdayCalendar) -> {
            "어제"
        }

        else -> {
            formatDate(postedAtMillis, "MM월 dd일", timeZone)
        }
    }
}

private fun Calendar.isSameDate(
    other: Calendar,
): Boolean =
    get(Calendar.ERA) == other.get(Calendar.ERA) &&
            get(Calendar.YEAR) == other.get(Calendar.YEAR) &&
            get(Calendar.DAY_OF_YEAR) == other.get(Calendar.DAY_OF_YEAR)

private fun formatDate(
    timestampMillis: Long,
    pattern: String,
    timeZone: TimeZone,
): String =
    SimpleDateFormat(pattern, Locale.KOREAN).apply {
        this.timeZone = timeZone
    }.format(Date(timestampMillis))