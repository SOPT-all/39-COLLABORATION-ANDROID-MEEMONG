package com.sopt.meemong.presentation.quickmatching

import com.sopt.meemong.core.base.BaseViewModel
import com.sopt.meemong.data.quickmatching.repository.QuickMatchingRepository

class QuickMatchingViewModel(
    private val quickMatchingRepository: QuickMatchingRepository,
) :
    BaseViewModel<QuickMatchingUiState, QuickMatchingUiEffect>(
        initialState = QuickMatchingUiState
    ) {

}
