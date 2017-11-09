package com.example.isabelcosta.moviesapp.data.remote.Service

import com.example.isabelcosta.moviesapp.data.datamodels.NowPlayingListResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPIService {

    companion object {

        // Endpoint parts

        const val MOVIE = "movie"
        const val NOW_PLAYING = "now_playing"
        const val API_KEY = "api_key"
    }

    // There is no need for the initial "/" because it is in the API url already

    @GET("$MOVIE/$NOW_PLAYING")
    fun getNowPlayingMovies(@Query(API_KEY) apiKey: String): Call<NowPlayingListResponseData>
}
