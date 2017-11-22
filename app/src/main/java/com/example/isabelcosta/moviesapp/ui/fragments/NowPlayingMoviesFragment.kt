package com.example.isabelcosta.moviesapp.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.adapters.NowPlayingMoviesAdapter
import com.example.isabelcosta.moviesapp.data.models.NowPlayingListResponseData
import com.example.isabelcosta.moviesapp.presenters.NowPlayingMoviesPresenter
import com.example.isabelcosta.moviesapp.ui.activities.MainActivity
import com.example.isabelcosta.moviesapp.ui.callbacks.INowPlayingMoviesUiCallback
import com.example.isabelcosta.moviesapp.utils.LinearListSpacesItemDecoration
import kotlinx.android.synthetic.main.fragment_now_playing_movies.view.*

class NowPlayingMoviesFragment : BaseFragment<MainActivity>(), INowPlayingMoviesUiCallback {

    private lateinit var moviesResponseData: NowPlayingListResponseData
    private var presenter = NowPlayingMoviesPresenter(this)
    private val openDetail: (Int) -> Unit =
            { movieDetailId ->
                screen.navigateToFragmentToolbarSet(false)
                screen.replaceFragment(MovieDetailFragment.newInstance(movieDetailId))
            }

    override fun getLayoutResourceId(): Int = R.layout.fragment_now_playing_movies
    override fun getTitleResourceId(): Int = R.string.screen_title_now_playing_movies

    companion object {
        fun newInstance(): NowPlayingMoviesFragment {
            return NowPlayingMoviesFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Fetch now playing movies list
        presenter.getNowPlayingMovies()
    }

    /*
        Callback Methods
     */
    override fun onShowMovies(movies: NowPlayingListResponseData) {

        moviesResponseData = movies
        val moviesList = movies.results
        val moviesAdapter = NowPlayingMoviesAdapter(screen, moviesList, openDetail)

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.generic_14dp)
        val itemDecoration = LinearListSpacesItemDecoration(spacingInPixels)

        rootView.nowPlayingMoviesRecyclerView.apply {
            addItemDecoration(itemDecoration)
            layoutManager = LinearLayoutManager(screen)
            adapter = moviesAdapter
        }
    }

    override fun onFetchFailMovies() {

        // Show fail fetch view

    }


}
