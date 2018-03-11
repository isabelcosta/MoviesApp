package com.example.isabelcosta.moviesapp.ui.callbacks

import com.example.isabelcosta.moviesapp.data.models.MovieDetailResponseData

interface IMovieDetailUiCallback: ILoadingUiCallback {

    fun onShowMovieDetail(movieDetail: MovieDetailResponseData)
    fun onFetchFailMovieDetail()
}