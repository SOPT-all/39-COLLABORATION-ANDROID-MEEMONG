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
    initialState = QuickMatchingUiState.dummy.copy(designerGeneralPosts = emptyList())
) {
    init {
        loadGeneralPosts()
    }

    private fun loadGeneralPosts() {
        viewModelScope.launch {
            quickMatchingRepository.getGeneralPosts()
                .onSuccess { posts -> updateState { copy(designerGeneralPosts = posts) } }
                .onFailure { Log.e("QuickMatchingViewModel", "일반 공고 조회 실패", it) }
        }
    }

    fun onCategoryClick(category: MatchingCategory) {
        updateState { copy(selectedCategory = category) }
    }

    fun onLikeChange(postId: Long, isLiked: Boolean) {
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
}
