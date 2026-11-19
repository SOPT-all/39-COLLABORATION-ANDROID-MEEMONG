package com.sopt.meemong.core.model

enum class PriceType(
    val label: String,
) {
    REVIEW("리뷰특가"),
    FREE("무료시술"),
    NEGOTIABLE("재료비 발생"),
    MODEL_FEE("페이 모델 (모델)"),
}
