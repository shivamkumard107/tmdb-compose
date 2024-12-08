package com.dev.sk.compose.data.local

import android.content.Context
import androidx.room.Room


object MovieDatabaseBuilder {
    @Volatile
    private var INSTANCE: MovieDatabase? = null

    fun getInstance(context: Context): MovieDatabase {
        return INSTANCE ?: synchronized(this) {
            if (INSTANCE == null) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "movie_db"
                ).build()
                INSTANCE = instance
            }
            INSTANCE!!
        }
    }
}