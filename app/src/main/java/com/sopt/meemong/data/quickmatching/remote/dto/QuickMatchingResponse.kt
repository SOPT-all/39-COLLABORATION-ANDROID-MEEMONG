package com.sopt.meemong.data.quickmatching.remote.dto

import com.google.gson.annotations.SerializedName
import com.sopt.meemong.core.model.TreatmentType
import java.io.Serial

data class GeneralPostListResponse(
    @SerializedName("posts")
    val posts: List<GeneralPostListResponse>,
)

data class GeneralPostResponse(
    @SerializedName("postId")
    val postId: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("designerName")
    val designerName: String,
    @SerializedName("designerProfileImageUrl")
    val designerProfileImageUrl: String,
    @SerializedName("priceType")
    val priceType: String,
    @SerializedName("displayPrice")
    val displayPrice: Int?,
    @SerializedName("region")
    val region: String,
    @SerializedName("availableTimes")
    val availableTimes: List<String>,
    @SerializedName("treatmentTypes")
    val treatmentTypes: List<String>,
    @SerializedName("isLinked")
    val isLiked: Boolean,
    @SerializedName("createdAt")
    val createdAt: String,
)
