package com.example.isabelcosta.moviesapp

import android.app.Application

class MoviesApplication : Application() {

    companion object {
        lateinit var instance: MoviesApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
