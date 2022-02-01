package com.yml.networklib.di

import android.util.Log
import com.yml.networklib.api.UniversityDataSource
import com.yml.networklib.api.UniversityDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

//
//    @Singleton
//    @Provides
//    fun provideRemoteService(okHttpClient: OkHttpClient): C2CAPIs {
//        return Retrofit.Builder().baseUrl(FRBConfig.MICROSERVICE_ENDPOINT + "/")
//            .client(okHttpClient)
//            .addConverterFactory(
//                GsonConverterFactory.create(
//                    GsonBuilder()
//                        .setLenient()
//                        .create()
//                )
//            ).build()
//            .create(C2CAPIs::class.java)
//    }
//
//    /**
//     * Providing ok http client
//     */
//    @Singleton
//    @Provides
//    fun provideOkHttpClient(
//    ): OkHttpClient {
//        val client = OkHttpClient.Builder().apply {
//            readTimeout(30, TimeUnit.SECONDS)
//            writeTimeout(30, TimeUnit.SECONDS)
//            connectTimeout(30, TimeUnit.SECONDS)
//        }
//        return client.build()
//    }

//    @Singleton
//    @Provides
//    fun provideHttpClient(): HttpClient {
//        return HttpClient(Android) {
//
//            install(JsonFeature) {
//                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
//                    prettyPrint = true
//                    isLenient = true
//                    ignoreUnknownKeys = true
//                })
//                engine {
//                    connectTimeout = 60_000
//                    socketTimeout = 60_000
//                }
//            }
//
//            install(Logging) {
//                logger = object : Logger {
//                    override fun log(message: String) {
//                        Log.v("Logger Ktor =>", message)
//                    }
//
//                }
//                level = LogLevel.ALL
//            }
//
//            install(ResponseObserver) {
//                onResponse { response ->
//                    Log.d("HTTP status:", "${response.status.value}")
//                }
//            }
//
//            install(DefaultRequest) {
//                header(HttpHeaders.ContentType, ContentType.Application.Json)
//            }
//        }
//    }

    @Provides
    @Singleton
    fun provideDataSource(): UniversityDataSource {
        return UniversityDataSourceImpl()
    }
}