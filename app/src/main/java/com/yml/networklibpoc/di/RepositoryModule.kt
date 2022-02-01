package com.yml.networklibpoc.di

import com.yml.networklib.api.UniversityDataSource
import com.yml.networklibpoc.data.repository.UniversityRepositoryImpl
import com.yml.networklibpoc.domain.repository.UniversityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun getUniversityRepository(universityDataSource: UniversityDataSource): UniversityRepository {
        return UniversityRepositoryImpl(universityDataSource)
    }
}