package com.example.isabelcosta.moviesapp.ui.callbacks

import com.example.isabelcosta.moviesapp.data.models.MovieSearchResultsItemResponseData

interface ISearchMoviesUiCallback: ILoadingUiCallback {
    fun onShowMoviesSearchResultsWithMoreToCome(movieResults: List<MovieSearchResultsItemResponseData>, isFirstQueryResult: Boolean)
    fun onShowLastMoviesSearchResults(movieResults: List<MovieSearchResultsItemResponseData>, isFirstQueryResult: Boolean)
    fun onShowZeroResults(searchText: String)
    fun onFetchFailMoviesSearchResults()
}
