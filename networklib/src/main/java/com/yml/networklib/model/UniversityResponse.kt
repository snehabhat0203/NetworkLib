package com.yml.networklib.model

import kotlinx.serialization.Serializable

@Serializable
data class UniversityResponse(
    @Serializable
    val alphaCode: String? = null,
    @Serializable
    val country: String? = null,
    @Serializable
    val domains: List<String>,
    @Serializable
    val name: String = "",
    @Serializable
    val stateProvince: String? = null,
    @Serializable
    val webPages: List<String> = emptyList()
)