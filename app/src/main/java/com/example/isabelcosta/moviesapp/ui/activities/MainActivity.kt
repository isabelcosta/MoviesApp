package com.example.isabelcosta.moviesapp.ui.activities

import android.os.Bundle
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.ui.fragments.BaseFragment
import com.example.isabelcosta.moviesapp.ui.fragments.NowPlayingMoviesFragment
import com.example.isabelcosta.moviesapp.utils.replaceActivityFragment
import kotlinx.android.synthetic.main.main_drawer_layout.*

class MainActivity : BaseActivity() {

    private val fragmentsMenuMap: HashMap<Int, BaseFragment<MainActivity>> = hashMapOf(
            R.id.menuNowPlayingMovies to NowPlayingMoviesFragment.newInstance(),
            R.id.menuPopularTvShows to NowPlayingMoviesFragment.newInstance(),
            R.id.menuSearchMovies to NowPlayingMoviesFragment.newInstance()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        populateSideMenu()

        replaceActivityFragment(fragmentManager, R.id.mainActivityFrameLayout, NowPlayingMoviesFragment.newInstance())
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.main_drawer_layout
    }

    private fun populateSideMenu() {

        supportActionBar?.setIcon(R.drawable.ic_menu_black_24dp)
        
        mainActivityNavigationView.setNavigationItemSelectedListener {
            val selectedFragment = fragmentsMenuMap[it.itemId]

            mainActivityDrawerLayout.closeDrawers()

            selectedFragment?.let {
                replaceActivityFragment(fragmentManager, R.id.mainActivityFrameLayout, it)
            }

            true
        }
//        mainActivityNavigationView.setCheckedItem(R.id.menuNowPlayingMovies)
    }
}
