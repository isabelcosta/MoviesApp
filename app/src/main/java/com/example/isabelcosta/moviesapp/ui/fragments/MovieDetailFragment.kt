package com.example.isabelcosta.moviesapp.ui.fragments

import android.os.Bundle
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.data.models.MovieDetailResponseData
import com.example.isabelcosta.moviesapp.presenters.MovieDetailPresenter
import com.example.isabelcosta.moviesapp.ui.activities.MainActivity
import com.example.isabelcosta.moviesapp.ui.callbacks.IMovieDetailUiCallback
import com.example.isabelcosta.moviesapp.utils.MOVIE_DETAIL_ID_BUNDLE_ARG
import com.example.isabelcosta.moviesapp.utils.getFullImageUrl
import com.example.isabelcosta.moviesapp.utils.showToastAlert
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_detail.*

/**
 * Created by IsabelCosta on 14-11-2017.
 */
class MovieDetailFragment : BaseFragment<MainActivity>(), IMovieDetailUiCallback {

    private lateinit var movieDetail: MovieDetailResponseData
    private val presenter = MovieDetailPresenter(this)

    companion object {
        fun newInstance(movieDetailId: Int ): MovieDetailFragment {
            val args = Bundle().apply {
                putInt(MOVIE_DETAIL_ID_BUNDLE_ARG, movieDetailId)
            }
            return MovieDetailFragment().apply { arguments = args }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieDetailId: Int = arguments.get(MOVIE_DETAIL_ID_BUNDLE_ARG) as Int

        presenter.getMovieDetail(movieDetailId)
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_movie_detail
    }

    override fun onShowMovieDetail(movieDetail: MovieDetailResponseData) {
        this.movieDetail = movieDetail
        movieDetailDescriptionTextView.text = movieDetail.overview
        movieDetailTitleTextView.text = movieDetail.title
        movieDetailRatingTextView.text = getString(R.string.rating_value, movieDetail.voteAverage.toString())
        Picasso.with(screen).load(getFullImageUrl(movieDetail.posterPath)).into(movieDetailPosterImageView)
    }

    override fun onFetchFailMovieDetail() {
        showToastAlert(screen, getString(R.string.movie_detail_fetch_fail))
    }
}