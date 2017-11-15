package com.example.isabelcosta.moviesapp.utils

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/*
* Item Decoration
* */

class GridListSpacesItemDecoration(private val space: Int, private val numColumns: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {

        val lastColumn = numColumns
        // the last element of an row won't have the right margin
        if ((parent.getChildLayoutPosition(view) + 1) % lastColumn != 0) {
            outRect.right = space
        }

        if (parent.getChildLayoutPosition(view) >= numColumns) {
            outRect.top = space
        }
    }
}