package com.sopt.meemong.presentation.matchingdetail

import android.util.Log
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
        initialState = MatchingDetailUiState(
            postId = postId,
            isLoading = true,
        ),
    ) {

    init {
        loadPost()
    }

    private fun loadPost() {
        viewModelScope.launch {
            updateState { copy(isLoading = true) }

            matchingDetailRepository.getPostDetail(postId)
                .onSuccess {
                    updateState {
                        copy(
                            postId = it.postId,
                            isLoading = false,
                            postImageUrls = it.postImageUrls,
                            designerProfileInfo = it.designerProfileInfo,
                            serviceInfo = it.serviceInfo,
                            detailInfo = it.detailInfo,
                        )
                    }
                }
                .onFailure { updateState { copy(isLoading = false) } }
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
