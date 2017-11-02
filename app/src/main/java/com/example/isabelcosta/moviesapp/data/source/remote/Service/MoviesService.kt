package com.example.isabelcosta.moviesapp.data.remote.Service

import com.example.isabelcosta.moviesapp.data.entities.NowPlayingListResponseData
import retrofit2.Callback
import retrofit2.http.GET

interface MoviesService {

    companion object {

        // Endpoint parts

        const val MOVIE = "movie"
        const val NOW_PLAYING = "now_playing"
    }

    @GET("/$MOVIE/$NOW_PLAYING")
    fun getNowPlayingMovies(callback : Callback<NowPlayingListResponseData>)
}
