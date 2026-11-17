package com.sopt.meemong.presentation.home.model

import androidx.annotation.DrawableRes
import com.sopt.meemong.presentation.home.component.DesignerPriceType

data class HomeDesignerItem(
    val portfolioImageResIds: List<Int>,
    @DrawableRes val profileImageResId: Int,
    val name: String,
    val shopName: String,
    val priceType: DesignerPriceType,
    val location: String,
    val materialCost: String = "",
)
