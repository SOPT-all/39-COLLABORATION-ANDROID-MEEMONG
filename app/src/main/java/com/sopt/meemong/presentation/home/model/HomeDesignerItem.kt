package com.sopt.meemong.presentation.home.model

import com.sopt.meemong.presentation.home.component.DesignerPriceType

data class HomeDesignerItem(
    val portfolioImageUrls: List<String>,
    val profileImageUrl: String,
    val name: String,
    val shopName: String,
    val priceType: DesignerPriceType,
    val location: String,
    val materialCost: String = "",
)
