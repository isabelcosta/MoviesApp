package com.example.isabelcosta.moviesapp.ui.callbacks

import com.example.isabelcosta.moviesapp.data.models.MovieSearchResultsListResponseData

interface ISearchMoviesUiCallback: ILoadingUiCallback {
    fun onShowMoviesSearchResults(moviesResults: MovieSearchResultsListResponseData)
    fun onFetchFailMoviesSearchResults()
}
