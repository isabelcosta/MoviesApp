package com.example.isabelcosta.moviesapp.data.source.remote.service

import com.example.isabelcosta.moviesapp.data.models.MostPopularShowsListResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TvAPIService {

    companion object {

        // Endpoint parts
        const val TV = "tv"
        const val POPULAR = "popular"

        // Path parameters
        const val TV_ID = "tv_id"

        // Query string
        const val API_KEY = "api_key"
    }

    @GET("$TV/$POPULAR")
    fun getPopularTvShows(@Query(API_KEY) apiKey: String): Call<MostPopularShowsListResponseData>

}
