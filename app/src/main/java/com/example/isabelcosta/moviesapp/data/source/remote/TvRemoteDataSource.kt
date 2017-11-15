package com.example.isabelcosta.moviesapp.data.source.remote

import com.example.isabelcosta.moviesapp.data.models.MostPopularShowsListResponseData
import com.example.isabelcosta.moviesapp.data.remote.RemoteDataSource
import com.example.isabelcosta.moviesapp.data.source.ITvDataSource
import com.example.isabelcosta.moviesapp.data.source.remote.service.TvAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvRemoteDataSource : RemoteDataSource(), ITvDataSource {

    private val service: TvAPIService = retrofit.create(TvAPIService::class.java)

    override fun getMostPopularShows(presenter: ITvDataSource.GetMostPopularShows) {

        val call = service.getPopularTvShows(apiKey)

        call.enqueue(object : Callback<MostPopularShowsListResponseData> {
            override fun onResponse(call: Call<MostPopularShowsListResponseData>?, response: Response<MostPopularShowsListResponseData>?) {

                val responseBody = response?.body()
                if (responseBody != null) {
                    presenter.onSuccessGetMostPopularShows(responseBody)
                } else {
                    presenter.onFailGetMostPopularShows()
                }
            }

            override fun onFailure(call: Call<MostPopularShowsListResponseData>?, t: Throwable?) {
                presenter.onFailGetMostPopularShows()
            }
        })
    }

    override fun getTvShowDetail(presenter: ITvDataSource.GetTvShowDetail, tvShowId: Int) {
        presenter.onSuccessGetTvShowDetail()
    }

}
