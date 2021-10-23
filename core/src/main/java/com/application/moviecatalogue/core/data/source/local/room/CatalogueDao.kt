package com.application.moviecatalogue.core.data.source.local.room

import androidx.room.*
import com.application.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.application.moviecatalogue.core.data.source.local.entity.TvShowEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CatalogueDao {
    @Query("SELECT * FROM movie_entity")
    fun getMovieList(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM tv_show_entity")
    fun getTvShowList(): Flow<List<TvShowEntity>>

    @Query("SELECT * FROM movie_entity WHERE isFav = 1")
    fun getFavoriteMovieList(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM tv_show_entity WHERE isFav = 1")
    fun getFavoriteTvShowList(): Flow<List<TvShowEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = MovieEntity::class)
    suspend fun insertMovie(data: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = TvShowEntity::class)
    suspend fun insertTvShow(data: List<TvShowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)
}