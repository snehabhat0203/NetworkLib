package com.yml.networklib.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClientProvider {
    private var universityApi: UniversityApi? = null
    fun getUniversityApi(): UniversityApi? {
        if (universityApi == null) {
            createBuilder()
        }
        return universityApi
    }

    private fun createBuilder() {
        val httpBuilder = OkHttpClient.Builder()
        httpBuilder.connectTimeout(30, TimeUnit.SECONDS)
        httpBuilder.readTimeout(30, TimeUnit.SECONDS)
        httpBuilder.writeTimeout(30, TimeUnit.SECONDS)
        httpBuilder.addInterceptor(HttpLoggingInterceptor())
        universityApi = Retrofit.Builder()
            .client(httpBuilder.build())
            .baseUrl("http://universities.hipolabs.com/")
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()
                )
            ).build()
            .create(UniversityApi::class.java)
    }
}