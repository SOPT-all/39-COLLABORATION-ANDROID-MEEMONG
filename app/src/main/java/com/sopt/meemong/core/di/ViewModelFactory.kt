package com.sopt.meemong.core.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sopt.meemong.data.home.repository.HomeRepository
import com.sopt.meemong.data.matchingdetail.repository.MatchingDetailRepository
import com.sopt.meemong.data.quickmatching.repository.QuickMatchingRepository
import com.sopt.meemong.presentation.home.HomeViewModel
import com.sopt.meemong.presentation.matchingdetail.MatchingDetailViewModel
import com.sopt.meemong.presentation.quickmatching.QuickMatchingViewModel

class ViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(HomeRepository()) as T
            }

            modelClass.isAssignableFrom(QuickMatchingViewModel::class.java) -> {
                QuickMatchingViewModel(QuickMatchingRepository()) as T
            }

            modelClass.isAssignableFrom(MatchingDetailViewModel::class.java) -> {
                MatchingDetailViewModel(MatchingDetailRepository()) as T
            }

            else -> throw IllegalArgumentException(
                "Unknown ViewModel class: ${modelClass.name}"
            )
        }
    }
}
