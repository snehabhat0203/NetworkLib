package com.yml.networklibpoc.domain.repository

import com.yml.networklibpoc.domain.model.University


interface UniversityRepository {
    suspend fun getUniversities(): List<University>
}