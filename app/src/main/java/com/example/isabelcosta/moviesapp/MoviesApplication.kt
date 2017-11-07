package com.example.isabelcosta.moviesapp

import android.app.Application

class MoviesApplication : Application() {

    companion object {
        lateinit var instance: MoviesApplication
            private set
    }


    lateinit var MoviesDbApiKey : String

    override fun onCreate() {
        super.onCreate()
        instance = this
        MoviesDbApiKey = resources.getString(R.string.movies_db_api_key)
    }
}
