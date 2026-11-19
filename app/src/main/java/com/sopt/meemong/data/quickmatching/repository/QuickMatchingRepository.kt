package com.sopt.meemong.data.quickmatching.repository

import com.sopt.meemong.data.quickmatching.mapper.toRecommendedPostUiModel
import com.sopt.meemong.data.quickmatching.remote.service.QuickMatchingService
import com.sopt.meemong.presentation.quickmatching.model.RecommendedPostUiModel
import kotlin.coroutines.cancellation.CancellationException

class QuickMatchingRepository(
    private val service: QuickMatchingService,
) {
    suspend fun getRecommendedPosts(): Result<List<RecommendedPostUiModel>> =
        try {
            val response = service.getRecommendedPosts()

            check(response.code == "SUCCESS") {
                "추천 공고 조회 실패: ${response.code}"
            }

            val data = checkNotNull(response.data) {
                "추천 공고 응답에 data가 없습니다."
            }

            Result.success(
                data.posts.map { it.toRecommendedPostUiModel() },
            )
        } catch (exception: CancellationException) {
            throw exception
        } catch (exception: Exception) {
            Result.failure(exception)
        }

    suspend fun updatePostLike(
        postId: Long,
        isLiked: Boolean,
    ): Result<Boolean> =
        try {
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

            Result.success(data.isLiked)
        } catch (exception: CancellationException) {
            throw exception
        } catch (exception: Exception) {
            Result.failure(exception)
        }
}
