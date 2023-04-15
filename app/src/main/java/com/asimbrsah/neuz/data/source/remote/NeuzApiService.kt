package com.asimbrsah.neuz.data.source.remote

import com.asimbrsah.neuz.data.model.response.Neuz
import retrofit2.http.GET

internal interface NeuzApiService {
    @GET("/v2/top-headlines?country=in&apiKey=3de60294c0724c219cfc0f6bce3b5a82")
    fun getNewsHeadLines(): Neuz?
}