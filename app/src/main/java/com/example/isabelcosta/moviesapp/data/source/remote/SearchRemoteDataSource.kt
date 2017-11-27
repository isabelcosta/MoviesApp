package com.example.isabelcosta.moviesapp.data.source.remote

import com.example.isabelcosta.moviesapp.data.models.MovieSearchResultsListResponseData
import com.example.isabelcosta.moviesapp.data.remote.RemoteDataSource
import com.example.isabelcosta.moviesapp.data.source.ISearchDataSource
import com.example.isabelcosta.moviesapp.data.source.remote.service.SearchApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRemoteDataSource : RemoteDataSource(), ISearchDataSource {

    private val service: SearchApiService = retrofit.create(SearchApiService::class.java)

    override fun getMoviesSearchResults(presenter: ISearchDataSource.GetMoviesSearchResults, searchText: String, pageNumber: Int) {
        val call = service.getMoviesSearchResults(apiKey, searchText, pageNumber)

        call.enqueue(object : Callback<MovieSearchResultsListResponseData> {
            override fun onResponse(call: Call<MovieSearchResultsListResponseData>?, response: Response<MovieSearchResultsListResponseData>?) {

                val responseBody = response?.body()
                if (responseBody != null) {
                    presenter.onSuccessGetMoviesSearchResults(responseBody)
                } else {
                    presenter.onFailGetMoviesSearchResults()
                }
            }

            override fun onFailure(call: Call<MovieSearchResultsListResponseData>?, t: Throwable?) {
                presenter.onFailGetMoviesSearchResults()
            }
        })
    }

    override fun getTvShowsSearchResults(presenter: ISearchDataSource.GetTvShowsSearchResults, searchText: String, pageNumber: Int) {
        val call = service.getTvSearchResults(apiKey, searchText, pageNumber)

    }
}
