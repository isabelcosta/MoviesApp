package com.example.isabelcosta.moviesapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RemoteDataSource {

    companion object {
        private val API_VERSION = "3"
        val MOVIES_API_URL = "https://api.themoviedb.org/$API_VERSION/"
    }

    protected val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(MOVIES_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
