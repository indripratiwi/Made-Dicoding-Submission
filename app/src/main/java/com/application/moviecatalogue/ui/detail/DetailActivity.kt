package com.application.moviecatalogue.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.application.moviecatalogue.BuildConfig.IMAGE_URL
import com.application.moviecatalogue.R
import com.application.moviecatalogue.core.domain.model.Movie
import com.application.moviecatalogue.core.domain.model.TvShow
import com.application.moviecatalogue.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private val detailViewModel: DetailViewModel by viewModels()

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        if (detailMovie != null) {
            populateMovieDetailData(detailMovie)
        }

        val detailTvShow = intent.getParcelableExtra<TvShow>(EXTRA_TV_SHOW)
        if (detailTvShow != null) {
            populateTvShowDetailData(detailTvShow)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateMovieDetailData(movie: Movie) {
        binding.tvTitle.text = movie.title
        binding.tvReleaseDate.text = movie.release
        binding.tvScore.text = movie.score.toString()
        binding.tvOverview.text = movie.overview

        Glide.with(this)
            .load(IMAGE_URL + movie.backdrop)
            .centerCrop()
            .apply(RequestOptions().override(510, 300))
            .into(binding.imgBackdrop)

        Glide.with(this)
            .load(IMAGE_URL + movie.poster)
            .centerCrop()
            .apply(RequestOptions().override(330, 500))
            .into(binding.imgPoster)

        var state = movie.isFav
        setFavorite(state)
        binding.fab.setOnClickListener {
            state = !state
            detailViewModel.setFavoriteMovie(movie, state)
            setFavorite(state)

            if (state) {
                Toast.makeText(this@DetailActivity, "Added to Favorite", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@DetailActivity, "Removed from Favorite", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateTvShowDetailData(tvShow: TvShow) {
        binding.tvTitle.text = tvShow.title
        binding.tvReleaseDate.text = tvShow.release
        binding.tvScore.text = tvShow.score.toString()
        binding.tvOverview.text = tvShow.overview

        Glide.with(this)
                .load(IMAGE_URL + tvShow.backdrop)
                .centerCrop()
                .apply(RequestOptions().override(510, 300))
                .into(binding.imgBackdrop)

        Glide.with(this)
                .load(IMAGE_URL + tvShow.poster)
                .centerCrop()
                .apply(RequestOptions().override(330, 500))
                .into(binding.imgPoster)

        var state = tvShow.isFav
        setFavorite(state)
        binding.fab.setOnClickListener {
            state = !state
            detailViewModel.setFavoriteTvShow(tvShow, state)
            setFavorite(state)

            if (state) {
                Toast.makeText(this@DetailActivity, "Added to Favorite", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@DetailActivity, "Removed from Favorite", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setFavorite(isFavorite: Boolean) {
        if (isFavorite) {
            binding.fab.setImageResource(R.drawable.ic_baseline_bookmark_24)
        } else {
            binding.fab.setImageResource(R.drawable.ic_baseline_bookmark_border_24)
        }
    }
}