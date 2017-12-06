package com.example.isabelcosta.moviesapp.utils

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun setImageUsingPicasso(context: Context, partialPath: String?, imageView: ImageView) =
    partialPath?.let {
        Picasso.with(context).load(getFullImageUrl(partialPath)).into(imageView)
    }
