package com.asimbrsah.neuz.trending.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asimbrsah.neuz.trending.data.model.response.TrendingNeuz

@Database(
    entities = [TrendingNeuz::class],
    version = 1
)
internal abstract class TrendingNeuzDataBase : RoomDatabase() {

    abstract val trendingNeuzDao: TrendingNeuzDao

    companion object {
        const val DATABASE_NAME = "trending_neuz_db"
    }
}