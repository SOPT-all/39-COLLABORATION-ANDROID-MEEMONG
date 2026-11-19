package com.sopt.meemong.data.matchingdetail.remote.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class MatchingDetailResponse(
    @SerializedName("postId")
    val postId: Long,

    @SerializedName("title")
    val title: String,

    @SerializedName("postImageUrls")
    val postImageUrls: List<String>,

    @SerializedName("isLiked")
    val isLiked: Boolean,

    @SerializedName("priceType")
    val priceType: String,

    @SerializedName("discountRate")
    val discountRate: Double?,

    @SerializedName("originalPrice")
    val originalPrice: Int?,

    @SerializedName("displayPrice")
    val displayPrice: Int?,

    @SerializedName("treatmentTypes")
    val treatmentTypes: List<String>,

    @SerializedName("signatures")
    val signatures: List<String>,

    @SerializedName("shootingRanges")
    val shootingRanges: List<String>,

    @SerializedName("shopName")
    val shopName: String,

    @SerializedName("designerId")
    val designerId: Long,

    @SerializedName("designerName")
    val designerName: String,

    @SerializedName("designerProfileImageUrl")
    val designerProfileImageUrl: String,

    @SerializedName("region")
    val region: String,

    @SerializedName("completedTreatmentCount")
    val completedTreatmentCount: Int,

    @SerializedName("content")
    val content: String,
)

