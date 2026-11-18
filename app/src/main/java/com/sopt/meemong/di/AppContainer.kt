package com.sopt.meemong.di

import com.sopt.meemong.core.network.NetworkModule
import com.sopt.meemong.data.home.remote.service.HomeService
import com.sopt.meemong.data.home.repository.HomeRepository
import com.sopt.meemong.data.matchingdetail.remote.service.MatchingDetailService
import com.sopt.meemong.data.matchingdetail.repository.MatchingDetailRepository
import com.sopt.meemong.data.quickmatching.remote.service.QuickMatchingService
import com.sopt.meemong.data.quickmatching.repository.QuickMatchingRepository

class AppContainer {
    private val homeService by lazy {
        NetworkModule.retrofit.create(HomeService::class.java)
    }
    val homeRepository: HomeRepository by lazy {
        HomeRepository(homeService)
    }

    private val quickMatchingService by lazy {
        NetworkModule.retrofit.create(QuickMatchingService::class.java)
    }
    val quickMatchingRepository: QuickMatchingRepository by lazy {
        QuickMatchingRepository(quickMatchingService)
    }

    private val matchingDetailService by lazy {
        NetworkModule.retrofit.create(MatchingDetailService::class.java)
    }
    val matchingDetailRepository: MatchingDetailRepository by lazy {
        MatchingDetailRepository(matchingDetailService)
    }
}
