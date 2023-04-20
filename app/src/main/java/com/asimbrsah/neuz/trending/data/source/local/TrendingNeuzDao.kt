package com.asimbrsah.neuz.trending.data.source.local

import androidx.room.Dao
import androidx.room.Query
import com.asimbrsah.neuz.trending.data.model.response.TrendingNeuz

@Dao
internal interface TrendingNeuzDao {

    @Query("SELECT * FROM trendingNeuz")
    suspend fun getTrendingNews(): TrendingNeuz?
}