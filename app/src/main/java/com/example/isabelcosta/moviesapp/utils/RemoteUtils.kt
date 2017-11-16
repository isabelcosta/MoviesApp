package com.example.isabelcosta.moviesapp.utils

// Remote constants

const val API_VERSION = "3"
const val MOVIES_API_ENDPOINT = "https://api.themoviedb.org/$API_VERSION/"
const val IMAGES_API_ENDPOINT = "https://image.tmdb.org/t/p/w500"

// Helpful methods

fun getFullImageUrl(imageName: String): String = "$IMAGES_API_ENDPOINT$imageName"
