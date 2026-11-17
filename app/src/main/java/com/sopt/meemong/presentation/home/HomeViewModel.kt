package com.sopt.meemong.presentation.home

import com.sopt.meemong.core.base.BaseViewModel
import com.sopt.meemong.data.home.repository.HomeRepository

class HomeViewModel(
    private val homeRepository: HomeRepository,
) :
    BaseViewModel<HomeUiState, HomeUiEffect>(
        initialState = HomeUiState.dummy, // TODO: API 연동 시 HomeUiState()로 변경
    ) {

}
