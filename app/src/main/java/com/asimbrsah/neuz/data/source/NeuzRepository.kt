package com.asimbrsah.neuz.data.source

import com.asimbrsah.neuz.data.model.response.Neuz

internal interface NeuzRepository {
    fun getNewsHeadLines(): Neuz?
}