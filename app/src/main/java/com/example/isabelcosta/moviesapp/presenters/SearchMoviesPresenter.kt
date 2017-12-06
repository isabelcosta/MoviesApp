package com.example.isabelcosta.moviesapp.presenters

import com.example.isabelcosta.moviesapp.data.models.MovieSearchResultsListResponseData
import com.example.isabelcosta.moviesapp.data.source.ISearchDataSource
import com.example.isabelcosta.moviesapp.data.source.remote.SearchRemoteDataSource
import com.example.isabelcosta.moviesapp.ui.callbacks.ISearchMoviesUiCallback
import com.example.isabelcosta.moviesapp.utils.INITIAL_PAGE_NUMBER
import com.example.isabelcosta.moviesapp.utils.INVALID_INT

class SearchMoviesPresenter(private val uiCallback: ISearchMoviesUiCallback)
    : ISearchDataSource.GetMoviesSearchResults {

    private val remoteDataSource = SearchRemoteDataSource()

    private var totalPages: Int = INVALID_INT
    private var lastPageRequested: Int = INITIAL_PAGE_NUMBER
    private var searchText: String = ""

    fun searchMovies(searchText: String) {

        if (this.searchText != searchText) {
            resetSearchAttributes()
            this.searchText = searchText
        }

        uiCallback.showLoader()
        remoteDataSource.getMoviesSearchResults(this, searchText, lastPageRequested)
        updatePageNumber()
    }

    override fun onSuccessGetMoviesSearchResults(movieListResults: MovieSearchResultsListResponseData) {
        uiCallback.hideLoader()

        if (totalPages == INVALID_INT) {
            totalPages = movieListResults.totalPages
        }

        if (movieListResults.totalResults == 0) {
            uiCallback.onShowZeroResults(searchText)
        } else {
            val isFirstResult = movieListResults.page == INITIAL_PAGE_NUMBER
            val isLastResult = totalPages == movieListResults.page

            if (isLastResult) {
                resetPageNumber()
                uiCallback.onShowLastMoviesSearchResults(movieListResults.results, isFirstResult)
            } else {
                uiCallback.onShowMoviesSearchResultsWithMoreToCome(movieListResults.results, isFirstResult)
            }
        }
    }

    override fun onFailGetMoviesSearchResults() {
        uiCallback.hideLoader()
        uiCallback.onFetchFailMoviesSearchResults()
    }

    private fun updatePageNumber() = lastPageRequested++
    private fun resetPageNumber() {
        lastPageRequested = INITIAL_PAGE_NUMBER
    }
    private fun resetSearchAttributes() {
        resetPageNumber()
        totalPages = INVALID_INT
        lastPageRequested = INITIAL_PAGE_NUMBER
    }
}
