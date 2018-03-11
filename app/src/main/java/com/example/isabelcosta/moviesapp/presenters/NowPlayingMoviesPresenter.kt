package com.example.isabelcosta.moviesapp.presenters

import com.example.isabelcosta.moviesapp.data.models.NowPlayingListResponseData
import com.example.isabelcosta.moviesapp.data.remote.MoviesRemoteDataSource
import com.example.isabelcosta.moviesapp.data.source.IMoviesDataSource
import com.example.isabelcosta.moviesapp.ui.callbacks.INowPlayingMoviesUiCallback

class NowPlayingMoviesPresenter(private val uiCallback: INowPlayingMoviesUiCallback)
    : IMoviesDataSource.GetNowPlayingMovies {

    private val remoteDataSource = MoviesRemoteDataSource()

    fun getNowPlayingMovies() {
        uiCallback.showLoader()
        remoteDataSource.getNowPlayingMovies(this)
    }

    override fun onSuccessGetNowPlayingMovies(movies: NowPlayingListResponseData) {
        uiCallback.hideLoader()
        uiCallback.onShowMovies(movies)
    }

    override fun onFailGetNowPlayingMovies() {
        uiCallback.hideLoader()
        uiCallback.onFetchFailMovies()
    }
}
