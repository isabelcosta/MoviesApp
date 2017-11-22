package com.example.isabelcosta.moviesapp.ui.fragments

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.adapters.MostPopularShowsAdapter
import com.example.isabelcosta.moviesapp.data.models.MostPopularShowsListResponseData
import com.example.isabelcosta.moviesapp.presenters.MostPopularShowsPresenter
import com.example.isabelcosta.moviesapp.ui.activities.MainActivity
import com.example.isabelcosta.moviesapp.ui.callbacks.IMostPopularShowsUiCallback
import com.example.isabelcosta.moviesapp.utils.GridListSpacesItemDecoration
import kotlinx.android.synthetic.main.fragment_most_popular_shows.view.*

class MostPopularShowsFragment : ExecuteRequestFragment<MainActivity>(), IMostPopularShowsUiCallback {

    private lateinit var showsResponseData: MostPopularShowsListResponseData
    private var presenter = MostPopularShowsPresenter(this)

    override fun getLayoutResourceId(): Int = R.layout.fragment_most_popular_shows
    override fun getTitleResourceId(): Int = R.string.screen_title_popular_tv_shows

    companion object {
        fun newInstance(): MostPopularShowsFragment {
            return MostPopularShowsFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Fetch most popular shows list
        presenter.getMostPopularShows()
    }

    /*
        Callback Methods
     */
    override fun onShowMostPopularShows(tvShows: MostPopularShowsListResponseData) {

        showsResponseData = tvShows
        val showsList = tvShows.results
        val showsAdapter = MostPopularShowsAdapter(screen, showsList)

        val numColumns = 2
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.generic_14dp)
        val itemDecoration = GridListSpacesItemDecoration(spacingInPixels, numColumns)

        rootView.mostPopularShowsRecyclerView.apply {
            addItemDecoration(itemDecoration)
            layoutManager = GridLayoutManager(screen, numColumns)
            adapter = showsAdapter
        }
    }

    override fun onFetchFailMostPopularShows() {

    }
}
