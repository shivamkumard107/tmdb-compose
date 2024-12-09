package com.dev.sk.compose.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.dev.sk.compose.data.local.entity.MovieEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = MovieEntity::class)
    suspend fun insert(vararg entity: MovieEntity)

    @Query("SELECT * FROM trending_movies")
    suspend fun getTrendingMovies(id: String): List<MovieEntity>

    @Query("DELETE FROM trending_movies")
    suspend fun deleteAllMovies()

    @Transaction
    suspend fun deleteAndInsertBatch(vararg entities: MovieEntity) {
        deleteAllMovies()
        insert(*entities)
    }
}
