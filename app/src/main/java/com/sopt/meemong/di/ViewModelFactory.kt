package com.sopt.meemong.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sopt.meemong.presentation.home.HomeViewModel
import com.sopt.meemong.presentation.matchingdetail.MatchingDetailViewModel
import com.sopt.meemong.presentation.quickmatching.QuickMatchingViewModel

class ViewModelFactory(
    private val container: AppContainer,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) ->
                HomeViewModel(container.homeRepository) as T

            modelClass.isAssignableFrom(QuickMatchingViewModel::class.java) ->
                QuickMatchingViewModel(container.quickMatchingRepository) as T

            modelClass.isAssignableFrom(MatchingDetailViewModel::class.java) ->
                MatchingDetailViewModel(container.matchingDetailRepository) as T

            else -> throw IllegalArgumentException(
                "Unknown ViewModel class: ${modelClass.name}",
            )
        }
}