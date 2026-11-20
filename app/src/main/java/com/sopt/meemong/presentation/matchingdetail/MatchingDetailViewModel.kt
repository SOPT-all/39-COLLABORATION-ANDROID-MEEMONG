package com.sopt.meemong.presentation.matchingdetail

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.sopt.meemong.core.base.BaseViewModel
import com.sopt.meemong.data.matchingdetail.model.DetailInfo
import com.sopt.meemong.data.matchingdetail.model.TabType
import com.sopt.meemong.data.matchingdetail.repository.MatchingDetailRepository
import com.sopt.meemong.data.quickmatching.repository.QuickMatchingRepository
import kotlinx.coroutines.launch

class MatchingDetailViewModel(
    private val postId: Long,
    private val matchingDetailRepository: MatchingDetailRepository,
    private val quickMatchingRepository: QuickMatchingRepository,
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
                            isPostLoaded = true,
                            isLoading = false,
                            postImageUrls = it.postImageUrls,
                            designerProfileInfo = it.designerProfileInfo,
                            serviceInfo = it.serviceInfo,
                            detailInfo = it.detailInfo,
                        )
                    }
                    loadDesignerDetail(it.detailInfo)
                }
                .onFailure {
                    Log.e("MatchingDetailViewModel", "상세 조회 실패 postId=$postId", it)
                    updateState { copy(isLoading = false) }
                }
        }
    }

    private suspend fun loadDesignerDetail(baseDetailInfo: DetailInfo) {
        matchingDetailRepository.getDesignerDetail(postId, baseDetailInfo)
            .onSuccess { updateState { copy(detailInfo = it) } }
            .onFailure {
                Log.e("MatchingDetailViewModel", "디자이너 정보 조회 실패 postId=$postId", it)
            }
    }

    fun onLikeClick() {
        val state = currentState
        if (!state.isPostLoaded || state.isLikeLoading) return

        val previousIsLiked = state.serviceInfo.isLiked
        updateState {
            copy(
                isLikeLoading = true,
                serviceInfo = serviceInfo.copy(isLiked = !previousIsLiked),
            )
        }

        viewModelScope.launch {
            try {
                quickMatchingRepository.updatePostLike(postId, !previousIsLiked)
                    .onSuccess { serverIsLiked ->
                        updateState { copy(serviceInfo = serviceInfo.copy(isLiked = serverIsLiked)) }
                    }
                    .onFailure { exception ->
                        updateState { copy(serviceInfo = serviceInfo.copy(isLiked = previousIsLiked)) }
                        Log.e("MatchingDetailViewModel", "공고 찜 변경 실패 postId=$postId", exception)
                    }
            } finally {
                updateState { copy(isLikeLoading = false) }
            }
        }
    }

    fun onTabClick(tab: TabType) {
        updateState { copy(currentTab = tab) }
    }
}
