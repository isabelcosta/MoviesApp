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

    fun getMoviesSearchResults(presenter: ISearchDataSource.GetMoviesSearchResults, searchText: String)
    fun getTvShowsSearchResults(presenter: ISearchDataSource.GetTvShowsSearchResults, searchText: String)
}