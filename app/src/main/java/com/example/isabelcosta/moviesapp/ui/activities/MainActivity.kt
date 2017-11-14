package com.example.isabelcosta.moviesapp.ui.activities

import android.os.Bundle
import android.view.Gravity
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.ui.fragments.BaseFragment
import com.example.isabelcosta.moviesapp.ui.fragments.NowPlayingMoviesFragment
import com.example.isabelcosta.moviesapp.utils.addFragmentToActivity
import com.example.isabelcosta.moviesapp.utils.replaceActivityFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_drawer_layout.*

class MainActivity : BaseActivity() {

    private val fragmentsMenuMap: HashMap<Int, BaseFragment<MainActivity>> = hashMapOf(
            R.id.menuNowPlayingMovies to NowPlayingMoviesFragment.newInstance(),
            R.id.menuPopularTvShows to NowPlayingMoviesFragment.newInstance(),
            R.id.menuSearchMovies to NowPlayingMoviesFragment.newInstance()
    )

    private val fragmentsMenuTitles: HashMap<Int, Int> = hashMapOf (
            R.id.menuNowPlayingMovies to R.string.menu_now_playing_movies,
            R.id.menuPopularTvShows to R.string.menu_popular_tv_shows,
            R.id.menuSearchMovies to R.string.menu_search_movies
    )

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
        mainToolbar.setTitle(R.string.menu_now_playing_movies)
    }

    private fun populateSideMenu() {

        mainActivityNavigationView.setNavigationItemSelectedListener {
            val selectedFragment = fragmentsMenuMap[it.itemId]

            mainActivityDrawerLayout.closeDrawers()

            selectedFragment?.let {
                replaceFragment(it)
            }

            mainToolbar.setTitle(fragmentsMenuTitles[it.itemId]!!)
            mainActivityNavigationView.setCheckedItem(it.itemId)

            true
        }
    }

    private fun populateToolbar() {
        mainToolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp)
        mainToolbar.setNavigationOnClickListener { mainActivityDrawerLayout.openDrawer(Gravity.START) }
    }

    fun replaceFragment(fragment: BaseFragment<MainActivity>) = replaceActivityFragment(fragmentManager, R.id.mainFrameLayout, fragment)
    fun addFragment(fragment: BaseFragment<MainActivity>) = addFragmentToActivity(fragmentManager, R.id.mainFrameLayout, fragment)
}
