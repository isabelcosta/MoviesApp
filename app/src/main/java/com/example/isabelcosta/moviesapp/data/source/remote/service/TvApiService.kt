package com.example.isabelcosta.moviesapp.data.source.remote.service

import com.example.isabelcosta.moviesapp.data.models.MostPopularShowsListResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TvApiService {

    @GET("$TV/$POPULAR")
    fun getPopularTvShows(@Query(API_KEY) apiKey: String): Call<MostPopularShowsListResponseData>

}
