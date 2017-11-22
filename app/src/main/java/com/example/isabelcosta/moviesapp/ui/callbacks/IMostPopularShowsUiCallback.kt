package com.example.isabelcosta.moviesapp.ui.callbacks

import com.example.isabelcosta.moviesapp.data.models.MostPopularShowsListResponseData

interface IMostPopularShowsUiCallback: ILoadingUiCallback {

    fun onShowMostPopularShows(tvShows: MostPopularShowsListResponseData)
    fun onFetchFailMostPopularShows()
}