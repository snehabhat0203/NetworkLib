package com.yml.networklibpoc.di

import com.yml.networklibpoc.domain.repository.UniversityRepository
import com.yml.networklibpoc.domain.usecase.UniversityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideUniversityUseCase(repository: UniversityRepository): UniversityUseCase {
        return UniversityUseCase(repository)
    }
}