package com.yml.networklib.api

import android.util.Log
import com.yml.networklib.model.APIResponse
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class UniversityDataSourceImpl : UniversityDataSource {
    override suspend fun getUniversities() = flow {
        RetrofitClientProvider.getUniversityApi()?.apply {
            val result =
                getUniversities()
            if (result.isEmpty()) {
                emit(APIResponse.Empty)
            } else {
                emit(APIResponse.Success(result))
            }
        }
    }.catch { exception ->
        Log.e("error", exception.stackTrace.toString())
        if (exception != null) {
            emit(APIResponse.Error(exception.localizedMessage))
        } else {
            emit(APIResponse.Error("Api failed"))
        }
    }

}