package com.sopt.meemong.presentation.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.sopt.meemong.core.base.BaseViewModel
import com.sopt.meemong.data.home.repository.HomeRepository
import com.sopt.meemong.data.quickmatching.repository.QuickMatchingRepository
import com.sopt.meemong.presentation.home.component.HomeQuickMenuItem
import com.sopt.meemong.presentation.home.model.HomeMatchingPostItem
import com.sopt.meemong.presentation.home.model.toHomeMatchingPostItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel(
    private val homeRepository: HomeRepository,
    private val quickMatchingRepository: QuickMatchingRepository,
) : BaseViewModel<HomeUiState, HomeUiEffect>(
    initialState = HomeUiState.dummy.copy(matchingPosts = emptyList()),
) {
    private var refreshJob: Job? = null
    private var refreshAfterLike = false

    fun refreshMatchingPosts() {
        if (currentState.pendingLikePostIds.isNotEmpty()) {
            refreshAfterLike = true
            return
        }
        refreshAfterLike = false
        refreshJob?.cancel()
        refreshJob = viewModelScope.launch {
            quickMatchingRepository.getRecommendedPosts()
                .onSuccess { posts ->
                    updateState { copy(matchingPosts = posts.map { it.toHomeMatchingPostItem() }) }
                }
                .onFailure { exception ->
                    Log.e("HomeViewModel", "홈 추천 공고 조회 실패", exception)
                }
        }
    }

    fun onQuickMenuClick(item: HomeQuickMenuItem) {
        when (item) {
            HomeQuickMenuItem.QUICK_MATCHING -> onMatchingPostMoreClick()
            else -> Unit
        }
    }

    fun onMatchingPostClick(item: HomeMatchingPostItem) {
        if (item.postId in currentState.pendingLikePostIds) return
        sendEffect(HomeUiEffect.NavigateToMatchingDetail(item.postId))
    }

    fun onMatchingPostLikeChange(item: HomeMatchingPostItem, isLiked: Boolean) {
        val postId = item.postId
        val state = currentState
        val post = state.matchingPosts.firstOrNull { it.postId == postId } ?: return
        if (postId in state.pendingLikePostIds) return

        updateState { copy(pendingLikePostIds = pendingLikePostIds + postId) }
        if (refreshJob?.isActive == true) {
            refreshJob?.cancel()
            refreshAfterLike = true
        }

        val previousIsLiked = post.isLiked
        updateMatchingPostLike(postId, isLiked)

        viewModelScope.launch {
            try {
                quickMatchingRepository.updatePostLike(postId, isLiked)
                    .onSuccess { serverIsLiked ->
                        updateMatchingPostLike(postId, serverIsLiked)
                    }
                    .onFailure { exception ->
                        updateMatchingPostLike(postId, previousIsLiked)
                        Log.e("HomeViewModel", "홈 공고 찜 변경 실패 postId=$postId", exception)
                    }
            } finally {
                updateState { copy(pendingLikePostIds = pendingLikePostIds - postId) }
                if (refreshAfterLike && currentState.pendingLikePostIds.isEmpty()) {
                    refreshMatchingPosts()
                }
            }
        }
    }

    private fun updateMatchingPostLike(postId: Long, isLiked: Boolean) {
        updateState {
            copy(
                matchingPosts = matchingPosts.map { post ->
                    if (post.postId == postId) post.copy(isLiked = isLiked) else post
                },
            )
        }
    }

    fun onMatchingPostMoreClick() {
        if (currentState.pendingLikePostIds.isNotEmpty()) return
        sendEffect(HomeUiEffect.NavigateToQuickMatching)
    }
}
