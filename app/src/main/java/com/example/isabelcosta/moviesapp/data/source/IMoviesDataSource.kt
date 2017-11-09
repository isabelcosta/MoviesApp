package com.example.isabelcosta.moviesapp.data.source

import com.example.isabelcosta.moviesapp.data.datamodels.NowPlayingListResponseData

interface IMoviesDataSource {

    interface GetNowPlayingMovies {
        fun onSuccessGetNowPlayingMovies(movies : NowPlayingListResponseData)
        fun onFailGetNowPlayingMovies()
    }

    fun getNowPlayingMovies(iPresenter: GetNowPlayingMovies)

}