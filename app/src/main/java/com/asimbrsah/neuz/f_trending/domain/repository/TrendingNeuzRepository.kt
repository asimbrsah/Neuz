package com.asimbrsah.neuz.f_trending.domain.repository

import com.asimbrsah.neuz.f_trending.domain.model.TrendingNeuz

internal interface TrendingNeuzRepository {

    suspend fun getTrendingNews(): TrendingNeuz?

    suspend fun saveTrendingNews(trendingNeuz: TrendingNeuz?)
}