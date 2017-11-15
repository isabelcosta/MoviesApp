package com.example.isabelcosta.moviesapp.presenters

import com.example.isabelcosta.moviesapp.data.models.NowPlayingListResponseData
import com.example.isabelcosta.moviesapp.data.remote.MoviesRemoteDataSource
import com.example.isabelcosta.moviesapp.data.source.IMoviesDataSource
import com.example.isabelcosta.moviesapp.ui.callbacks.IMostPopularShowsUiCallback

class MostPopularShowsPresenter(private val uiCallback: IMostPopularShowsUiCallback)
    : IMoviesDataSource.GetNowPlayingMovies {

    private val remoteDataSource = MoviesRemoteDataSource()

    fun getNowPlayingMovies() {
        remoteDataSource.getNowPlayingMovies(this)
    }

    override fun onSuccessGetNowPlayingMovies(movies: NowPlayingListResponseData) {
        uiCallback.onShowMostPopularShows()
    }

    override fun onFailGetNowPlayingMovies() {
        uiCallback.onFetchFailMostPopularShows()
    }
}