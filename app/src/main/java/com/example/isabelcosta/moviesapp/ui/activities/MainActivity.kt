package com.example.isabelcosta.moviesapp.ui.activities

import android.os.Bundle
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.ui.fragments.NowPlayingMoviesFragment
import com.example.isabelcosta.moviesapp.utils.replaceActivityFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceActivityFragment(fragmentManager, R.id.mainActivityFrameLayout, NowPlayingMoviesFragment.newInstance())
    }
}
