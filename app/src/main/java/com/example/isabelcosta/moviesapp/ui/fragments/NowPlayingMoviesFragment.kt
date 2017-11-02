package com.example.isabelcosta.moviesapp.ui.fragments

import android.os.Bundle
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.presenters.INowPlayingMoviesPresenter
import com.example.isabelcosta.moviesapp.presenters.NowPlayingMoviesPresenter
import com.example.isabelcosta.moviesapp.ui.callbacks.INowPlayingMoviesUiCallback

class NowPlayingMoviesFragment : BaseFragment(), INowPlayingMoviesUiCallback {

    lateinit var presenter : INowPlayingMoviesPresenter

    companion object{
        fun newInstance() : NowPlayingMoviesFragment {
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

        presenter.getNowPlayingMovies()
    }


    /*
        Callback Methods
     */
    override fun onShowMovies() {

//        nowPlayingMoviesRecyclerView...
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFetchFailMovies() {
        TODO("not implemented")

        // Show fail fetch view

    }
}