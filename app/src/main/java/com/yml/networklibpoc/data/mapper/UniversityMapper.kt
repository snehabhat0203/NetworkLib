package com.yml.networklibpoc.data.mapper

import com.yml.networklib.model.UniversityResponse
import com.yml.networklibpoc.domain.model.University

fun com.yml.networklib.model.UniversityResponse.getUiModel(): University {
    return University(name = name, webLink = if (webPages.isNotEmpty()) webPages[0] else "")
}