package com.yml.networklib.di

import com.yml.networklib.api.UniversityDataSource
import com.yml.networklib.api.UniversityDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideDataSource(): UniversityDataSource {
        return UniversityDataSourceImpl()
    }
}