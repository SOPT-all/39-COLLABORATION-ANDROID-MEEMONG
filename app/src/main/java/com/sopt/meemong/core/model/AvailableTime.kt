package com.sopt.meemong.core.model

enum class AvailableTime(
    val label: String,
) {
    WEEKDAY_MORNING("평일 오전"),
    WEEKDAY_AFTERNOON("평일 오후"),
    WEEKEND_MORNING("주말 오전"),
    ANYTIME("시간 상관없음"),
}
