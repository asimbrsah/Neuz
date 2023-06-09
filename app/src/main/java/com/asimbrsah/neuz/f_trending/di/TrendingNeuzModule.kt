package com.asimbrsah.neuz.f_trending.di

import android.content.Context
import androidx.room.Room
import com.asimbrsah.neuz.f_trending.domain.repository.TrendingNeuzRepository
import com.asimbrsah.neuz.f_trending.data.source.local.TrendingNeuzDataBase
import com.asimbrsah.neuz.f_trending.data.source.remote.TrendingNeuzApiService
import com.asimbrsah.neuz.f_trending.data.repository.TrendingNeuzRepositoryImpl
import com.asimbrsah.neuz.f_trending.domain.usecase.GetTrendingNeuz
import com.asimbrsah.neuz.f_trending.domain.usecase.TrendingNeuzUseCases
import com.asimbrsah.neuz.util.InternetConnectivityProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class TrendingNeuzModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): TrendingNeuzApiService =
        retrofit.create(TrendingNeuzApiService::class.java)

    @Provides
    @Singleton
    fun provideTrendingNeuzDataBase(@ApplicationContext applicationContext: Context): TrendingNeuzDataBase {
        return Room.databaseBuilder(
            applicationContext,
            TrendingNeuzDataBase::class.java,
            TrendingNeuzDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTrendingNeuzRepository(
        trendingNeuzApiService: TrendingNeuzApiService,
        trendingNeuzDataBase: TrendingNeuzDataBase,
        internetConnectivityProvider: InternetConnectivityProvider
    ): TrendingNeuzRepository {
        return TrendingNeuzRepositoryImpl(
            trendingNeuzApiService = trendingNeuzApiService,
            trendingNeuzDao = trendingNeuzDataBase.trendingNeuzDao,
            internetConnectivityProvider = internetConnectivityProvider
        )
    }

    @Provides
    @Singleton
    fun provideTrendingNeuzUseCases(repository: TrendingNeuzRepository): TrendingNeuzUseCases {
        return TrendingNeuzUseCases(
            getTrendingNeuz = GetTrendingNeuz(repository)
        )
    }
}