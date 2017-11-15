package com.example.isabelcosta.moviesapp.ui.fragments

import android.os.Bundle
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.data.models.NowPlayingListResponseData
import com.example.isabelcosta.moviesapp.presenters.MostPopularShowsPresenter
import com.example.isabelcosta.moviesapp.ui.activities.MainActivity
import com.example.isabelcosta.moviesapp.ui.callbacks.IMostPopularShowsUiCallback

class MostPopularShowsFragment : BaseFragment<MainActivity>(), IMostPopularShowsUiCallback {

    private var presenter: MostPopularShowsPresenter = MostPopularShowsPresenter(this)
    private lateinit var moviesResponseData: NowPlayingListResponseData

    companion object {
        fun newInstance(): MostPopularShowsFragment {
            return MostPopularShowsFragment()
        }
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_most_popular_shows
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Fetch now playing movies list
        presenter.getNowPlayingMovies()
    }

    /*
        Callback Methods
     */
    override fun onShowMostPopularShows() {

    }

    override fun onFetchFailMostPopularShows() {

    }
}
