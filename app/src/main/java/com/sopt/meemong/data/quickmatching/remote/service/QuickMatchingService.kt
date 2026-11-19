package com.sopt.meemong.data.quickmatching.remote.service

import com.sopt.meemong.core.network.BaseResponse
import com.sopt.meemong.data.quickmatching.remote.dto.RecommendedPostListResponse
import retrofit2.http.GET

interface QuickMatchingService {
    @GET("api/v1/posts/recommended")
    suspend fun getRecommendedPosts(): BaseResponse<RecommendedPostListResponse>
}

