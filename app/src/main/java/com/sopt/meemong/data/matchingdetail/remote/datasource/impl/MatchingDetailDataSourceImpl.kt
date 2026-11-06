package com.sopt.meemong.data.matchingdetail.remote.datasource.impl

import com.sopt.meemong.data.matchingdetail.remote.datasource.MatchingDetailDataSource
import com.sopt.meemong.data.matchingdetail.remote.service.MatchingDetailService

class MatchingDetailDataSourceImpl(
    private val matchingDetailService: MatchingDetailService
) : MatchingDetailDataSource
