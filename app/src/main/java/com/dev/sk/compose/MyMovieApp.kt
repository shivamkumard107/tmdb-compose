package com.dev.sk.compose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyMovieApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}