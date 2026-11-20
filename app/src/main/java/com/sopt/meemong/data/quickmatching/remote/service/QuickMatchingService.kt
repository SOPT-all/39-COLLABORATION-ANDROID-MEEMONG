package com.sopt.meemong.data.quickmatching.remote.service

import com.sopt.meemong.core.network.BaseResponse
import com.sopt.meemong.data.quickmatching.remote.dto.GeneralPostListResponse
import retrofit2.http.GET

interface QuickMatchingService {
    @GET("api/v1/posts/general")
    suspend fun getGeneralPosts(): BaseResponse<GeneralPostListResponse>
}
