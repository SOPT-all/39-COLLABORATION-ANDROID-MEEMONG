package com.sopt.meemong.presentation.quickmatching

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.sopt.meemong.core.base.BaseViewModel
import com.sopt.meemong.data.quickmatching.repository.QuickMatchingRepository
import com.sopt.meemong.presentation.quickmatching.component.MatchingCategory
import kotlinx.coroutines.launch

class QuickMatchingViewModel(
    private val quickMatchingRepository: QuickMatchingRepository,
) : BaseViewModel<QuickMatchingUiState, QuickMatchingUiEffect>(
    initialState = QuickMatchingUiState.dummy.copy(
        designerRecommendedPosts = emptyList(),
    ),
) {
    private val pendingLikePostIds = mutableSetOf<Long>()

    init {
        loadRecommendedPosts()
    }

    fun onCategoryClick(category: MatchingCategory) {
        updateState { copy(selectedCategory = category) }
    }

    fun onLikeChange(postId: Long, isLiked: Boolean) {
        val state = currentState
        val recommendedPost = state.designerRecommendedPosts
            .firstOrNull { it.postId == postId }
            .takeIf { state.selectedCategory == MatchingCategory.DESIGNER }

        if (recommendedPost == null) {
            updateLocalLikeState(postId, isLiked)
            return
        }

        if (!pendingLikePostIds.add(postId)) return

        val previousIsLiked = recommendedPost.isLiked
        updateRecommendedLikeState(postId, isLiked)

        viewModelScope.launch {
            try {
                quickMatchingRepository.updatePostLike(
                    postId = postId,
                    isLiked = isLiked,
                ).onSuccess { serverIsLiked ->
                    updateRecommendedLikeState(postId, serverIsLiked)
                }.onFailure { exception ->
                    updateRecommendedLikeState(postId, previousIsLiked)
                    Log.e("QuickMatchingViewModel", "공고 찜 변경 실패", exception)
                }
            } finally {
                pendingLikePostIds.remove(postId)
            }
        }
    }

    private fun updateRecommendedLikeState(postId: Long, isLiked: Boolean) {
        updateState {
            copy(
                designerRecommendedPosts = designerRecommendedPosts.map { post ->
                    if (post.postId == postId) post.copy(isLiked = isLiked) else post
                },
            )
        }
    }

    private fun updateLocalLikeState(postId: Long, isLiked: Boolean) {
        updateState {
            copy(
                designerRecommendedPosts = designerRecommendedPosts.map { post ->
                    if (post.postId == postId) post.copy(isLiked = isLiked) else post
                },
                designerGeneralPosts = designerGeneralPosts.map { post ->
                    if (post.postId == postId) post.copy(isLiked = isLiked) else post
                },
                modelRecommendedPosts = modelRecommendedPosts.map { post ->
                    if (post.postId == postId) post.copy(isLiked = isLiked) else post
                },
                modelGeneralPosts = modelGeneralPosts.map { post ->
                    if (post.postId == postId) post.copy(isLiked = isLiked) else post
                },
            )
        }
    }

    private fun loadRecommendedPosts() {
        viewModelScope.launch {
            quickMatchingRepository.getRecommendedPosts()
                .onSuccess { posts ->
                    updateState {
                        copy(designerRecommendedPosts = posts)
                    }
                }
                .onFailure { exception ->
                    Log.e(
                        "QuickMatchingViewModel",
                        "추천 공고 조회 실패",
                        exception,
                    )
                }
        }
    }
}
