package com.sopt.meemong.data.matchingdetail.repository

import com.sopt.meemong.core.common.util.suspendRunCatching
import com.sopt.meemong.data.matchingdetail.mapper.toModel
import com.sopt.meemong.data.matchingdetail.model.DetailInfo
import com.sopt.meemong.data.matchingdetail.model.MatchingDetail
import com.sopt.meemong.data.matchingdetail.remote.service.MatchingDetailService

class MatchingDetailRepository(
    private val service: MatchingDetailService,
) {
    suspend fun getPostDetail(postId: Long): Result<MatchingDetail> =
        suspendRunCatching {
            service.getPostDetail(postId = postId)
                .data?.toModel() ?: error("상세 조회 data가 null입니다. postId=$postId")
        }

    suspend fun getDesignerDetail(postId: Long, detailInfo: DetailInfo): Result<DetailInfo> =
        suspendRunCatching {
            service.getDesignerDetail(postId)
                .data?.toModel(detailInfo) ?: error("디자이너 정보 data가 null입니다. postId=$postId")
        }
}
