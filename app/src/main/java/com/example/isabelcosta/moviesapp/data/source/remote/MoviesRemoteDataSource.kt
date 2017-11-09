package com.example.isabelcosta.moviesapp.data.remote

import com.example.isabelcosta.moviesapp.MoviesApplication
import com.example.isabelcosta.moviesapp.data.datamodels.NowPlayingListResponseData
import com.example.isabelcosta.moviesapp.data.remote.Service.MoviesAPIService
import com.example.isabelcosta.moviesapp.data.source.IMoviesDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRemoteDataSource : RemoteDataSource(), IMoviesDataSource {

    private val service : MoviesAPIService = retrofit.create(MoviesAPIService::class.java)

    override fun getNowPlayingMovies(presenter: IMoviesDataSource.GetNowPlayingMovies) {

        val call = service.getNowPlayingMovies(MoviesApplication.instance.MoviesDbApiKey)

        call.enqueue(object: Callback<NowPlayingListResponseData> {
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

}