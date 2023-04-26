package com.asimbrsah.neuz.f_trending.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.asimbrsah.neuz.f_trending.domain.model.TrendingArticlesConverter
import com.asimbrsah.neuz.f_trending.domain.model.TrendingNeuz

@Database(
    entities = [TrendingNeuz::class],
    version = 1
)
@TypeConverters(TrendingArticlesConverter::class)
internal abstract class TrendingNeuzDataBase : RoomDatabase() {

    abstract val trendingNeuzDao: TrendingNeuzDao

    companion object {
        const val DATABASE_NAME = "trending_neuz_db"
    }
}