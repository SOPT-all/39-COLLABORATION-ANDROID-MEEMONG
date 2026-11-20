package com.sopt.meemong.data.quickmatching.remote.dto

import com.google.gson.annotations.SerializedName

data class PostLikeResponse(
    @SerializedName("isLiked")
    val isLiked: Boolean,
)
