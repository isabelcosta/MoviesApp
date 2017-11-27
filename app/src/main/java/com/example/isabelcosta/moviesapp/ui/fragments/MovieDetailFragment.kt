package com.example.isabelcosta.moviesapp.ui.fragments

import android.os.Bundle
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.data.models.MovieDetailResponseData
import com.example.isabelcosta.moviesapp.presenters.MovieDetailPresenter
import com.example.isabelcosta.moviesapp.ui.activities.MainActivity
import com.example.isabelcosta.moviesapp.ui.callbacks.IMovieDetailUiCallback
import com.example.isabelcosta.moviesapp.utils.MOVIE_DETAIL_ID_BUNDLE_ARG
import com.example.isabelcosta.moviesapp.utils.setImageUsingPicasso
import com.example.isabelcosta.moviesapp.utils.showToastAlert
import kotlinx.android.synthetic.main.fragment_movie_detail.*

/**
 * Created by IsabelCosta on 14-11-2017.
 */
class MovieDetailFragment : ExecuteRequestFragment<MainActivity>(), IMovieDetailUiCallback {

    private lateinit var movieDetail: MovieDetailResponseData
    private val presenter = MovieDetailPresenter(this)
    private val movieDetailId: Int by lazy {
        arguments.getInt(MOVIE_DETAIL_ID_BUNDLE_ARG)
    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_movie_detail
    override fun getTitleResourceId(): Int = R.string.screen_title_movie_detail

    companion object {
        fun newInstance(movieDetailId: Int ): MovieDetailFragment {
            val args = Bundle().apply {
                putInt(MOVIE_DETAIL_ID_BUNDLE_ARG, movieDetailId)
            }
            return MovieDetailFragment().apply { arguments = args }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        screen.setToolbarTitle(getTitleResourceId())
        presenter.getMovieDetail(movieDetailId)
    }

    override fun onShowMovieDetail(movieDetail: MovieDetailResponseData) {
        this.movieDetail = movieDetail
        movieDetailDescriptionTextView.text = movieDetail.overview
        movieDetailTitleTextView.text = movieDetail.title
        movieDetailRatingTextView.text = getString(R.string.rating_value, movieDetail.voteAverage.toString())
        setImageUsingPicasso(screen, movieDetail.posterPath, movieDetailPosterImageView)
    }

    override fun onFetchFailMovieDetail() {
        showToastAlert(screen, getString(R.string.movie_detail_fetch_fail))
    }
}