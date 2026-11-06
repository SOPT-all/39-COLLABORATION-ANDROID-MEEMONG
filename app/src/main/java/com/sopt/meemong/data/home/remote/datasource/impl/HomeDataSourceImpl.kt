package com.sopt.meemong.data.home.remote.datasource.impl

import com.sopt.meemong.data.home.remote.datasource.HomeDataSource
import com.sopt.meemong.data.home.remote.service.HomeService

class HomeDataSourceImpl(
    private val homeService: HomeService
) : HomeDataSource
