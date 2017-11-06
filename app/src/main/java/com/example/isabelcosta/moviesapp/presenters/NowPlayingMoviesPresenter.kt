package com.example.isabelcosta.moviesapp.presenters

import com.example.isabelcosta.moviesapp.data.entities.NowPlayingListResponseData
import com.example.isabelcosta.moviesapp.data.source.IMoviesDataSource
import com.example.isabelcosta.moviesapp.ui.callbacks.INowPlayingMoviesUiCallback

class NowPlayingMoviesPresenter(uiCallback: INowPlayingMoviesUiCallback) : INowPlayingMoviesPresenter, IMoviesDataSource.GetNowPlayingMovies {

    val uiCallback : INowPlayingMoviesUiCallback = uiCallback

    override fun getNowPlayingMovies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccessGetNowPlayingMovies(movies: NowPlayingListResponseData?) {
        uiCallback.onShowMovies(movies)
    }

    override fun onFailGetNowPlayingMovies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}