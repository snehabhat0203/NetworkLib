package com.yml.networklib.model

/**
 * sealed class to handle API Response for C2C flow
 */
sealed class APIResponse<out T : Any> {
    data class Success<out T : Any>(val data: T) : APIResponse<T>()
    data class Error(val errorMessage: String) : APIResponse<Nothing>()
    object Empty : APIResponse<Nothing>()
}