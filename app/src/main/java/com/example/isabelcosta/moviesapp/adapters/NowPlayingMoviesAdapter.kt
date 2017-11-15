package com.example.isabelcosta.moviesapp.adapters

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.data.models.NowPlayingListItemResponseData
import com.example.isabelcosta.moviesapp.ui.activities.BaseActivity
import com.example.isabelcosta.moviesapp.ui.activities.MovieDetailScreen
import com.example.isabelcosta.moviesapp.utils.MOVIE_DETAIL_ID_BUNDLE_ARG
import com.example.isabelcosta.moviesapp.utils.getFullImageUrl
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_now_playing_movies.view.*

class NowPlayingMoviesAdapter (
        private val context : BaseActivity,
        private val moviesList: List<NowPlayingListItemResponseData>
) : RecyclerView.Adapter<NowPlayingMoviesAdapter.NowPlayingMovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NowPlayingMovieViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_now_playing_movies, parent, false)
        return NowPlayingMovieViewHolder(v)
    }

    override fun onBindViewHolder(holder: NowPlayingMovieViewHolder?, position: Int) {
        val item = moviesList[position]
        val itemView = holder?.itemView ?: return

//        itemView.nowPlayingMoviesItemTitle.text = item.movieTitle
//        itemView.nowPlayingMoviesItemDescription.text = item.overview
        val imageFullPath = getFullImageUrl(item.posterPath)
        Picasso.with(context).load(imageFullPath).into(itemView.nowPlayingMoviesItemPosterImage)

        itemView.setOnClickListener {
            val intent = Intent(context, MovieDetailScreen::class.java).apply {
                putExtra(MOVIE_DETAIL_ID_BUNDLE_ARG, item.movieId)
            }
            startActivity(context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class NowPlayingMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}