package com.yml.networklib.model

data class UniversityResponse(
    val alphaCode: String? = null,
    val country: String? = null,
    val domains: List<String>,
    val name: String = "",
    val stateProvince: String? = null,
    val webPages: List<String>? = emptyList()
)