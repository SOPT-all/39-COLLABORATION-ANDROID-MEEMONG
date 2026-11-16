package com.sopt.meemong.presentation.home

import com.sopt.meemong.core.base.BaseViewModel
import com.sopt.meemong.data.home.repository.HomeRepository

class HomeViewModel(
    private val homeRepository: HomeRepository,
) :
    BaseViewModel<HomeUiState, HomeUiEffect>(
        initialState = com.sopt.meemong.presentation.home.HomeUiState()
    ) {

}
