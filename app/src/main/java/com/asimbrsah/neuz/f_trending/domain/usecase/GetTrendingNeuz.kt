package com.asimbrsah.neuz.f_trending.domain.usecase

import com.asimbrsah.neuz.f_trending.domain.model.TrendingNeuz
import com.asimbrsah.neuz.f_trending.domain.repository.TrendingNeuzRepository

internal class GetTrendingNeuz(private val trendingNeuzRepository: TrendingNeuzRepository) {

    suspend operator fun invoke(): TrendingNeuz? {
        return trendingNeuzRepository.getTrendingNews()
    }
}