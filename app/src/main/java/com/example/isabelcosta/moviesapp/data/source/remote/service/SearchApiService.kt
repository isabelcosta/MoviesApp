package com.example.isabelcosta.moviesapp.data.source.remote.service

import com.example.isabelcosta.moviesapp.data.models.MovieSearchResultsListResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiService {

    companion object {

        // Endpoint parts
        const val SEARCH = "search"
        const val MOVIE = "movie"
        const val TV = "tv"
        const val MULTI = "multi"

        // Query string
        const val API_KEY = "api_key"
        const val QUERY = "query"
        const val PAGE = "page"
    }

    @GET("$SEARCH/$MOVIE")
    fun getMoviesSearchResults(@Query(API_KEY) apiKey: String, @Query(QUERY) query: String): Call<MovieSearchResultsListResponseData>

    @GET("$SEARCH/$TV")
    fun getTvSearchResults(@Query(API_KEY) apiKey: String, @Query(QUERY) query: String): Call<MovieSearchResultsListResponseData>

//    @GET("$SEARCH/$MULTI")
//    fun getMultiSearchResults(@Query(API_KEY) apiKey: String, @Query(QUERY) query: String): Call<MovieSearchResultsListResponseData>

}
