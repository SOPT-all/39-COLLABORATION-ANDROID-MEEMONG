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
            val response = service.getGeneralPosts()

            check(response.code == "SUCCESS") { "일반 공고 조회 실패: ${response.code}" }
            val data = checkNotNull(response.data) { "일반 공고 응답에 data가 없습니다." }

            data.posts.map { it.toGeneralPost() }
        }
}
