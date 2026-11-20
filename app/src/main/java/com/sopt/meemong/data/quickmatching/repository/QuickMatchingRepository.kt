package com.sopt.meemong.data.quickmatching.repository

import com.sopt.meemong.core.common.util.suspendRunCatching
import com.sopt.meemong.data.quickmatching.mapper.toGeneralPost
import com.sopt.meemong.data.quickmatching.mapper.toRecommendedPostUiModel
import com.sopt.meemong.data.quickmatching.model.GeneralPost
import com.sopt.meemong.data.quickmatching.remote.service.QuickMatchingService
import com.sopt.meemong.presentation.quickmatching.model.RecommendedPostUiModel

class QuickMatchingRepository(
    private val service: QuickMatchingService,
) {
    suspend fun getRecommendedPosts(): Result<List<RecommendedPostUiModel>> =
        suspendRunCatching {
            val response = service.getRecommendedPosts()

            check(response.code == "SUCCESS") {
                "추천 공고 조회 실패: ${response.code}"
            }

            val data = checkNotNull(response.data) {
                "추천 공고 응답에 data가 없습니다."
            }

            data.posts.map { it.toRecommendedPostUiModel() }
        }

    suspend fun updatePostLike(
        postId: Long,
        isLiked: Boolean,
    ): Result<Boolean> =
        suspendRunCatching {
            val response = if (isLiked) {
                service.likePost(postId)
            } else {
                service.unlikePost(postId)
            }

            check(response.code == "SUCCESS") {
                "공고 찜 변경 실패: ${response.code}"
            }

            val data = checkNotNull(response.data) {
                "공고 찜 응답에 data가 없습니다."
            }

            data.isLiked
        }

    suspend fun getGeneralPosts(): Result<List<GeneralPost>> =
        suspendRunCatching {
            val response = service.getGeneralPosts()

            check(response.code == "SUCCESS") { "일반 공고 조회 실패: ${response.code}" }
            val data = checkNotNull(response.data) { "일반 공고 응답에 data가 없습니다." }

            data.posts.map { it.toGeneralPost() }
        }
}
