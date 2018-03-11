package com.example.isabelcosta.moviesapp.utils

import android.os.Bundle

const val MOVIE_DETAIL_ID_BUNDLE_ARG = "::MOVIE_DETAIL_BUNDLE_ARG::"
const val TV_SHOW_ID_BUNDLE_ARG = "::TV_SHOW_ID_BUNDLE_ARG::"

inline fun <reified R: Any> Bundle.getAnyWithoutCast(key: String) = this.get(key) as R
