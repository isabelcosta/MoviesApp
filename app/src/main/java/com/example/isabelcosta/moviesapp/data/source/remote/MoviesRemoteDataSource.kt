package com.example.isabelcosta.moviesapp.data.remote

import com.example.isabelcosta.moviesapp.data.entities.NowPlayingListResponseData
import com.example.isabelcosta.moviesapp.data.remote.Service.MoviesService
import com.example.isabelcosta.moviesapp.data.source.IMoviesDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRemoteDataSource : RemoteDataSource(), IMoviesDataSource {

    val service : MoviesService = retrofit!!.create(MoviesService::class.java)

    override fun getNowPlayingMovies(iPresenter: IMoviesDataSource.GetNowPlayingMovies) {

        service.getNowPlayingMovies(object : Callback<NowPlayingListResponseData> {
            override fun onResponse(call: Call<NowPlayingListResponseData>?, response: Response<NowPlayingListResponseData>?) {
                iPresenter.onSuccessGetNowPlayingMovies(response?.body())
            }

            override fun onFailure(call: Call<NowPlayingListResponseData>?, t: Throwable?) {
                iPresenter.onFailGetNowPlayingMovies()
            }
        })
    }

}