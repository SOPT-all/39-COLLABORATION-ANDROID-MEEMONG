package com.sopt.meemong.data.quickmatching.repository

import com.sopt.meemong.core.common.util.suspendRunCatching
import com.sopt.meemong.data.quickmatching.mapper.toGeneralPostUiModel
import com.sopt.meemong.data.quickmatching.remote.service.QuickMatchingService
import com.sopt.meemong.presentation.quickmatching.model.GeneralPostUiModel

class QuickMatchingRepository(
    private val service: QuickMatchingService,
) {
    suspend fun getGeneralPosts(): Result<List<GeneralPostUiModel>> =
        suspendRunCatching {
            service.getGeneralPosts().data?.posts.orEmpty()
                .map { it.toGeneralPostUiModel() }
        }
}
