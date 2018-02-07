package com.example.isabelcosta.moviesapp.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.KeyEvent
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.adapters.SearchMoviesAdapter
import com.example.isabelcosta.moviesapp.data.models.MovieSearchResultsItemResponseData
import com.example.isabelcosta.moviesapp.extensions.afterTextChanged
import com.example.isabelcosta.moviesapp.extensions.hideFully
import com.example.isabelcosta.moviesapp.extensions.hidePartially
import com.example.isabelcosta.moviesapp.extensions.show
import com.example.isabelcosta.moviesapp.presenters.SearchMoviesPresenter
import com.example.isabelcosta.moviesapp.ui.activities.MainActivity
import com.example.isabelcosta.moviesapp.ui.callbacks.ISearchMoviesUiCallback
import com.example.isabelcosta.moviesapp.utils.LinearListSpacesItemDecoration
import kotlinx.android.synthetic.main.fragment_search_movies.*
import kotlinx.android.synthetic.main.partial_empty_results.*
import kotlinx.android.synthetic.main.partial_fetch_more.*
import kotlinx.android.synthetic.main.section_search.*



class SearchMoviesFragment : ExecuteRequestFragment<MainActivity>(), ISearchMoviesUiCallback {

    private var presenter = SearchMoviesPresenter(this)
    private lateinit var moviesResultsAdapter: SearchMoviesAdapter
    private lateinit var moviesResultResponseDataList: List<MovieSearchResultsItemResponseData>
    private val openMovieDetail: (Int) -> Unit =
            { movieId ->
                screen.navigateToFragmentToolbarSet(false)
                screen.replaceFragment(MovieDetailFragment.newInstance(movieId))
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
            performSearch()
        }

        searchInputEditText.afterTextChanged {
            if (it.isEmpty()) {
                clearSearchButton.hidePartially()
            } else {
                clearSearchButton.show()
            }
        }

        searchInputEditText.setOnKeyListener { _, keyCode, event ->
            if (KeyEvent.ACTION_DOWN == event.action) {
                when (keyCode) {
                    KeyEvent.KEYCODE_ENTER -> {
                        screen.hideKeyboard()
                        performSearch()
                        true
                    }
                }
            }
            false
        }
        clearSearchButton.setOnClickListener {
            searchInputEditText.text.clear()
        }

        setSearchAdapter()

        fetchMoreButton.setOnClickListener {
            presenter.searchMovies(searchInputEditText.text.toString())
        }
    }

    private fun performSearch() {
        val text = searchInputEditText.text.toString()
        if (text.isNotEmpty()) {
            // Fetch movies search results list
            presenter.searchMovies(searchInputEditText.text.toString())
        }
    }

    override fun onResume() {
        super.onResume()

        // Try to show items after returning from detail fragment onBackPress
//        moviesResultsAdapter.apply {
//            clearElements()
//            addElements(moviesResultResponseDataList)
//            notifyDataSetChanged()
//        }
    }

    /*
        Callback Methods
     */

    override fun onShowLastMoviesSearchResults(movieResults: List<MovieSearchResultsItemResponseData>, isFirstQueryResult: Boolean) {

        fetchMoreButton.hideFully()
        setupViewsOnResultCallback(true)
        showMoviesSearchResults(movieResults, isFirstQueryResult)
    }

    override fun onShowMoviesSearchResultsWithMoreToCome(movieResults: List<MovieSearchResultsItemResponseData>, isFirstQueryResult: Boolean) {
        fetchMoreButton.show()
        setupViewsOnResultCallback(true)
        showMoviesSearchResults(movieResults, isFirstQueryResult)
    }

    override fun onShowZeroResults(searchText: String) {
        moviesResultsAdapter.clearElements()
        setupViewsOnResultCallback(false, searchText)
    }

    override fun onFetchFailMoviesSearchResults() {
        setupViewsOnResultCallback(false)
        fetchMoreButton.hideFully()
    }

    /*
        Private Methods
    */

    private fun showMoviesSearchResults(movieResults: List<MovieSearchResultsItemResponseData>, isFirstQueryResult: Boolean) {

        if (isFirstQueryResult) {
            moviesResultsAdapter.clearElements()
            moviesResultResponseDataList = movieResults
        } else {
            moviesResultResponseDataList.plus(movieResults)
        }
        moviesResultsAdapter.addElements(movieResults)

        emptyResultsView.hideFully()
    }

    private fun setSearchAdapter() {
        moviesResultsAdapter = SearchMoviesAdapter(screen, emptyList(), openMovieDetail)

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.generic_14dp)
        val itemDecoration = LinearListSpacesItemDecoration(spacingInPixels)

        searchMoviesRecyclerView.apply {
            addItemDecoration(itemDecoration)
            layoutManager = LinearLayoutManager(screen)
            adapter = moviesResultsAdapter
        }
    }

    private fun setupViewsOnResultCallback(hasResults: Boolean, searchText: String = ""){
        if (hasResults) {
            searchMoviesRecyclerView.show()
            emptyResultsView.hideFully()
        } else {
            fetchMoreButton.hideFully()
            searchMoviesRecyclerView.hideFully()

            val emptyResultsText = getString(R.string.empty_results, getString(R.string.movie), searchText)
            emptySearchResultsTextView.text = emptyResultsText
            emptyResultsView.show()
        }
    }
}
