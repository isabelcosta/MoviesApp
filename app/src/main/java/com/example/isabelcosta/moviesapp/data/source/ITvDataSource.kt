package com.example.isabelcosta.moviesapp.data.source

import com.example.isabelcosta.moviesapp.data.models.MostPopularShowsListResponseData

interface ITvDataSource {

    interface GetMostPopularShows {
        fun onSuccessGetMostPopularShows(tvShows: MostPopularShowsListResponseData)
        fun onFailGetMostPopularShows()
    }

    interface GetTvShowDetail {
        fun onSuccessGetTvShowDetail()
        fun onFailGetTvShowDetail()
    }

    fun getMostPopularShows(presenter: ITvDataSource.GetMostPopularShows)
    fun getTvShowDetail(presenter: ITvDataSource.GetTvShowDetail, tvShowId: Int)
}