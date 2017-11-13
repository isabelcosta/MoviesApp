package com.example.isabelcosta.moviesapp.data.source.remote.service

import com.example.isabelcosta.moviesapp.data.models.MovieDetailResponseData
import com.example.isabelcosta.moviesapp.data.models.NowPlayingListResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesAPIService {

    companion object {

        // Endpoint parts
        const val MOVIE = "movie"
        const val NOW_PLAYING = "now_playing"

        // Path parameters
        const val MOVIE_ID = "movie_id"

        // Query string
        const val API_KEY = "api_key"
    }

    // There is no need for the initial "/" because it is in the API url already

    @GET("$MOVIE/$NOW_PLAYING")
    fun getNowPlayingMovies(@Query(API_KEY) apiKey: String): Call<NowPlayingListResponseData>

    @GET("$MOVIE/{$MOVIE_ID}")
    fun getMovieDetail(@Path(MOVIE_ID) movieId: Int, @Query(API_KEY) apiKey: String): Call<MovieDetailResponseData>

}
