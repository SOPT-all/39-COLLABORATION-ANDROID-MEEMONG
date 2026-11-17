package com.sopt.meemong.di

import com.sopt.meemong.data.home.repository.HomeRepository
import com.sopt.meemong.data.matchingdetail.repository.MatchingDetailRepository
import com.sopt.meemong.data.quickmatching.repository.QuickMatchingRepository

class AppContainer {
    val homeRepository: HomeRepository by lazy { HomeRepository() }
    val quickMatchingRepository: QuickMatchingRepository by lazy {
        QuickMatchingRepository()
    }
    val matchingDetailRepository: MatchingDetailRepository by lazy {
        MatchingDetailRepository()
    }
}
