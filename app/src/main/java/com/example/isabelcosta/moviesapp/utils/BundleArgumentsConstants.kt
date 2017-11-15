package com.example.isabelcosta.moviesapp.utils

import android.os.Bundle

const val MOVIE_DETAIL_ID_BUNDLE_ARG = "_MOVIE_DETAIL_BUNDLE_ARG_"

inline fun <reified R: Any> Bundle.getAnyWithoutCast(key: String) = this.get(key) as R
