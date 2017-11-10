package com.example.isabelcosta.moviesapp.utils

import android.content.Context
import android.widget.Toast

fun showToastAlert(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

// Dialog Utils
