package com.example.isabelcosta.moviesapp.data.remote

import com.example.isabelcosta.moviesapp.MoviesApplication
import com.example.isabelcosta.moviesapp.utils.MOVIES_API_ENDPOINT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


abstract class RemoteDataSource {

    protected val apiKey: String = MoviesApplication.instance.MoviesDbApiKey

    private val httpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

    protected val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(MOVIES_API_ENDPOINT)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}
