package com.example.isabelcosta.moviesapp.utils

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/*
* Item Decoration
* */

class GridListSpacesItemDecoration(private val space: Int, private val numColumns: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {

        val lastColumn = numColumns
        val margin = space / 2

        // the last element of an row won't have the right margin
        if ((parent.getChildLayoutPosition(view) + 1) % lastColumn != 0) {
            outRect.right = margin
        }

        // all but the last element of the row has left margin
        if ((parent.getChildLayoutPosition(view) + 1) % lastColumn != 1) {
            outRect.left = margin
        }

        if (parent.getChildLayoutPosition(view) >= numColumns) {
            outRect.top = space
        }
    }
}

class LinearListSpacesItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {

        if (parent.getChildLayoutPosition(view) != 0) {
            outRect.top = space
        }
    }
}