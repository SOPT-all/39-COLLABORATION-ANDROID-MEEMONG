package com.sopt.meemong.presentation.quickmatching

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.sopt.meemong.core.base.BaseViewModel
import com.sopt.meemong.data.quickmatching.repository.QuickMatchingRepository
import com.sopt.meemong.presentation.quickmatching.component.MatchingCategory
import com.sopt.meemong.presentation.quickmatching.model.toUiModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class QuickMatchingViewModel(
    private val quickMatchingRepository: QuickMatchingRepository,
) : BaseViewModel<QuickMatchingUiState, QuickMatchingUiEffect>(
    initialState = QuickMatchingUiState.dummy.copy(
        designerRecommendedPosts = emptyList(),
        designerGeneralPosts = emptyList(),
    ),
) {
    private var refreshJob: Job? = null
    private var refreshAfterLike = false

    fun refreshPosts() {
        if (currentState.pendingLikePostIds.isNotEmpty()) {
            refreshAfterLike = true
            return
        }
        refreshAfterLike = false
        refreshJob?.cancel()
        refreshJob = viewModelScope.launch {
            launch { loadRecommendedPosts() }
            launch { loadGeneralPosts() }
        }
    }

    fun onCategoryClick(category: MatchingCategory) {
        updateState { copy(selectedCategory = category) }
    }

    fun onLikeChange(postId: Long, isLiked: Boolean) {
        val state = currentState
        if (state.selectedCategory == MatchingCategory.MODEL) {
            updateModelLikeState(postId, isLiked)
            return
        }

        val previousIsLiked = state.designerRecommendedPosts
            .firstOrNull { it.postId == postId }?.isLiked
            ?: state.designerGeneralPosts.firstOrNull { it.postId == postId }?.isLiked
            ?: return

        if (postId in state.pendingLikePostIds) return

        updateState {
            copy(pendingLikePostIds = pendingLikePostIds + postId)
        }

        if (refreshJob?.isActive == true) {
            refreshJob?.cancel()
            refreshAfterLike = true
        }

        updateDesignerLikeState(postId, isLiked)

        viewModelScope.launch {
            try {
                quickMatchingRepository.updatePostLike(
                    postId = postId,
                    isLiked = isLiked,
                ).onSuccess { serverIsLiked ->
                    updateDesignerLikeState(postId, serverIsLiked)
                }.onFailure { exception ->
                    updateDesignerLikeState(postId, previousIsLiked)
                    Log.e("QuickMatchingViewModel", "공고 찜 변경 실패", exception)
                }
            } finally {
                updateState {
                    copy(pendingLikePostIds = pendingLikePostIds - postId)
                }
                if (refreshAfterLike && currentState.pendingLikePostIds.isEmpty()) {
                    refreshPosts()
                }
            }
        }
    }

    private fun updateDesignerLikeState(postId: Long, isLiked: Boolean) {
        updateState {
            copy(
                designerRecommendedPosts = designerRecommendedPosts.map { post ->
                    if (post.postId == postId) post.copy(isLiked = isLiked) else post
                },
                designerGeneralPosts = designerGeneralPosts.map { post ->
                    if (post.postId == postId) post.copy(isLiked = isLiked) else post
                },
            )
        }
    }

    private fun updateModelLikeState(postId: Long, isLiked: Boolean) {
        updateState {
            copy(
                modelRecommendedPosts = modelRecommendedPosts.map { post ->
                    if (post.postId == postId) post.copy(isLiked = isLiked) else post
                },
                modelGeneralPosts = modelGeneralPosts.map { post ->
                    if (post.postId == postId) post.copy(isLiked = isLiked) else post
                },
            )
        }
    }

    private suspend fun loadRecommendedPosts() {
        quickMatchingRepository.getRecommendedPosts()
            .onSuccess { posts ->
                updateState { copy(designerRecommendedPosts = posts) }
            }
            .onFailure { exception ->
                Log.e("QuickMatchingViewModel", "추천 공고 조회 실패", exception)
            }
    }

    private suspend fun loadGeneralPosts() {
        quickMatchingRepository.getGeneralPosts()
            .onSuccess { posts ->
                updateState { copy(designerGeneralPosts = posts.map { it.toUiModel() }) }
            }
            .onFailure { exception ->
                Log.e("QuickMatchingViewModel", "일반 공고 조회 실패", exception)
            }
    }
}
