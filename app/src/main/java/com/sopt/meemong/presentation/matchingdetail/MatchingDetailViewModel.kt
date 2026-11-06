package com.sopt.meemong.presentation.matchingdetail

import com.sopt.meemong.core.base.BaseViewModel
import com.sopt.meemong.data.matchingdetail.repository.MatchingDetailRepository


class MatchingDetailViewModel(
    private val matchingDetailRepository: MatchingDetailRepository,
) :
    BaseViewModel<MatchingDetailUiState, MatchingDetailUiEffect>(
        initialState = MatchingDetailUiState
    ) {

}
