package com.example.isabelcosta.moviesapp.data.source.remote.service

interface TvAPIService {
    companion object {

        // Endpoint parts
        const val TV = "tv"

        // Path parameters
        const val TV_ID = "{tv_id}"

        // Query string
        const val API_KEY = "api_key"
    }
}
