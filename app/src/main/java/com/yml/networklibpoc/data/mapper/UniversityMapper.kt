package com.yml.networklibpoc.data.mapper

import com.yml.networklib.model.UniversityResponse
import com.yml.networklibpoc.domain.model.University

fun UniversityResponse.getUiModel(): University {
    return University(name = name, webLink = if (webPages.isNullOrEmpty()) "" else webPages!![0])
}