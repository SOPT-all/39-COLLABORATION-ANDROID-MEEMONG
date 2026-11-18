package com.sopt.meemong.presentation.home

import com.sopt.meemong.core.base.BaseViewModel
import com.sopt.meemong.data.home.repository.HomeRepository
import com.sopt.meemong.presentation.home.model.HomeMatchingPostItem
import com.sopt.meemong.presentation.home.component.HomeQuickMenuItem

class HomeViewModel(
    private val homeRepository: HomeRepository,
) :
    BaseViewModel<HomeUiState, HomeUiEffect>(
        initialState = HomeUiState.dummy, // TODO: API 연동 시 HomeUiState()로 변경
    ) {
    fun onQuickMenuClick(item: HomeQuickMenuItem) {
        when (item) {
            HomeQuickMenuItem.QUICK_MATCHING -> sendEffect(HomeUiEffect.NavigateToQuickMatching)
            else -> Unit
        }
    }

    fun onMatchingPostClick(item: HomeMatchingPostItem) {
        sendEffect(HomeUiEffect.NavigateToMatchingDetail)
    }

    fun onMatchingPostLikeChange(item: HomeMatchingPostItem, isLiked: Boolean) {
        updateState {
            copy(
                matchingPosts = matchingPosts.map { post ->
                    if (post.postId == item.postId) post.copy(isLiked = isLiked) else post
                },
            )
        }
    }

    fun onMatchingPostMoreClick() {
        sendEffect(HomeUiEffect.NavigateToQuickMatching)
    }
}
