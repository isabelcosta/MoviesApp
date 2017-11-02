package com.example.isabelcosta.moviesapp.adapters


import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.isabelcosta.moviesapp.data.entities.NowPlayingListItemResponseData

class NowPlayingMoviesAdapter : RecyclerView.Adapter<NowPlayingMoviesAdapter.NowPlayingMovieViewHolder>() {
    override fun getItemCount(): Int {
        TODO("not implemented")
    }

    override fun onBindViewHolder(holder: NowPlayingMovieViewHolder?, position: Int) {
        TODO("not implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NowPlayingMovieViewHolder {
        TODO("not implemented")
    }

    class NowPlayingMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: NowPlayingListItemResponseData, listener: (NowPlayingListItemResponseData) -> Unit) = with(itemView) {
//            itemTitle.text = item.title
//            itemImage.loadUrl(item.url)
            setOnClickListener { listener(item) }
        }
    }
}