package com.example.isabelcosta.moviesapp.ui.activities

import android.os.Bundle
import android.view.Gravity
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.ui.fragments.BaseFragment
import com.example.isabelcosta.moviesapp.ui.fragments.MostPopularShowsFragment
import com.example.isabelcosta.moviesapp.ui.fragments.NowPlayingMoviesFragment
import com.example.isabelcosta.moviesapp.utils.addFragmentToActivity
import com.example.isabelcosta.moviesapp.utils.replaceActivityFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_drawer_layout.*

class MainActivity : BaseActivity() {

    private val fragmentsMenuMap: HashMap<Int, BaseFragment<MainActivity>> = hashMapOf(
            R.id.menuNowPlayingMovies to NowPlayingMoviesFragment.newInstance(),
            R.id.menuPopularTvShows to MostPopularShowsFragment.newInstance(),
            R.id.menuSearchMovies to NowPlayingMoviesFragment.newInstance()
    )

    private val fragmentsMenuTitles: HashMap<Int, Int> = hashMapOf (
            R.id.menuNowPlayingMovies to R.string.screen_title_now_playing_movies,
            R.id.menuPopularTvShows to R.string.screen_title_popular_tv_shows,
            R.id.menuSearchMovies to R.string.screen_title_search_movies
    )

    private var selectedId: Int = R.id.menuNowPlayingMovies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        populateSideMenu()
        populateToolbar()
        initMainScreen()
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.main_drawer_layout
    }

    private fun initMainScreen() {
        replaceFragment(NowPlayingMoviesFragment.newInstance())
        mainToolbar.setTitle(R.string.screen_title_now_playing_movies)
    }

    private fun populateSideMenu() {

        mainActivityNavigationView.setNavigationItemSelectedListener {
            selectedId = it.itemId
            val selectedFragment = fragmentsMenuMap[selectedId]

            mainActivityDrawerLayout.closeDrawers()

            selectedFragment?.let {
                replaceFragment(it)
                mainToolbar.setTitle(fragmentsMenuTitles[selectedId]!!)
                mainActivityNavigationView.setCheckedItem(selectedId)
            }

            true
        }
    }

    private fun populateToolbar() {
        mainToolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp)
        mainToolbar.setNavigationOnClickListener { mainActivityDrawerLayout.openDrawer(Gravity.START) }
    }

    fun setToolbarTitle(titleRscId: Int) = mainToolbar?.setTitle(titleRscId)

    private fun toolbarSet(showMenuIcon: Boolean){

        if (showMenuIcon) {
            mainToolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp)
            mainToolbar.setNavigationOnClickListener { mainActivityDrawerLayout.openDrawer(Gravity.START) }
        } else {
            mainToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
            mainToolbar.setNavigationOnClickListener { onBackPressed() }
        }
    }

    fun replaceFragment(fragment: BaseFragment<MainActivity>) = replaceActivityFragment(fragmentManager, R.id.mainFrameLayout, fragment)
    fun addFragment(fragment: BaseFragment<MainActivity>) = addFragmentToActivity(fragmentManager, R.id.mainFrameLayout, fragment)

    fun navigateToFragmentToolbarSet(isNextFragmentInitial: Boolean) {
        toolbarSet(isNextFragmentInitial)
    }

    override fun onBackPressed() {

        val count = fragmentManager.backStackEntryCount

        if (count == 0) {
            super.onBackPressed()
        } else {
            navigateToFragmentToolbarSet(true)
            setToolbarTitle(fragmentsMenuTitles[selectedId]!!)
            fragmentManager.popBackStack()
        }
    }

}
