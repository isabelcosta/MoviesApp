package com.example.isabelcosta.moviesapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.data.models.MovieSearchResultsItemResponseData
import com.example.isabelcosta.moviesapp.ui.activities.BaseActivity
import com.example.isabelcosta.moviesapp.utils.setImageUsingPicasso
import kotlinx.android.synthetic.main.item_movie_search_result.view.*

class SearchMoviesAdapter(
        private val context: BaseActivity,
        private val moviesList: List<MovieSearchResultsItemResponseData>,
        private val openDetailFunction: (movieDetailId: Int) -> Unit
) : RecyclerView.Adapter<SearchMoviesAdapter.MovieSearchResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieSearchResultViewHolder =
            MovieSearchResultViewHolder(
                    LayoutInflater.from(context)
                            .inflate(R.layout.item_movie_search_result, parent, false)
            )

    override fun onBindViewHolder(holder: MovieSearchResultViewHolder?, position: Int) {
        val item = moviesList[position]
        val itemView = holder?.itemView ?: return

        item.posterPath?.let {
            setImageUsingPicasso(context, item.posterPath, itemView.searchResultItemPosterImage)
        }
        itemView.searchMovieItemTitle.text = item.title
        itemView.searchMovieItemReleaseDate.text = item.releaseDate
        itemView.searchMovieItemDescription.text = item.overview
        itemView.setOnClickListener { openDetailFunction(item.movieId) }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class MovieSearchResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
