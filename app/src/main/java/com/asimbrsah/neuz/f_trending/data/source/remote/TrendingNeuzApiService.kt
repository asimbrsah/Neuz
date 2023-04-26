package com.asimbrsah.neuz.f_trending.data.source.remote

import com.asimbrsah.neuz.f_trending.domain.model.TrendingNeuz
import retrofit2.http.GET

internal interface TrendingNeuzApiService {
    @GET("/v2/top-headlines?country=in&apiKey=3de60294c0724c219cfc0f6bce3b5a82")
    suspend fun getTrendingNews(): TrendingNeuz?
}