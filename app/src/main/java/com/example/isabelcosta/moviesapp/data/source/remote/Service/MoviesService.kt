package com.example.isabelcosta.moviesapp.data.remote.Service

import com.example.isabelcosta.moviesapp.data.entities.NowPlayingListResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    companion object {

        // Endpoint parts

        const val MOVIE = "movie"
        const val NOW_PLAYING = "now_playing"
        const val API_KEY = "api_key"
    }

    @GET("/$MOVIE/$NOW_PLAYING")
    fun getNowPlayingMovies(@Query(API_KEY) apiKey : String) : Call<NowPlayingListResponseData>
}
