package com.example.isabelcosta.moviesapp.data.remote

import com.example.isabelcosta.moviesapp.data.models.MovieDetailResponseData
import com.example.isabelcosta.moviesapp.data.models.NowPlayingListResponseData
import com.example.isabelcosta.moviesapp.data.source.IMoviesDataSource
import com.example.isabelcosta.moviesapp.data.source.remote.service.MoviesAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRemoteDataSource : RemoteDataSource(), IMoviesDataSource {

    private val service: MoviesAPIService = retrofit.create(MoviesAPIService::class.java)

    override fun getNowPlayingMovies(presenter: IMoviesDataSource.GetNowPlayingMovies) {

        val call = service.getNowPlayingMovies(apiKey)

        call.enqueue(object : Callback<NowPlayingListResponseData> {
            override fun onResponse(call: Call<NowPlayingListResponseData>?, response: Response<NowPlayingListResponseData>?) {

                val responseBody = response?.body()
                if (responseBody != null) {
                    presenter.onSuccessGetNowPlayingMovies(responseBody)
                } else {
                    presenter.onFailGetNowPlayingMovies()
                }
            }

            override fun onFailure(call: Call<NowPlayingListResponseData>?, t: Throwable?) {
                presenter.onFailGetNowPlayingMovies()
            }
        })
    }

    override fun getMovieDetail(presenter: IMoviesDataSource.GetMovieDetail, movieId: Int) {

        val call = service.getMovieDetail(movieId, apiKey)

        call.enqueue(object : Callback<MovieDetailResponseData> {
            override fun onResponse(call: Call<MovieDetailResponseData>?, response: Response<MovieDetailResponseData>?) {

                val responseBody = response?.body()
                if (responseBody != null) {
                    presenter.onSuccessGetMovieDetail(responseBody)
                } else {
                    presenter.onFailGetMovieDetail()
                }
            }

            override fun onFailure(call: Call<MovieDetailResponseData>?, t: Throwable?) {
                presenter.onFailGetMovieDetail()
            }
        })
    }
}