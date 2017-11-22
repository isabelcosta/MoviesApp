package com.example.isabelcosta.moviesapp.presenters

import com.example.isabelcosta.moviesapp.data.models.MovieSearchResultsListResponseData
import com.example.isabelcosta.moviesapp.data.source.ISearchDataSource
import com.example.isabelcosta.moviesapp.data.source.remote.SearchRemoteDataSource
import com.example.isabelcosta.moviesapp.ui.callbacks.ISearchMoviesUiCallback

class SearchMoviesPresenter(private val uiCallback: ISearchMoviesUiCallback)
    : ISearchDataSource.GetMoviesSearchResults {

    private val remoteDataSource = SearchRemoteDataSource()

    fun searchMovies(searchText: String) {
        uiCallback.showLoader()
        remoteDataSource.getMoviesSearchResults(this, searchText)
    }

    override fun onSuccessGetMoviesSearchResults(movieListResults: MovieSearchResultsListResponseData) {
        uiCallback.hideLoader()
        uiCallback.onShowMoviesSearchResults(movieListResults)
    }

    override fun onFailGetMoviesSearchResults() {
        uiCallback.hideLoader()
        uiCallback.onFetchFailMoviesSearchResults()
    }
}