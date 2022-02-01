package com.yml.networklib.api

import com.yml.networklib.model.APIResponse
import com.yml.networklib.model.UniversityResponse
import kotlinx.coroutines.flow.Flow

interface UniversityDataSource {
    suspend fun getUniversities(): Flow<APIResponse<List<UniversityResponse>>>
}