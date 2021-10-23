package com.application.moviecatalogue.core.domain.repository

import com.application.moviecatalogue.core.data.Resource
import com.application.moviecatalogue.core.domain.model.Movie
import com.application.moviecatalogue.core.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface ICatalogueRepository {
    fun getMovies(): Flow<Resource<List<Movie>>>
    fun getTvShows(): Flow<Resource<List<TvShow>>>
    fun getFavMovie(): Flow<List<Movie>>
    fun getFavTvShow(): Flow<List<TvShow>>
    fun setFavMovie(movie: Movie, state: Boolean)
    fun setFavTvShow(tvShow: TvShow, state: Boolean)
}