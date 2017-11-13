package com.example.isabelcosta.moviesapp.ui.activities

import android.os.Bundle
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.data.models.MovieDetailResponseData
import com.example.isabelcosta.moviesapp.presenters.MovieDetailPresenter
import com.example.isabelcosta.moviesapp.ui.callbacks.IMovieDetailUiCallback
import com.example.isabelcosta.moviesapp.utils.MOVIE_DETAIL_ID_BUNDLE_ARG
import com.example.isabelcosta.moviesapp.utils.getFullImageUrl
import com.example.isabelcosta.moviesapp.utils.showToastAlert
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.screen_movie_detail.*

class MovieDetailScreen : BaseActivity(), IMovieDetailUiCallback {

    private lateinit var movieDetail: MovieDetailResponseData
    private val presenter = MovieDetailPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieDetailId: Int = intent.extras.get(MOVIE_DETAIL_ID_BUNDLE_ARG) as Int

        supportActionBar?.title = getString(R.string.movie_detail)

        presenter.getMovieDetail(movieDetailId)
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.screen_movie_detail
    }

    override fun onShowMovieDetail(movieDetail: MovieDetailResponseData) {
        this.movieDetail = movieDetail
        movieDetailDescriptionTextView.text = movieDetail.overview
        movieDetailTitleTextView.text = movieDetail.title
        movieDetailRatingTextView.text = getString(R.string.rating_value, movieDetail.voteAverage.toString())
        Picasso.with(this).load(getFullImageUrl(movieDetail.posterPath)).into(movieDetailPosterImageView)
    }

    override fun onFetchFailMovieDetail() {
        showToastAlert(this, getString(R.string.movie_detail_fetch_fail))
    }
}
