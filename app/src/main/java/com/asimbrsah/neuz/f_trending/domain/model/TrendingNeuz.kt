package com.asimbrsah.neuz.f_trending.domain.model

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

// Use `@Fts3` only if your app has strict disk space requirements or if you
// require compatibility with an older SQLite version.
@Fts4
@Entity("trending_neuz")
internal data class TrendingNeuz(
    val status: String?,
    val totalResults: Int?,
    val articles: List<TrendingArticles>?,
)

internal data class TrendingArticles(
    @Embedded
    val source: TrendingSource?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)

internal data class TrendingSource(
    val id: String?,
    val name: String?
)

@ProvidedTypeConverter
internal class TrendingArticlesConverter(
    private val gson: Gson
) {
    @TypeConverter
    fun toTrendingArticlesJson(json: List<TrendingArticles>?): String {
        return gson.toJson(json, object : TypeToken<List<TrendingArticles>>() {}.type) ?: "[]"
    }

    @TypeConverter
    fun fromTrendingArticlesJson(json: String?): List<TrendingArticles> {
        return gson.fromJson<List<TrendingArticles>>(
            json,
            object : TypeToken<List<TrendingArticles>>() {}.type
        ) ?: emptyList()
    }
}