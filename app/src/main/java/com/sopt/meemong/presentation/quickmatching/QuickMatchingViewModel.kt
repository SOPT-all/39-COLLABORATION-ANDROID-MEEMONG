package com.sopt.meemong.presentation.quickmatching

import com.sopt.meemong.core.base.BaseViewModel
import com.sopt.meemong.data.quickmatching.repository.QuickMatchingRepository
import com.sopt.meemong.presentation.quickmatching.component.MatchingCategory

class QuickMatchingViewModel(
    private val quickMatchingRepository: QuickMatchingRepository,
) : BaseViewModel<QuickMatchingUiState, QuickMatchingUiEffect>(
    initialState = QuickMatchingUiState.dummy,
) {
    fun onCategoryClick(category: MatchingCategory) {
        updateState { copy(selectedCategory = category) }
    }
}