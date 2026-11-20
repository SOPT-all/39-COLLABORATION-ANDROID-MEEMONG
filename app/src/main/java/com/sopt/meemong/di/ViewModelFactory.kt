package com.sopt.meemong.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sopt.meemong.presentation.home.HomeViewModel
import com.sopt.meemong.presentation.matchingdetail.MatchingDetailViewModel
import com.sopt.meemong.presentation.quickmatching.QuickMatchingViewModel

class ViewModelFactory(
    private val container: AppContainer,
    private val postId: Long = 0L,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) ->
                HomeViewModel(container.homeRepository) as T

            modelClass.isAssignableFrom(QuickMatchingViewModel::class.java) ->
                QuickMatchingViewModel(container.quickMatchingRepository) as T

            modelClass.isAssignableFrom(MatchingDetailViewModel::class.java) ->
                MatchingDetailViewModel(
                    postId,
                    container.matchingDetailRepository,
                    container.quickMatchingRepository,
                ) as T

            else -> throw IllegalArgumentException(
                "Unknown ViewModel class: ${modelClass.name}",
            )
        }
}