package com.example.isabelcosta.moviesapp.adapters

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.data.models.MostPopularShowsListItemResponseData
import com.example.isabelcosta.moviesapp.ui.activities.BaseActivity
import com.example.isabelcosta.moviesapp.utils.getFullImageUrl
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_most_popular_shows.view.*

class MostPopularShowsAdapter(
        private val context: BaseActivity,
        private val showsList: List<MostPopularShowsListItemResponseData>
) : RecyclerView.Adapter<MostPopularShowsAdapter.MostPopularShowsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MostPopularShowsViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_most_popular_shows, parent, false)
        return MostPopularShowsViewHolder(v)
    }

    override fun onBindViewHolder(holder: MostPopularShowsViewHolder?, position: Int) {
        val item = showsList[position]
        val itemView = holder?.itemView ?: return

        itemView.mostPopularShowsItemTitle.text = item.originalName
        itemView.mostPopularShowsItemRating.text = item.voteAverage.toString()
        val imageFullPath = getFullImageUrl(item.posterPath)
        Picasso.with(context).load(imageFullPath).into(itemView.mostPopularShowsItemPosterImage)

//        itemView.setOnClickListener()
    }

    override fun getItemCount(): Int {
        return showsList.size
    }

    class MostPopularShowsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class SpacesItemDecoration(private val space: Int, private val numColumns: Int) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View,
                                    parent: RecyclerView, state: RecyclerView.State) {


            // Add right margin only for the first item to avoid double space between items
            if (parent.getChildLayoutPosition(view) % 2 == 0) {
                outRect.right = space
            }

            if (parent.getChildLayoutPosition(view) < 2) {
                outRect.top = space
            }
        }
    }
}
