package com.example.isabelcosta.moviesapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.data.models.NowPlayingListItemResponseData
import com.example.isabelcosta.moviesapp.ui.activities.BaseActivity
import com.example.isabelcosta.moviesapp.utils.setImageUsingPicasso
import kotlinx.android.synthetic.main.item_now_playing_movies.view.*

class NowPlayingMoviesAdapter(
        private val context: BaseActivity,
        private val moviesList: List<NowPlayingListItemResponseData>,
        private val openDetailFunction: (movieDetailId: Int) -> Unit
) : RecyclerView.Adapter<NowPlayingMoviesAdapter.NowPlayingMovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NowPlayingMovieViewHolder =
            NowPlayingMovieViewHolder(
                    LayoutInflater.from(context)
                            .inflate(R.layout.item_now_playing_movies, parent, false)
            )

    override fun onBindViewHolder(holder: NowPlayingMovieViewHolder?, position: Int) {
        val item = moviesList[position]
        val itemView = holder?.itemView ?: return

        itemView.nowPlayingMoviesItemTitle.text = item.movieTitle
        itemView.nowPlayingMoviesItemDescription.text = item.overview
        setImageUsingPicasso(context, item.posterPath, itemView.nowPlayingMoviesItemPosterImage)
        itemView.setOnClickListener { openDetailFunction(item.movieId) }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class NowPlayingMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}