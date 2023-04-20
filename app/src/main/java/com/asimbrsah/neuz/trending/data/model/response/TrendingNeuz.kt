package com.asimbrsah.neuz.trending.data.model.response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("trendingNeuz")
internal data class TrendingNeuz(
    @PrimaryKey
    val status: String,
)

internal data class Articles(
    val source: Source? = null,
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    val publishedAt: String? = null,
    val content: String? = null
)

internal data class Source(
    val id: String? = null,
    val name: String? = null
)