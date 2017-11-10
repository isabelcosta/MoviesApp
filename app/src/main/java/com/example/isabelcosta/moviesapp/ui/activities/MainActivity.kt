package com.example.isabelcosta.moviesapp.ui.activities

import android.os.Bundle
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.ui.fragments.NowPlayingMoviesFragment
import com.example.isabelcosta.moviesapp.utils.replaceActivityFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceActivityFragment(fragmentManager, R.id.mainActivityFrameLayout, NowPlayingMoviesFragment.newInstance())
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main
    }
}
