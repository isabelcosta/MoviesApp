package com.example.isabelcosta.moviesapp.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.adapters.SearchMoviesAdapter
import com.example.isabelcosta.moviesapp.data.models.MovieSearchResultsListResponseData
import com.example.isabelcosta.moviesapp.extensions.afterTextChanged
import com.example.isabelcosta.moviesapp.extensions.hidePartially
import com.example.isabelcosta.moviesapp.extensions.show
import com.example.isabelcosta.moviesapp.presenters.SearchMoviesPresenter
import com.example.isabelcosta.moviesapp.ui.activities.MainActivity
import com.example.isabelcosta.moviesapp.ui.callbacks.ISearchMoviesUiCallback
import com.example.isabelcosta.moviesapp.utils.LinearListSpacesItemDecoration
import kotlinx.android.synthetic.main.fragment_search_movies.view.*
import kotlinx.android.synthetic.main.section_search.*

class SearchMoviesFragment : BaseFragment<MainActivity>(), ISearchMoviesUiCallback {

    private var presenter = SearchMoviesPresenter(this)
    private lateinit var moviesResultResponseData: MovieSearchResultsListResponseData
    private val openDetail: (Int) -> Unit =
            { movieDetailId ->
                screen.navigateToFragmentToolbarSet(false)
                screen.replaceFragment(MovieDetailFragment.newInstance(movieDetailId))
            }

    override fun getLayoutResourceId(): Int = R.layout.fragment_search_movies
    override fun getTitleResourceId(): Int = R.string.screen_title_search_movies

    companion object {
        fun newInstance(): SearchMoviesFragment {
            return SearchMoviesFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        searchButton.setOnClickListener {

            val text = searchInputEditText.text.toString()

            if (text.isNotEmpty()) {
                // Fetch movies search results list
                presenter.searchMovies(searchInputEditText.text.toString())
            }
        }

        searchInputEditText.afterTextChanged {
            if (it.isEmpty()) {
                clearSearchButton.hidePartially()
            } else {
                clearSearchButton.show()
            }
        }

        clearSearchButton.setOnClickListener {
            searchInputEditText.text.clear()
        }
    }

    /*
        Callback Methods
     */
    override fun onShowMoviesSearchResults(moviesResults: MovieSearchResultsListResponseData) {
        moviesResultResponseData = moviesResults
        val moviesList = moviesResults.results
        val moviesResultsAdapter = SearchMoviesAdapter(screen, moviesList, openDetail)

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.generic_14dp)
        val itemDecoration = LinearListSpacesItemDecoration(spacingInPixels)

        rootView.searchMoviesRecyclerView.apply {
            addItemDecoration(itemDecoration)
            layoutManager = LinearLayoutManager(screen)
            adapter = moviesResultsAdapter
        }
    }

    override fun onFetchFailMoviesSearchResults() {

    }
}