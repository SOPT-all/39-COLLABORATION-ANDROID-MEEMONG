package com.sopt.meemong.data.quickmatching.remote.service

import com.sopt.meemong.core.network.BaseResponse
import com.sopt.meemong.data.quickmatching.remote.dto.PostLikeResponse
import com.sopt.meemong.data.quickmatching.remote.dto.RecommendedPostListResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface QuickMatchingService {
    @GET("api/v1/posts/recommended")
    suspend fun getRecommendedPosts(): BaseResponse<RecommendedPostListResponse>

    @PUT("api/v1/posts/{postId}/likes")
    suspend fun likePost(
        @Path("postId") postId: Long,
    ): BaseResponse<PostLikeResponse>

    @DELETE("api/v1/posts/{postId}/likes")
    suspend fun unlikePost(
        @Path("postId") postId: Long,
    ): BaseResponse<PostLikeResponse>
}