package com.yml.networklib.api

import com.yml.networklib.model.UniversityResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface UniversityApi {
    @GET("search?country=United+States")
    suspend fun getUniversities(): List<UniversityResponse>
}