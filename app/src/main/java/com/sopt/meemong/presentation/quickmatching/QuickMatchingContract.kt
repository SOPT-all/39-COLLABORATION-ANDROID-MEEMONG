package com.sopt.meemong.presentation.quickmatching

import com.sopt.meemong.core.base.BaseUiEffect
import com.sopt.meemong.core.base.BaseUiState
import com.sopt.meemong.presentation.quickmatching.component.MatchingCategory
import com.sopt.meemong.presentation.quickmatching.model.GeneralPostUiModel
import com.sopt.meemong.presentation.quickmatching.model.RecommendedPostUiModel

data class QuickMatchingUiState(
    val selectedCategory: MatchingCategory = MatchingCategory.DESIGNER,
    val designerRecommendedPosts: List<RecommendedPostUiModel> = emptyList(),
    val designerGeneralPosts: List<GeneralPostUiModel> = emptyList(),
    val modelRecommendedPosts: List<RecommendedPostUiModel> = emptyList(),
    val modelGeneralPosts: List<GeneralPostUiModel> = emptyList(),
) : BaseUiState

sealed interface QuickMatchingUiEffect : BaseUiEffect