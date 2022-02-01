package com.yml.networklibpoc.data.repository

import com.yml.networklib.api.UniversityDataSource
import com.yml.networklib.model.APIResponse
import com.yml.networklibpoc.data.mapper.getUiModel
import com.yml.networklibpoc.domain.model.University
import com.yml.networklibpoc.domain.repository.UniversityRepository
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class UniversityRepositoryImpl @Inject constructor(private val universityDataSource: UniversityDataSource) :
    UniversityRepository {
    override suspend fun getUniversities(): List<University> {
        val list = mutableListOf<University>()
        universityDataSource.getUniversities().collect { response ->

            when (response) {
                is APIResponse.Success -> {
                    response.data.forEach {
                        list.add(it.getUiModel())
                    }
                }
                is APIResponse.Error -> {
                    //Nothing
                }
                else -> {
                    //Nothing
                }
            }

        }
        return list

    }
}