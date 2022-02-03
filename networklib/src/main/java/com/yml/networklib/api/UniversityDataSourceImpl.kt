package com.yml.networklib.api

import com.yml.networklib.model.APIResponse
import com.yml.networklib.model.UniversityResponse
import io.ktor.client.request.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class UniversityDataSourceImpl : UniversityDataSource {
    override suspend fun getUniversities() = flow {
        KtorHttpClientProvider.getKtorHttpClient()?.apply {
            val result =
                get<List<UniversityResponse>>("http://universities.hipolabs.com/search?country=United+States")
            if (result.isEmpty()) {
                emit(APIResponse.Empty)
            } else {
                emit(APIResponse.Success(result))
            }
        }
    }.catch { exception ->
        emit(APIResponse.Error(exception.localizedMessage))
    }

}