package com.dev.sk.compose.interceptor

import com.dev.sk.compose.di.ApiKey
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthHeaderInterceptor @Inject constructor(@ApiKey private val key: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val ogRequest = chain.request()
        val newRequest = ogRequest.newBuilder()
            .header(AUTH, "Bearer $key")
            .build()
        return chain.proceed(newRequest)
    }

    companion object {
        private const val AUTH = "Authorization"
    }
}