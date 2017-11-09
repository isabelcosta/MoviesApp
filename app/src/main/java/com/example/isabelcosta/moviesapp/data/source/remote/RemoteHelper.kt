package com.example.isabelcosta.moviesapp.data.source.remote

const val API_VERSION = "3"
const val MOVIES_API_ENDPOINT = "https://api.themoviedb.org/$API_VERSION/"
const val IMAGES_API_ENDPOINT = "https://image.tmdb.org/t/p/w500"

val getFullImageUrl: (String) -> String = {imageName -> "$IMAGES_API_ENDPOINT$imageName"}
