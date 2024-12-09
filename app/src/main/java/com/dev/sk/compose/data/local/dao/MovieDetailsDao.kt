package com.dev.sk.compose.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dev.sk.compose.data.local.entity.MovieDetailsEntity

@Dao
interface MovieDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: MovieDetailsEntity)

    @Query("SELECT * FROM movie_details WHERE id=:id limit 1")
    suspend fun getMovieDetails(id: Int): MovieDetailsEntity
}