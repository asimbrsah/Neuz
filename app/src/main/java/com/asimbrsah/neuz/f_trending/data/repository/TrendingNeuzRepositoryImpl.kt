package com.asimbrsah.neuz.f_trending.data.repository

import com.asimbrsah.neuz.f_trending.data.source.local.TrendingNeuzDao
import com.asimbrsah.neuz.f_trending.data.source.remote.TrendingNeuzApiService
import com.asimbrsah.neuz.f_trending.domain.model.TrendingNeuz
import com.asimbrsah.neuz.f_trending.domain.repository.TrendingNeuzRepository
import com.asimbrsah.neuz.util.InternetConnectivityProvider

internal class TrendingNeuzRepositoryImpl(
    private val trendingNeuzApiService: TrendingNeuzApiService,
    private val trendingNeuzDao: TrendingNeuzDao,
    private val internetConnectivityProvider: InternetConnectivityProvider
) : TrendingNeuzRepository {

    override suspend fun getTrendingNews(): TrendingNeuz? {
        val trendingNews = if (internetConnectivityProvider.isAvailable()) {
            saveTrendingNews(trendingNeuzApiService.getTrendingNews())
            trendingNeuzDao.getTrendingNews()
        } else {
            trendingNeuzDao.getTrendingNews()
        }
        return trendingNews
    }

    override suspend fun saveTrendingNews(trendingNeuz: TrendingNeuz?) {
        return trendingNeuzDao.saveTrendingNews(trendingNeuz)
    }
}