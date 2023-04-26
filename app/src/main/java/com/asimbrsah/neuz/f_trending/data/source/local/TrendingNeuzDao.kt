package com.asimbrsah.neuz.f_trending.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asimbrsah.neuz.f_trending.domain.model.TrendingNeuz

@Dao
internal interface TrendingNeuzDao {

    @Query("SELECT * FROM trending_neuz")
    suspend fun getTrendingNews(): TrendingNeuz?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTrendingNews(trendingNeuz: TrendingNeuz?)
}