package com.sopt.meemong.presentation.home.model

data class HomeProductItem(
    val imageUrl: String,
    val tag: String,
    val name: String,
    val originalPrice: Int,
    val discountRate: Int,
    val salePrice: Int,
)
