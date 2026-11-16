package com.sopt.meemong.presentation.matchingdetail

import com.sopt.meemong.core.base.BaseViewModel
import com.sopt.meemong.data.matchingdetail.repository.MatchingDetailRepository

class MatchingDetailViewModel(
    private val matchingDetailRepository: MatchingDetailRepository,
) :
    BaseViewModel<MatchingDetailUiState, MatchingDetailUiEffect>(
        initialState = MatchingDetailUiState.dummy, // TODO: API 연동 시 빈 값으로 수정
    ) {
    fun onLikeClick() {
        updateState {
            copy(
                serviceInfo = serviceInfo.copy(isLiked = !serviceInfo.isLiked)
            )
        }
    }
}
