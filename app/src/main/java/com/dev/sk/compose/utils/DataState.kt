package com.dev.sk.compose.utils

sealed class DataState<out T> {
    class Success<T>(data: T) : DataState<T>()
    class Error<T>(data: T? = null, throwable: Throwable) : DataState<T>()
    data object Loading: DataState<Nothing>()
}