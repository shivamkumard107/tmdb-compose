package com.dev.sk.compose.utils

sealed class DataState<out T> {
    class Success<T>(val data: T) : DataState<T>()
    class Error<T>(val data: T? = null, val throwable: Throwable) : DataState<T>()
    data object Loading: DataState<Nothing>()
}