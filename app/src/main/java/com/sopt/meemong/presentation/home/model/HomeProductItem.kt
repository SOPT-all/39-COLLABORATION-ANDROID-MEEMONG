package com.sopt.meemong.presentation.home.model

import androidx.annotation.DrawableRes

data class HomeProductItem(
    @DrawableRes val imageResId: Int,
    val tag: String,
    val name: String,
    val originalPrice: Int,
    val discountRate: Int,
    val salePrice: Int,
)
