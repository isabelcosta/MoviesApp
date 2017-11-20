package com.example.isabelcosta.moviesapp.presenters

import com.example.isabelcosta.moviesapp.data.models.MostPopularShowsListResponseData
import com.example.isabelcosta.moviesapp.data.source.ITvDataSource
import com.example.isabelcosta.moviesapp.data.source.remote.TvRemoteDataSource
import com.example.isabelcosta.moviesapp.ui.callbacks.IMostPopularShowsUiCallback

class MostPopularShowsPresenter(private val uiCallback: IMostPopularShowsUiCallback)
    : ITvDataSource.GetMostPopularShows {

    private val remoteDataSource = TvRemoteDataSource()

    fun getMostPopularShows() = remoteDataSource.getMostPopularShows(this)

    override fun onSuccessGetMostPopularShows(tvShows: MostPopularShowsListResponseData) = uiCallback.onShowMostPopularShows(tvShows)

    override fun onFailGetMostPopularShows() = uiCallback.onFetchFailMostPopularShows()
}