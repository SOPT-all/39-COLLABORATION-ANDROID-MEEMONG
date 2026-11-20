package com.sopt.meemong.data.matchingdetail.remote.service

import com.sopt.meemong.core.network.BaseResponse
import com.sopt.meemong.data.matchingdetail.remote.dto.DesignerDetailResponse
import com.sopt.meemong.data.matchingdetail.remote.dto.MatchingDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MatchingDetailService {
    @GET("api/v1/posts/{postId}")
    suspend fun getPostDetail(
        @Path("postId") postId: Long,
    ): BaseResponse<MatchingDetailResponse>

    @GET("api/v1/posts/{postId}/designer")
    suspend fun getDesignerDetail(
        @Path("postId") postId: Long,
    ): BaseResponse<DesignerDetailResponse>
}
