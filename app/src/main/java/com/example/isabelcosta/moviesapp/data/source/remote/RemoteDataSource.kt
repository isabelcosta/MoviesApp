package com.example.isabelcosta.moviesapp.data.remote

import com.example.isabelcosta.moviesapp.data.source.remote.MOVIES_API_ENDPOINT
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RemoteDataSource {

    protected val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(MOVIES_API_ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
