package com.dev.sk.compose.utils

typealias ApiCall<T> = suspend () -> T

suspend fun <T> catchAsync(apiCall: ApiCall<T>): Result<T> {
    try {
        val response = Result.success(apiCall())
        return response
    } catch (e: Exception) {
        return Result.failure(e)
    }
}