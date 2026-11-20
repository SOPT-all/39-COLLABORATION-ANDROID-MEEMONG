package com.sopt.meemong.data.matchingdetail.model

data class MatchingDetail(
    val postId: Long,
    val postImageUrls: List<String>,
    val designerProfileInfo: DesignerProfileInfo,
    val serviceInfo: ServiceInfo,
    val detailInfo: DetailInfo,
)
