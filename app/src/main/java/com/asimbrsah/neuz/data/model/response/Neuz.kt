package com.asimbrsah.neuz.data.model.response

internal data class Neuz(
    val status: String? = null,
    val totalResults: Int? = null,
    val articles: List<Articles>? = null
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