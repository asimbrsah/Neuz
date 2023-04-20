package com.asimbrsah.neuz.trending.data.source.repository

import com.asimbrsah.neuz.trending.data.model.response.TrendingNeuz
import com.asimbrsah.neuz.trending.domain.repository.TrendingNeuzRepository
import com.asimbrsah.neuz.trending.data.source.local.TrendingNeuzDao
import com.asimbrsah.neuz.trending.data.source.remote.TrendingNeuzApiService

internal class TrendingNeuzRepositoryImpl(
    private val trendingNeuzApiService: TrendingNeuzApiService,
    private val trendingNeuzDao: TrendingNeuzDao,
) : TrendingNeuzRepository {

    override suspend fun getTrendingNews(): TrendingNeuz? {
       return trendingNeuzApiService.getTrendingNews()
    }
}