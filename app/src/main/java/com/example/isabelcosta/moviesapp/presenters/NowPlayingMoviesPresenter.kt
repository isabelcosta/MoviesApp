package com.example.isabelcosta.moviesapp.presenters

import com.example.isabelcosta.moviesapp.data.datamodels.NowPlayingListResponseData
import com.example.isabelcosta.moviesapp.data.remote.MoviesRemoteDataSource
import com.example.isabelcosta.moviesapp.data.source.IMoviesDataSource
import com.example.isabelcosta.moviesapp.ui.callbacks.INowPlayingMoviesUiCallback

class NowPlayingMoviesPresenter(private val uiCallback: INowPlayingMoviesUiCallback) : IMoviesDataSource.GetNowPlayingMovies {

    private val remoteDataSource = MoviesRemoteDataSource()

    // presenter API functions and callbacks

    fun getNowPlayingMovies() {
        remoteDataSource.getNowPlayingMovies(this)
    }

    override fun onSuccessGetNowPlayingMovies(movies: NowPlayingListResponseData) {
        uiCallback.onShowMovies(movies)
    }

    override fun onFailGetNowPlayingMovies() {
        uiCallback.onFetchFailMovies()
    }
}