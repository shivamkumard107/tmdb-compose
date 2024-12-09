package com.dev.sk.compose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dev.sk.compose.data.local.dao.MovieDao
import com.dev.sk.compose.data.local.dao.MovieDetailsDao
import com.dev.sk.compose.data.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    abstract fun movieDetailsDao(): MovieDetailsDao
}