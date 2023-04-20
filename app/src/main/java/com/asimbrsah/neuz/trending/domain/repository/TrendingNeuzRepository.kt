package com.asimbrsah.neuz.trending.domain.repository

import com.asimbrsah.neuz.trending.data.model.response.TrendingNeuz

internal interface TrendingNeuzRepository {

    suspend fun getTrendingNews(): TrendingNeuz?
}