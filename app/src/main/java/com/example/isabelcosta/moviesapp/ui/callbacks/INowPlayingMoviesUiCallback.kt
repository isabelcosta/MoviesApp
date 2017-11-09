package com.example.isabelcosta.moviesapp.ui.callbacks

import com.example.isabelcosta.moviesapp.data.models.NowPlayingListResponseData

interface INowPlayingMoviesUiCallback {

    fun onShowMovies(movies: NowPlayingListResponseData)
    fun onFetchFailMovies()
}