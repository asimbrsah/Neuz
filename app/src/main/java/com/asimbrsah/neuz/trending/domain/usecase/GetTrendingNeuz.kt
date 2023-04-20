package com.asimbrsah.neuz.trending.domain.usecase

import com.asimbrsah.neuz.trending.data.model.response.TrendingNeuz
import com.asimbrsah.neuz.trending.domain.repository.TrendingNeuzRepository

internal class GetTrendingNeuz(private val trendingNeuzRepository: TrendingNeuzRepository) {

    suspend operator fun invoke(): TrendingNeuz? {
        return trendingNeuzRepository.getTrendingNews()
    }
}