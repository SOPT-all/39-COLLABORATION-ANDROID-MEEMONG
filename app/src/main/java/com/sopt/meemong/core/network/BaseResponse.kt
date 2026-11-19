package com.sopt.meemong.core.network

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("code")
    val code: String,
    @SerializedName("data")
    val data: T?,
)
