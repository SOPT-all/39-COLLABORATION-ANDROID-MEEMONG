package com.sopt.meemong.data.quickmatching.remote.datasource.impl

import com.sopt.meemong.data.quickmatching.remote.datasource.QuickMatchingDataSource
import com.sopt.meemong.data.quickmatching.remote.service.QuickMatchingService

class QuickMatchingDataSourceImpl(
    private val quickMatchingService: QuickMatchingService
) : QuickMatchingDataSource
