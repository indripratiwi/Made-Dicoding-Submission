package com.application.moviecatalogue.core.utlis

import com.application.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.application.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.application.moviecatalogue.core.data.source.remote.response.MovieDetailResponse
import com.application.moviecatalogue.core.data.source.remote.response.TvShowDetailResponse
import com.application.moviecatalogue.core.domain.model.Movie
import com.application.moviecatalogue.core.domain.model.TvShow

object DataMapper {
    fun mapResponseToEntitiesMovie(input: List<MovieDetailResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movies = MovieEntity(
                id = it.id,
                title = it.title,
                release = it.release,
                score = it.score,
                overview = it.overview,
                poster = it.poster,
                backdrop = it.backdrop,
                isFav = false
            )
            movieList.add(movies)
        }
        return movieList
    }

    fun mapEntitiesToDomainMovie(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                title = it.title,
                release = it.release,
                score = it.score,
                overview = it.overview,
                poster = it.poster,
                backdrop = it.backdrop,
                isFav = it.isFav
            )
        }

    fun mapDomainToEntityMovie(input: Movie) = MovieEntity(
        id = input.id,
        title = input.title,
        release = input.release,
        score = input.score,
        overview = input.overview,
        poster = input.poster,
        backdrop = input.backdrop,
        isFav = input.isFav
    )

    fun mapResponseToEntitiesTvShow(input: List<TvShowDetailResponse>): List<TvShowEntity> {
        val movieList = ArrayList<TvShowEntity>()
        input.map {
            val movies = TvShowEntity(
                id = it.id,
                title = it.title,
                release = it.release,
                score = it.score,
                overview = it.overview,
                poster = it.poster,
                backdrop = it.backdrop,
                isFav = false
            )
            movieList.add(movies)
        }
        return movieList
    }

    fun mapEntitiesToDomainTvShow(input: List<TvShowEntity>): List<TvShow> =
        input.map {
            TvShow(
                id = it.id,
                title = it.title,
                release = it.release,
                score = it.score,
                overview = it.overview,
                poster = it.poster,
                backdrop = it.backdrop,
                isFav = it.isFav
            )
        }

    fun mapDomainToEntityTvShow(input: TvShow) = TvShowEntity(
        id = input.id,
        title = input.title,
        release = input.release,
        score = input.score,
        overview = input.overview,
        poster = input.poster,
        backdrop = input.backdrop,
        isFav = input.isFav
    )
}