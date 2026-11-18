package com.sopt.meemong.data.matchingdetail.model

data class DesignerProfileInfo(
    val designerId: Long,
    val designerName: String,
    val designerProfileImageUrl: String,
    val region: String,
    val completedTreatmentCount: Int,
)
