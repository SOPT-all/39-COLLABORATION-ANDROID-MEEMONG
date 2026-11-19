package com.sopt.meemong.data.quickmatching.repository

import com.sopt.meemong.core.common.util.suspendRunCatching
import com.sopt.meemong.data.quickmatching.mapper.toGeneralPost
import com.sopt.meemong.data.quickmatching.model.GeneralPost
import com.sopt.meemong.data.quickmatching.remote.service.QuickMatchingService

class QuickMatchingRepository(
    private val service: QuickMatchingService,
) {
    suspend fun getGeneralPosts(): Result<List<GeneralPost>> =
        suspendRunCatching {
            service.getGeneralPosts().data?.posts.orEmpty()
                .map { it.toGeneralPost() }
        }
}
