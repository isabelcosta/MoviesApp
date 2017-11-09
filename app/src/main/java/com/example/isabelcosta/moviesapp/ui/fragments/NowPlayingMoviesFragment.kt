package com.example.isabelcosta.moviesapp.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.adapters.NowPlayingMoviesAdapter
import com.example.isabelcosta.moviesapp.data.datamodels.NowPlayingListResponseData
import com.example.isabelcosta.moviesapp.presenters.NowPlayingMoviesPresenter
import com.example.isabelcosta.moviesapp.ui.activities.MainActivity
import com.example.isabelcosta.moviesapp.ui.callbacks.INowPlayingMoviesUiCallback
import kotlinx.android.synthetic.main.fragment_now_playing_movies.view.*

class NowPlayingMoviesFragment : BaseFragment<MainActivity>(), INowPlayingMoviesUiCallback {

    private var presenter: NowPlayingMoviesPresenter = NowPlayingMoviesPresenter(this)
    private lateinit var moviesResponseData: NowPlayingListResponseData

    companion object {
        fun newInstance(): NowPlayingMoviesFragment {
            return NowPlayingMoviesFragment()
        }
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_now_playing_movies
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = NowPlayingMoviesPresenter(this)
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
        val moviesAdapter = NowPlayingMoviesAdapter(screen, moviesList)

        rootView.nowPlayingMoviesRecyclerView.layoutManager = LinearLayoutManager(screen)
        rootView.nowPlayingMoviesRecyclerView.adapter = moviesAdapter
    }

    override fun onFetchFailMovies() {

        // Show fail fetch view

    }
}