package com.example.isabelcosta.moviesapp.data.source

import com.example.isabelcosta.moviesapp.data.models.MovieSearchResultsListResponseData

interface ISearchDataSource {

    interface GetMoviesSearchResults {
        fun onSuccessGetMoviesSearchResults(movieListResults: MovieSearchResultsListResponseData)
        fun onFailGetMoviesSearchResults()
    }

    interface GetTvShowsSearchResults {
        fun onSuccessGetTvShowsSearchResults()
        fun onFailGetTvShowsSearchResults()
    }

    fun getMoviesSearchResults(presenter: ISearchDataSource.GetMoviesSearchResults, searchText: String, pageNumber: Int = 1)
    fun getTvShowsSearchResults(presenter: ISearchDataSource.GetTvShowsSearchResults, searchText: String, pageNumber: Int = 1)
}