package com.application.moviecatalogue.core.data.source.local

import com.application.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.application.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.application.moviecatalogue.core.data.source.local.room.CatalogueDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val catalogueDao: CatalogueDao) {

    fun getMovieList(): Flow<List<MovieEntity>> = catalogueDao.getMovieList()

    fun getTvShowList(): Flow<List<TvShowEntity>> = catalogueDao.getTvShowList()

    fun getFavoriteMovieList(): Flow<List<MovieEntity>> = catalogueDao.getFavoriteMovieList()

    fun getFavoriteTvShowList(): Flow<List<TvShowEntity>> = catalogueDao.getFavoriteTvShowList()

    suspend fun insertMovie(movieList: List<MovieEntity>) = catalogueDao.insertMovie(movieList)

    suspend fun insertTvShow(tvShowList: List<TvShowEntity>) = catalogueDao.insertTvShow(tvShowList)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFav = newState
        catalogueDao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFav = newState
        catalogueDao.updateTvShow(tvShow)
    }
}