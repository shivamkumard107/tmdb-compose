package com.dev.sk.compose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dev.sk.compose.data.local.dao.MovieDao
import com.dev.sk.compose.data.local.dao.MovieDetailsDao
import com.dev.sk.compose.data.local.entity.MovieDetailsEntity
import com.dev.sk.compose.data.local.entity.MovieEntity

@Database(
    entities = [MovieEntity::class, MovieDetailsEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(Converters::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    abstract fun movieDetailsDao(): MovieDetailsDao
}