package com.sopt.meemong.presentation.matchingdetail

import androidx.lifecycle.viewModelScope
import com.sopt.meemong.core.base.BaseViewModel
import com.sopt.meemong.data.matchingdetail.model.TabType
import com.sopt.meemong.data.matchingdetail.repository.MatchingDetailRepository
import kotlinx.coroutines.launch

class MatchingDetailViewModel(
    private val postId: Long,
    private val matchingDetailRepository: MatchingDetailRepository,
) :
    BaseViewModel<MatchingDetailUiState, MatchingDetailUiEffect>(
        initialState = MatchingDetailUiState(),
    ) {

    init {
        loadPost()
    }

    private fun loadPost() {
        viewModelScope.launch {
            matchingDetailRepository.getPostDetail(postId)
                .onSuccess { post ->
                    updateState {
                        copy(
                            postId = post.postId,
                            postImageUrls = post.postImageUrls,
                            designerProfileInfo = post.designerProfileInfo,
                            serviceInfo = post.serviceInfo,
                            detailInfo = post.detailInfo,
                        )
                    }
                }
                .onFailure {
                    throw Error("임시 에러")
                }
        }
    }

    fun onLikeClick() {
        updateState {
            copy(serviceInfo = serviceInfo.copy(isLiked = !serviceInfo.isLiked))
        }
    }

    fun onTabClick(tab: TabType) {
        updateState { copy(currentTab = tab) }
    }
}
